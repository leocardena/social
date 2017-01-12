(function () {
	
	'use strict';
	
	angular
		   .module('social.title')
		   .controller('TitleShowEpisodeController', TitleShowEpisodeController);
	
	TitleShowEpisodeController.$inject = ['$state', '$stateParams', 'showTranslationsPrepService',
	                                      'episodePrepService', 'episodeTranslationsPrepService', 'TmdbShowService',
	                                      'minimalInfoShowSummaryPrepService', '$window'];
	
	/*@ngInject*/
	function TitleShowEpisodeController ($state, $stateParams, showTranslationsPrepService,
            episodePrepService, episodeTranslationsPrepService, TmdbShowService, minimalInfoShowSummaryPrepService,
            $window) {
		
		var vm = this;
		vm.episode = episodePrepService;
		var show = minimalInfoShowSummaryPrepService;
		
		_init();
		
		function _init() {
			
			_checkEpisodeTranslations();
			_checkImages();
			_checkShowTranslations();
			_checkBackground();
			$window.document.title = vm.episode.showTitle + ' ' + vm.episode.season + 'X'
				+ vm.episode.number + ' - ' + vm.episode.title;
			
			function _checkEpisodeTranslations() {
				if (!(episodeTranslationsPrepService[0].overview === '')) {
					vm.episode.overview = episodeTranslationsPrepService[0].overview;
					vm.episode.title = episodeTranslationsPrepService[0].title;
				}
			}
			
			function _checkImages() {
				if ($stateParams.episodeImages) {
					vm.episode.images = $stateParams.episodeImages;
				} else {
					TmdbShowService.getEpisodeImage({
						stillSize : 'w300',
						showId : show.ids.tmdb,
						seasonNumber : vm.episode.season,
						episodeNumber : vm.episode.number
			    	}).$promise.then(function (data) {
			    		vm.episode.images = data;
			    	});
				}
			}
			
			function _checkShowTranslations() {
				if (!(showTranslationsPrepService[0].overview === '')) {
					vm.episode.showTitle = showTranslationsPrepService[0].title;
				} 
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
		        		_insertBackground(data.backdrop.file_path);
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
		
	}
	
})();