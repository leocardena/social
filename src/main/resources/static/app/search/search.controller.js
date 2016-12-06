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
        
        loadImages();
        
        function loadImages() {
        	for (var i = 0, len =  vm.results.length; i < len; i++) {
        		  vm.results[i][vm.results[i].type].images = 
        			  _getImage(vm.results[i].type,  vm.results[i][vm.results[i].type].ids.tmdb);
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
        			console.log(type, tmdb);
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