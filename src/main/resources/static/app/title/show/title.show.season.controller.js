(function () {
	
	'use strict';
	
	angular
			.module('social.title')
			.controller('TitleShowSeasonController', TitleShowSeasonController);
	
	TitleShowSeasonController.$inject = ['seasonPrepService', 'showSummaryPrepService', 'showTranslationsPrepService',
	                                     'TmdbShowService', '$state', '$stateParams', '$window'];
	
	/*@ngInject*/
	function TitleShowSeasonController(seasonPrepService, showSummaryPrepService, showTranslationsPrepService,
			TmdbShowService, $state, $stateParams, $window) {
		
		var vm = this;
		vm.evaluate = _evaluate;
		vm.imageNotAvailable = 'content/images/search/phosto-not-available.jpg';
		vm.show = showSummaryPrepService
		vm.season = { episodes : seasonPrepService };
		vm.season.number = $stateParams.seasonNumber;
		vm.returnToShow = _returnToShow;
		vm.openEpisode = _openEpisode;
		
		_init();
		
		function _init() {
			
			 _checkShowImages();
			 _checkEpisodesImages();
			 _getSeasonImage();
			 _setShowTranslations();
			 _setEpidodesTranslations();
	    	 $window.document.title = vm.show.title + ' (Temporada ' + $stateParams.seasonNumber + ')';
			 
			function _getSeasonImage() {
				if ($stateParams.season) {
					vm.season.images = $stateParams.season.images;
				} else {
					TmdbShowService.getSeasonImage({
			       		showId: vm.show.ids.tmdb,
			       		seasonNumber : $stateParams.seasonNumber,
			       		posterSize: 'w300',
						language: 'pt'
			       	}).$promise.then(function (data) {
			       		vm.season.images = data;
			       	});
				}
			}
			
			function _checkShowImages() {
				if (!vm.show.images) _loadShowImages(vm.show.ids.tmdb);
			}
			
			function _checkEpisodesImages() {
				for (var i = 0; i < vm.season.episodes.length; i++) {
					_loadEpisodeImages(vm.season.episodes[i], i);
				}
			}
			
			function _setShowTranslations() {
				if (showTranslationsPrepService.length > 0) {
	    			vm.show.overview = showTranslationsPrepService[0].overview;
	    			vm.show.title = showTranslationsPrepService[0].title;
	    		}
			}
			
			function _setEpidodesTranslations() {
				for (var i = 0; i < vm.season.episodes.length; i++) {
					if (seasonPrepService[i].translations.length > 0 && 
							!(seasonPrepService[i].translations[0].overview === "")) {
						vm.season.episodes[i].overview = seasonPrepService[i].translations[0].overview;
						vm.season.episodes[i].title = seasonPrepService[i].translations[0].title;
					}
				}
			}
			
		}
		
		function _evaluate () {
			
		}
		
    	function _insertBackground (backgroundUrl) {
			if (backgroundUrl) {
    			$state.current.data.background = backgroundUrl;
    		} else {
    			$state.current.data.background = null;
    		}
    	}
    	
    	function _loadEpisodeImages(episode, pos) {
    		TmdbShowService.getEpisodeImage({
				stillSize : 'w300',
				showId : vm.show.ids.tmdb,
				seasonNumber : episode.season,
				episodeNumber : episode.number
    		}).$promise.then(function (data) {
    			vm.season.episodes[pos].images = data;
    		});
    	}
    	
    	function _loadShowImages(tmdb) {
    		TmdbShowService.getShowImage({
    			showId: tmdb,
        		posterSize: 'w300',
				backdropSize: 'w1280',
				language: 'pt'
        	}).$promise.then(function (data) {
        		vm.show.images = data;
        		_insertBackground(vm.show.images.backdrop.file_path);
        	});
    	}
    	
    	function _openEpisode(episodeNumber, seasonNumber, traktSlug, showImages, seasonImages) {
    		$state.go('episode', {
    			episodeNumber : episodeNumber,
    			seasonNumber : seasonNumber,
    			traktSlug : traktSlug,
    			showImages : showImages,
    			seasonImages : seasonImages
    		});
    	}
    	
    	function _returnToShow() {
    		$state.go('show', {
    			traktSlug : vm.show.ids.slug
    		});
    	}
		
	}
	
})();