(function () {
	
	'use strict';
	
	angular
			.module('social.title')
			.controller('TitleMovieController', TitleMovieController);
	
	TitleMovieController.$inject = ['$stateParams', 'TmdbMovieService', 'movieSummaryPrepService', 'moviePeoplePrepService',
	                                'movieTranslationsPrepService', 'relatedMoviesPrepService', '$window', '$state',
	                                'TrailerModalService', 'TmdbPersonService', 'DomainMovieService'];
	
	/*@ngInject*/
	function TitleMovieController($stateParams, TmdbMovieService, movieSummaryPrepService, moviePeoplePrepService, 
			movieTranslationsPrepService, relatedMoviesPrepService, $window, $state, TrailerModalService, TmdbPersonService,
			DomainMovieService) {
		
		var vm = this;
		vm.movie = movieSummaryPrepService;
		vm.movie.cast = moviePeoplePrepService.cast;
		vm.movie.crew = moviePeoplePrepService.crew;
		vm.movie.relatedMovies = relatedMoviesPrepService;
		vm.openTrailer = _openTrailer;
		vm.imageNotAvailable = 'content/images/search/phosto-not-available.jpg';
		vm.movieDoesntExist = false;
		vm.movie.userRating = { note : 0, id: 0 };
		var startCast = 0;
		var endCast = vm.movie.cast.length >= 5 ? 5 : vm.movie.cast.length; 
		var maxVisualisedCast = endCast;
		vm.castArray = vm.movie.cast.slice(startCast, endCast);
		vm.loadMore = _loadMore;
		vm.exibirTitulo = _exibirTitulo;
		vm.evaluate = _evaluate;
		vm.deleteRating = _deleteRating;
		vm.last = false;
		vm.first = true;
		vm.comments = [{
			user : 'Gustavo',
			comment : 'Filme muito bom'
		}, {
			user : 'Leonardo',
			comment : 'Ótima produção!'
		}, {
			user: 'Pedro',
			comment : 'Merece óscar!!'
		}];
		
		_init();
		
		function _openTrailer() {
			TrailerModalService.open(vm.movie.trailer);
		}
		
        function _exibirTitulo(traktSlug, title) {
        	$state.go('movie', {
				'title' : title, 
				'traktSlug' : traktSlug
			});
        }
        
        function _evaluate() {
        	if (vm.movie.userRating) return;
        	
        	vm.isEvaluating = true;
	   		DomainMovieService.postMovie({
	     		movieId : $stateParams.traktSlug
	     	}, {
     			imdb: vm.movie.ids.imdb,
     			name: vm.movie.title,
     		    trailer: vm.movie.trailer ? vm.movie.trailer : null,
     		    homepage: vm.movie.homepage ? vm.movie.homepage : null,
     		    rating: {
     		    	note: vm.movie.userRating.note
     		    }
     		}).$promise.then(function (data) {
	        	vm.isEvaluating = false;
	        	_loadMovieDetails();
	     	}).catch(function (err) {
	        	vm.isEvaluating = false;
	     	});
        }
        
        function _editRating() {
        	//put rating
        }
        
        function _deleteRating() {
        	//delete rating
        }
		
		function _loadMore(action) {
			if (action === 'more') {
				if (endCast == vm.movie.cast.length) {
					vm.last = true;
					return;
				};
				vm.first = false;
				startCast++;
				endCast++;
				if (maxVisualisedCast < vm.movie.cast.length && maxVisualisedCast < endCast) {
					maxVisualisedCast++;
					
		    		TmdbPersonService.getPersonImage({
						profileSize : 'w185',
						personId : vm.movie.cast.slice(endCast - 1, endCast)[0].person.ids.tmdb
					}).$promise.then(function (data) {
						vm.movie.cast[endCast - 1].person.image = data.file_path;
					});
				
				}
			} else {
				if (startCast == 0) {
					vm.first = true;
					return;
				}
				vm.last = false;
				startCast--;
				endCast--;
			}
			
			vm.castArray = vm.movie.cast.slice(startCast, endCast);
		}
		
    	function _loadImages(tmdb) {
        	TmdbMovieService.getMovieImage({
        		movieId: tmdb,
        		posterSize: 'w300',
				backdropSize: 'w1280',
				language: 'pt'
        	}).$promise.then(function (data) {
        		vm.movie.images = data;
        		_insertBackground(vm.movie.images.backdrop.file_path);
        	});
    	}
    	
    	function _loadRelatedMovies() {
    		var finalLength = vm.movie.relatedMovies.length >= 5 ? 5 : vm.movie.relatedMovies.length;
    		for (var i = 0; i < finalLength; i++) {
				_get(i, vm.movie.relatedMovies);
			}
    		
    		function _get(pos, relatedMovies) {
    			if (!relatedMovies[pos].ids.tmdb) return;
            	TmdbMovieService.getMovieImage({
            		movieId: relatedMovies[pos].ids.tmdb,
            		posterSize: 'w300',
    				backdropSize: 'w1280',
    				language: 'pt'
            	}).$promise.then(function (data) {
            		vm.movie.relatedMovies[pos].images = data;
            	});
    		}
    	}
    	
    	function _loadPersonImage() {
    		
    		for (var i = 0; i < endCast; i++) {
				_get(i, vm.movie);
			}
    		
    		function _get(pos, movie) {
    	   		TmdbPersonService.getPersonImage({
    				profileSize : 'w185',
    				personId : movie.cast[pos].person.ids.tmdb
    			}).$promise.then(function (data) {
    				vm.movie.cast[pos].person.image =  data.file_path;
    			}); 
    		}
 
    	}
    	
    	function _loadMovieDetails() {
	   		DomainMovieService.getMovie({
	     		movieId : $stateParams.traktSlug
	     	}).$promise.then(function (data) {
	     		vm.movie.domain = data;
	     		vm.movieDoesntExist = false;
	     		 _loadUserRating(vm.movie.domain.rating.idRatingParent);
	     	}).catch(function (err) {
	     		vm.movieDoesntExist = true;
	     	});
    	}
    	
    	function _loadUserRating(idRatingParent) {
     		DomainMovieService.getUserRating({
	     		movieId : $stateParams.traktSlug,
	     		idRatingParent: idRatingParent
	     	}).$promise.then(function (data) {
	     		vm.movie.userRating = data;
	     	}).catch(function (err) {

	     	});
    	}
    	
    	function _insertBackground (backgroundUrl) {
			if (backgroundUrl) {
    			$state.current.data.background = backgroundUrl;
    		} else {
    			$state.current.data.background = null;
    		}
    	}
    	
    	function _init() {
    		
    		_loadPersonImage();
    		_loadRelatedMovies();
    		_loadMovieDetails();
    		
    		if (movieTranslationsPrepService.length > 0) {
    			vm.movie.overview = movieTranslationsPrepService[0].overview;
    			vm.movie.title = movieTranslationsPrepService[0].title;
    		}
    		
    		if (!$stateParams.title) {
    			 _loadImages(vm.movie.ids.tmdb);
    		} else {
    			if ($stateParams.title.ids.slug != $stateParams.traktSlug) {
    				 _loadImages(vm.movie.ids.tmdb);
    			} else {
    				vm.movie.images = $stateParams.title.images;
        			_insertBackground(vm.movie.images.backdrop.file_path);
    			}
    		}
    		
    		$window.document.title = vm.movie.title;
    		
    	} 
		
	}
	
})();