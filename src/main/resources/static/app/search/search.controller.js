(function() {
    'use strict';

    angular
        .module('social.search')
        .controller('SearchController', SearchController);

    SearchController.$inject = ['TraktSearchService', 'searchPrepService', 
                                'TmdbMovieService', 'TmdbPersonService', 'TmdbShowService'];

    function SearchController (TraktSearchService, searchPrepService, TmdbMovieService, 
    		TmdbPersonService, TmdbShowService) {
        var vm = this;
        vm.results = searchPrepService.data;
        vm.page = searchPrepService.headers['x-pagination-page'];
        vm.totalResults = searchPrepService.headers['x-pagination-item-count'];
        vm.totalPages = searchPrepService.headers['x-pagination-page-count'];
        vm.getImage = _getImage;
        vm.imageNotAvailable = 'content/images/search/phosto-not-available.jpg';
        
        loadImages();
        
        function loadImages() {
        	for (var i = 0, len =  vm.results.length; i < len; i++) {
        		var tmdbId = vm.results[i][vm.results[i].type].ids.tmdb;
        		vm.results[i][vm.results[i].type].images = tmdbId ? 
        			_getImage(vm.results[i].type,  tmdbId) : vm.imageNotAvailable;
        	}
        }
        
        function _getImage(type, tmdb) {
        	switch (type) {
        		case 'movie':
        			return TmdbMovieService.getMovieImage({
        				movieId: tmdb,
        				posterSize: 'w300',
        				backdropSize: 'w1280',
        				language: 'pt'
        				});
        		case 'show':
        			return TmdbShowService.getShowImage({
        				showId: tmdb,
        				posterSize: 'w300',
        				backdropSize: 'w1280',
        				language: 'pt'
        				});
        		case 'person':
        			return TmdbPersonService.getPersonImage({
        				personId: tmdb,
        				profileSize: 'w300'
        				});
        			break;
        	}
        }
        
    }
    
})();