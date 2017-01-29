(function () {
	
	'use strict';
	
	angular
			.module('social.title')
			.controller('TitleShowController', TitleShowController);
	
	TitleShowController.$inject = ['$stateParams', '$window', '$state', 'showTranslationsPrepService',
	                               'showSummaryPrepService', 'showPeoplePrepService', 'relatedShowsPrepService',
	                               'seasonsShowPrepService', 'TrailerModalService', 'TmdbShowService', 'TmdbPersonService'];
	
	/*@ngInject*/
	function TitleShowController($stateParams, $window, $state, showTranslationsPrepService,
			showSummaryPrepService, showPeoplePrepService, relatedShowsPrepService, seasonsShowPrepService,
			TrailerModalService, TmdbShowService, TmdbPersonService) {
		
		var vm = this;
		
		/* vm objects */
		vm.last = false;
		vm.first = true;
		
		/* Show object */
		vm.show = showSummaryPrepService;
		vm.show.cast = showPeoplePrepService.cast;
		vm.show.crew = showPeoplePrepService.crew;
		vm.show.relatedShows = relatedShowsPrepService;
		vm.show.seasons  = seasonsShowPrepService;
		
		/* Methods */
		vm.evaluate = _evaluate;
		vm.exibirTitulo = _exibirTitulo;
		vm.loadMorePerson = _loadMorePerson;
		vm.openTrailer = _openTrailer;
		vm.exibirSeason = _exibirSeason;
		
		/* Helper Variables */
		vm.imageNotAvailable = 'content/images/search/phosto-not-available.jpg';
		var startCast = 0;
		var endCast = vm.show.cast.length >= 5 ? 5 : vm.show.cast.length; 
		var maxVisualisedCast = endCast;
		vm.castArray = vm.show.cast.slice(startCast, endCast);
		
		/* Init Controller*/
		_init();
		
        function _evaluate() {
        	//request to backend
        }
        
        function  _exibirSeason(season, show) {
        	$state.go('season', {
				'seasonNumber' : season.number,
				'season' : season,
        		'show' : show, 
				'traktSlug' : show.ids.slug
			});
        }
        
        function _exibirTitulo(title) {
        	$state.go('show', {
				'title' : title, 
				'traktSlug' : title.ids.slug
			});
        }
        
    	function _init() {
    		
    		_loadPersonImages();
    		_loadRelatedShowsImages();
    		_loadSeasonsImages();
    		
    		if (showTranslationsPrepService.length > 0) {
    			vm.show.overview = showTranslationsPrepService[0].overview;
    			vm.show.title = showTranslationsPrepService[0].title;
    		}
    		
    		if (!$stateParams.title) {
    			 _loadImages(vm.show.ids.tmdb);
    		} else {
    			if ($stateParams.title.ids.slug != $stateParams.traktSlug) {
    				 _loadImages(vm.show.ids.tmdb);
    			} else {
    				vm.show.images = $stateParams.title.images;
        			_insertBackground(vm.show.images.backdrop.file_path);
    			}
    		}
    		
    		$window.document.title = vm.show.title;
    		
    	} 
        
    	function _insertBackground (backgroundUrl) {
			if (backgroundUrl) {
    			$state.current.data.background = backgroundUrl;
    		} else {
    			$state.current.data.background = null;
    		}
    	}
        
    	function _loadImages(tmdb) {
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
        
		function _loadMorePerson(action) {
			if (action === 'more') {
				if (endCast == vm.show.cast.length) {
					vm.last = true;
					return;
				}
				vm.first = false;
				startCast++;
				endCast++;
				if (maxVisualisedCast < vm.show.cast.length && maxVisualisedCast < endCast) {
					maxVisualisedCast++;
					
		    		TmdbPersonService.getPersonImage({
						profileSize : 'w185',
						personId : vm.show.cast.slice(endCast - 1, endCast)[0].person.ids.tmdb
					}).$promise.then(function (data) {
						vm.show.cast[endCast - 1].person.image = data.file_path;
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
			
			vm.castArray = vm.show.cast.slice(startCast, endCast);
		}
		
    	function _loadPersonImages() {
    		
    		for (var i = 0; i < endCast; i++) {
				_get(i, vm.show);
			}
    		
    		function _get(pos, show) {
    			TmdbPersonService.getPersonImage({
    				profileSize : 'w185',
    				personId : show.cast[pos].person.ids.tmdb
    			}).$promise.then(function (data) {
    				vm.show.cast[pos].person.image =  data.file_path;
    			}); 
    		}
 
    	}
		
    	function _loadRelatedShowsImages() {
    		var finalLength = vm.show.relatedShows.length >= 5 ? 5 : vm.show.relatedShows.length;
    		for (var i = 0; i < finalLength; i++) {
				_get(i, vm.show.relatedShows);
			}
    		
    		function _get(pos, relatedShows) {
    			if (!relatedShows[pos].ids.tmdb) return;
    			TmdbShowService.getShowImage({
            		showId: relatedShows[pos].ids.tmdb,
            		posterSize: 'w300',
    				backdropSize: 'w1280',
    				language: 'pt'
            	}).$promise.then(function (data) {
            		vm.show.relatedShows[pos].images = data;
            	});
    		}
    	}
    	
    	function _loadSeasonsImages() {
    		for (var i = 0; i < vm.show.seasons.length; i++) {
    			_get(i, vm.show.seasons);
    		}
    		
    		function _get(pos, seasons) {
    			TmdbShowService.getSeasonImage({
            		showId: vm.show.ids.tmdb,
            		seasonNumber : seasons[pos].number,
            		posterSize: 'w300',
    				language: 'pt'
            	}).$promise.then(function (data) {
            		vm.show.seasons[pos].images = data;
            	});
    		}
    	}
		
		function _openTrailer() {
			TrailerModalService.open(vm.show.trailer);
		}
		
	}
	
})();