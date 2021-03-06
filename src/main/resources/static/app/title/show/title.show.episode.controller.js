(function () {
	
	'use strict';
	
	angular
		   .module('social.title')
		   .controller('TitleShowEpisodeController', TitleShowEpisodeController);
	
	TitleShowEpisodeController.$inject = ['$state', '$stateParams', 'showTranslationsPrepService',
	                                      'episodePrepService', 'episodeTranslationsPrepService', 'TmdbShowService',
	                                      'minimalInfoShowSummaryPrepService', '$window', 'DomainEpisodeService'];
	
	/*@ngInject*/
	function TitleShowEpisodeController ($state, $stateParams, showTranslationsPrepService,
            episodePrepService, episodeTranslationsPrepService, TmdbShowService, minimalInfoShowSummaryPrepService,
            $window, DomainEpisodeService) {
		
		var vm = this;
		vm.episode = episodePrepService;
		vm.imageNotAvailable = 'content/images/search/phosto-not-available.jpg';
		vm.imageNotAvailable
		vm.goToShow = _goToShow;
		vm.goToSeason = _goToSeason;
		var show = minimalInfoShowSummaryPrepService;
		
		vm.episode.userRating = { note : 0, id: 0 };
		vm.episodeDoesntExist = false;
    	vm.isEvaluating = false;
		vm.evaluate = _evaluate;
		vm.deleteRating = _deleteRating;
		
		_init();
		
        function _evaluate() {
        	if (vm.episode.userRating.id !== 0) {
        		_editRating();
        		return;
        	};
        	       	
        	vm.isEvaluating = true;
        	DomainEpisodeService.postUserRating({
        		showId : $stateParams.traktSlug,
        		seasonNumber: $stateParams.seasonNumber,
        		episodeNumber: $stateParams.episodeNumber
	     	}, {
     			name: vm.episode.title ? vm.episode.title : null,
     		    rating: {
     		    	note: vm.episode.userRating.note
     		    }
     		}).$promise.then(function (data) {
	        	vm.isEvaluating = false;
	        	_loadEpisodeDetails();
	     	}).catch(function (err) {
	        	vm.isEvaluating = false;
	     	});
        }
        
        function _editRating() {
        	vm.isEvaluating = true;
        	DomainEpisodeService.putUserRating({
	     		showId : $stateParams.traktSlug,
        		seasonNumber: $stateParams.seasonNumber,
        		episodeNumber: $stateParams.episodeNumber,
	     		userRatingId: vm.episode.userRating.id
	     	}, {note: vm.episode.userRating.note}).$promise.then(function (data) {
	        	vm.isEvaluating = false;
	        	_loadEpisodeDetails();
	     	}).catch(function (err) {
	        	vm.isEvaluating = false;
	     	});
        }
        
        function _deleteRating() {
        	if (vm.episode.userRating.note == 0) return;
        	
        	vm.isEvaluating = true;
        	DomainEpisodeService.deleteUserRating({
	     		showId : $stateParams.traktSlug,
	     		seasonNumber: $stateParams.seasonNumber,
        		episodeNumber: $stateParams.episodeNumber,
	     		userRatingId : vm.episode.userRating.id
	     	}).$promise.then(function (data) {
	        	vm.isEvaluating = false;
	    		vm.episode.userRating = { note : 0, id: 0 };
	    		_loadEpisodeDetails();
	     	}).catch(function (err) {
	        	vm.isEvaluating = false;
	     	});
        }
        
    	function _loadSeasonDetails() {
    		DomainEpisodeService.getEpisode({
	     		showId : $stateParams.traktSlug,
	     		seasonNumber: $stateParams.seasonNumber,
        		episodeNumber: $stateParams.episodeNumber
	     	}).$promise.then(function (data) {
	     		vm.episode.domain = data;
	     		vm.episodeDoesntExist = false;
	     		 _loadUserRating(vm.episode.domain.rating.idRatingParent);
	     	}).catch(function (err) {
	     		vm.episodeDoesntExist = true;
	     	});
    	}
    	
    	function _loadUserRating(idRatingParent) {
    		DomainEpisodeService.getUserRating({
	     		showId : $stateParams.traktSlug,
	     		seasonNumber: $stateParams.seasonNumber,
        		episodeNumber: $stateParams.episodeNumber,
	     		idRatingParent: idRatingParent
	     	}).$promise.then(function (data) {
	     		vm.episode.userRating = data;
	     	}).catch(function (err) {
	    		vm.episode.userRating = { note : 0, id: 0 };
	     	});
    	}
		
		function _init() {
			
			_checkEpisodeTranslations();
			_checkShowTranslations();
			_checkSeasonImages();
			_checkBackground();
			_loadEpisodeImages();
			_loadSeasonDetails();
			$window.document.title = vm.show.title + ' ' + vm.episode.season + 'X'
				+ vm.episode.number + ' - ' + vm.episode.title;
			
			function _checkEpisodeTranslations() {
				if (!(episodeTranslationsPrepService[0].overview === '')) {
					vm.episode.overview = episodeTranslationsPrepService[0].overview;
					vm.episode.title = episodeTranslationsPrepService[0].title;
				}
			}
			
			function _loadEpisodeImages() {
				TmdbShowService.getEpisodeImage({
						stillSize : 'original',
						showId : show.ids.tmdb,
						seasonNumber : vm.episode.season,
						episodeNumber : vm.episode.number
			    	}).$promise.then(function (data) {
			    		vm.episode.images = data;
			   });
			}
			
			function _checkShowTranslations() {
				if (!(showTranslationsPrepService[0].overview === '')) {
					vm.show = { title : showTranslationsPrepService[0].title };
				} 
			}
			
			function _checkSeasonImages() {
				if ($stateParams.seasonImages) 
					vm.season = { images : { poster : $stateParams.seasonImages} };
			}
			
	    	function _checkBackground() {
	    		if ($stateParams.showImages) {
	    			_insertBackground($stateParams.showImages.file_path);
	    		} else {
		    		TmdbShowService.getShowImage({
		    			showId: show.ids.tmdb,
		        		posterSize: 'w300',
						backdropSize: 'w1280',
						language: 'pt'
		        	}).$promise.then(function (data) {
		        		vm.season = { images : data };
		        		_insertBackground(vm.season.images.backdrop.file_path);
		        	});
	    		}
	    		
	    		function _insertBackground(backgroundUrl) {
	    			if (backgroundUrl) {
	        			$state.current.data.background = backgroundUrl;
	        		} else {
	        			$state.current.data.background = null;
	        		}
	    		}
	    		
	    	}
			
		}
		
		function _goToShow() {
			$state.go('show', {
				traktSlug : $stateParams.traktSlug
			});
		}
		
		function _goToSeason(seasonNumber) {
			$state.go('season', {
				seasonNumber : seasonNumber,
				traktSlug : $stateParams.traktSlug
			});
		}
		
	}
	
})();