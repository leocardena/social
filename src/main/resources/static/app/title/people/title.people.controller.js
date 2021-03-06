(function () {
	
	'use strict';
	
	angular
			.module('social.title')
			.controller('TitlePeopleController', TitlePeopleController);
	
	TitlePeopleController.$inject = ['personSummaryPrepService', 'personMoviesPrepService',
	                                 'personShowsPrepService', '$stateParams', 'TmdbPersonService', 'TmdbMovieService',
	                                 'TmdbShowService', '$state', '$window', 'DomainActorService'];
	
	/*@ngInject*/
	function TitlePeopleController(personSummaryPrepService, personMoviesPrepService,
			personShowsPrepService, $stateParams, TmdbPersonService, TmdbMovieService, TmdbShowService, $state,
			$window, DomainActorService) {
		
		var vm = this;
		vm.people = personSummaryPrepService;
		vm.people.actor = personShowsPrepService.cast.concat(personMoviesPrepService.cast);
		vm.people.production =  personMoviesPrepService.crew.production.concat(personShowsPrepService.crew.production);
		vm.imageNotAvailable = 'content/images/search/phosto-not-available.jpg';
		vm.people.userRating = { note : 0, id: 0 };
		vm.peopleDoesntExist = false;
    	vm.isEvaluating = false;
		var startActor = 0;
		var startProduction = 0;
		var endActor = vm.people.actor.length >= 8 ? 8 : vm.people.actor.length;
		var endProduction = vm.people.production.length >= 8 ? 8 : vm.people.production.length
		var maxVisualisedActor = endActor;
		var maxVisitedProduction = endProduction;
		vm.loadMoreActorIsDisabled = vm.people.actor.length == endActor ? true : false;
		vm.loadMoreProductionIsDisabled = vm.people.production.length == endProduction ? true : false;
		
		/*methods*/
		vm.loadMoreActor = _loadMoreActor;
		vm.loadMoreProduction = _loadMoreProduction;
		vm.goToMovie = _goToMovie;
		vm.goToShow = _goToShow;
		vm.evaluate = _evaluate;
		vm.deleteRating = _deleteRating;
		
		_init();
		
        function _evaluate() {
        	if (vm.people.userRating.id !== 0) {
        		_editRating();
        		return;
        	};
        	       	
        	vm.isEvaluating = true;
        	DomainActorService.postUserRating({
        		actorId : $stateParams.traktSlug
	     	}, {
     			imdb: vm.people.ids.imdb,
     			name: vm.people.name,
     		    country: vm.people.country ? vm.people.country : 'UNKNOWN',
     		    rating: {
     		    	note: vm.people.userRating.note
     		    }
     		}).$promise.then(function (data) {
	        	vm.isEvaluating = false;
	        	_loadActorDetails();
	     	}).catch(function (err) {
	        	vm.isEvaluating = false;
	     	});
        }
        
        function _editRating() {
        	vm.isEvaluating = true;
        	DomainActorService.putUserRating({
        		actorId : $stateParams.traktSlug,
        		userRatingId: vm.people.userRating.id
	     	}, {note: vm.people.userRating.note}).$promise.then(function (data) {
	        	vm.isEvaluating = false;
	        	_loadActorDetails();
	     	}).catch(function (err) {
	        	vm.isEvaluating = false;
	     	});
        }
        
        function _deleteRating() {
        	if (vm.people.userRating.note == 0) return;
        	
        	vm.isEvaluating = true;
        	DomainActorService.deleteUserRating({
        		actorId : $stateParams.traktSlug,
	     		userRatingId : vm.people.userRating.id
	     	}).$promise.then(function (data) {
	        	vm.isEvaluating = false;
	    		vm.people.userRating = { note : 0, id: 0 };
	    		_loadActorDetails();
	     	}).catch(function (err) {
	        	vm.isEvaluating = false;
	     	});
        }
        
    	function _loadActorDetails() {
    		DomainActorService.getActor({
    			actorId : $stateParams.traktSlug
	     	}).$promise.then(function (data) {
	     		vm.people.domain = data;
	     		vm.peopleDoesntExist = false;
	     		 _loadUserRating(vm.people.domain.rating.idRatingParent);
	     	}).catch(function (err) {
	     		vm.peopleDoesntExist = true;
	     	});
    	}
    	
    	function _loadUserRating(idRatingParent) {
    		DomainActorService.getUserRating({
    			actorId : $stateParams.traktSlug,
	     		idRatingParent: idRatingParent
	     	}).$promise.then(function (data) {
	     		vm.people.userRating = data;
	     	}).catch(function (err) {
	    		vm.people.userRating = { note : 0, id: 0 };
	     	});
    	}
		
		function _init() {

			_checkPeopleImages();
			_calculateAge(new Date(vm.people.birthday));
			_loadMoviesAndShowsActorImages();
			_loadMoviesAndShowProductionImages();
			_loadActorDetails();
			$window.document.title = vm.people.name;
			
			function _checkPeopleImages() {
				if ($stateParams.people) {
					if ($stateParams.people.ids.slug === $stateParams.traktSlug) {
						vm.people.images = $stateParams.people.images.poster;
					} else {
						_loadPersonImages();
					}
				} else {
					_loadPersonImages();
				}
			}
			
			function _calculateAge(dateString) {
				  var today = new Date();
				  var birthDate = new Date(dateString);
				  var age = today.getFullYear() - birthDate.getFullYear();
				  var m = today.getMonth() - birthDate.getMonth();
				  if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
				      age--;
				  }
				  vm.people.age = age;
			}
			
			function _loadMoviesAndShowsActorImages() {
				for (var i = startActor; i < endActor; i++) {
					if (vm.people.actor[i].movie) {
						_loadMovieImage(vm.people.actor[i].movie.ids.tmdb, i).then(function (data) {
							vm.people.actor[data.pos].movie.images = data;
						})
					} else {
						_loadShowImage(vm.people.actor[i].show.ids.tmdb, i).then(function (data) {
							vm.people.actor[data.pos].show.images = data;
						})
					}
				}
				vm.displayActorArray = vm.people.actor.slice(startActor, endActor);
				startActor = endActor;
			}
			
			function _loadMoviesAndShowProductionImages() {
				for (var i = startProduction; i < endProduction; i++) {
					if (vm.people.production[i].movie) {
						_loadMovieImage(vm.people.production[i].movie.ids.tmdb, i).then(function (data) {
							vm.people.production[data.pos].movie.images = data;
						})
					} else {
						_loadShowImage(vm.people.production[i].show.ids.tmdb, i).then(function (data) {
							vm.people.production[data.pos].show.images = data;
						})
					}
				}
				vm.displayProductionArray = vm.people.production.slice(startProduction, endProduction);
				startProduction = endProduction;
			}
			
		}
		
		function _loadMoreActor() {
			if (endActor == vm.people.actor.length) {
					return;
			}
			var valueToAdd = ((endActor + 4) <= vm.people.actor.length) ? 4 : (vm.people.actor.length - endActor);
			
			if (valueToAdd !== 4)
				vm.loadMoreActorIsDisabled = true;
			
			endActor += valueToAdd;

			for (var i = startActor; i < endActor; i++) {
				if (vm.people.actor[i].movie) {
					_loadMovieImage(vm.people.actor[i].movie.ids.tmdb, i).then(function (data) {
						vm.people.actor[data.pos].movie.images = data;
					})
				} else {
					_loadShowImage(vm.people.actor[i].show.ids.tmdb, i).then(function (data) {
						vm.people.actor[data.pos].show.images = data;
					})
				}
			}
			
			startActor = endActor;
			
			vm.displayActorArray = vm.people.actor.slice(0, endActor);
		}
		
		function _loadMoreProduction() {
			if (endProduction == vm.people.production.length) {
					return;
			}
			var valueToAdd = ((endProduction + 4) <= vm.people.production.length) ? 4 : (vm.people.production.length - endProduction);
			
			if (valueToAdd !== 4)
				vm.loadMoreProductionIsDisabled = true;
			
			endProduction += valueToAdd;
			
			for (var i = startProduction; i < endProduction; i++) {
				if (vm.people.production[i].movie) {
					_loadMovieImage(vm.people.production[i].movie.ids.tmdb, i).then(function (data) {
						vm.people.production[data.pos].movie.images = data;
					})
				} else {
					_loadShowImage(vm.people.production[i].show.ids.tmdb, i).then(function (data) {
						vm.people.production[data.pos].show.images = data;
					})
				}
			}
				
			startProduction = endProduction;
			
			vm.displayProductionArray = vm.people.production.slice(0, endProduction);
		}
		
		function _loadPersonImages() {
			TmdbPersonService.getPersonImage( {
				profileSize: 'w300',
				personId: vm.people.ids.tmdb
			}).$promise.then(function (data) {
				vm.people.images = data;
    		});
		}
		
		function _loadMovieImage(tmdb, pos) {
	        return TmdbMovieService.getMovieImage({
	        	movieId: tmdb,
	        	posterSize: 'w300',
				backdropSize: 'w1280',
				language: 'pt'
	        }).$promise.then(function (data) {
        		data.pos = pos;
	        	return data;
	        });
		}
		
		function _loadShowImage(tmdb, pos) {
			return TmdbShowService.getShowImage({
        		showId: tmdb,
        		posterSize: 'w300',
				backdropSize: 'w1280',
				language: 'pt'
        	}).$promise.then(function (data) {
        		data.pos = pos;
        		return data;
        	});
		}
		
		function _goToMovie(movie) {
			$state.go('movie', {
				traktSlug : movie.ids.slug,
				title: movie
			});
		}
		
		function _goToShow(show) {
			$state.go('show', {
				traktSlug : show.ids.slug,
				title: show
			});
		}
		
	}
	
})();