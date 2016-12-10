(function() {
    'use strict';

    angular
        .module('social.search')
        .controller('SearchController', SearchController);

    SearchController.$inject = ['TraktSearchService', 'searchPrepService', 'TmdbMovieService',
                                'TmdbPersonService', 'TmdbShowService', '$stateParams', '$state',
                                'SearchTextService'];

    function SearchController (TraktSearchService, searchPrepService, TmdbMovieService, 
    		TmdbPersonService, TmdbShowService, $stateParams, $state, SearchTextService) {
        var vm = this;
        vm.itemsPerPage = 5;
        vm.results = searchPrepService.data;
        vm.maxSize = 5;
        vm.query = $stateParams.query;
        vm.searchInput = { text : $stateParams.query };
        vm.type = $stateParams.type;
        vm.getImage = _getImage;
        vm.imageNotAvailable = 'content/images/search/phosto-not-available.jpg';
        vm.search = _search;
        
        SearchTextService.setText(vm.query);
        
        _loadHeaders(searchPrepService.headers);
        _loadImages();
        
        function _loadImages() {
        	for (var i = 0, len =  vm.results.length; i < len; i++) {
        		var tmdbId = vm.results[i][vm.results[i].type].ids.tmdb;
        		
        		if (vm.results[i].type === 'person') {
        			vm.results[i][vm.results[i].type].images = { poster : tmdbId ? 
                			_getImage(vm.results[i].type,  tmdbId) : vm.imageNotAvailable };
        		} else {
            		vm.results[i][vm.results[i].type].images = tmdbId ? 
                			_getImage(vm.results[i].type,  tmdbId) : vm.imageNotAvailable;
        		}
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
        
        function _search (page, query, type) {
        	TraktSearchService.getSearch({
        		limit : 5,
        		page :  page ,
        		query : query,
        		type : type,
        		fields : 'translations,title'
        	}).$promise.then(function(data){
        		vm.results = data.data;
        		_loadHeaders(data.headers);
        		_loadImages();
        		vm.page = page;
        		vm.query = query;
        		vm.type = type;
        		SearchTextService.setText(vm.query);
        		$state.go('search', {type : type, page : 
        			page, query : query}, {notify : false}); 
        	});
        }
        
        function _loadHeaders (headers) {
            vm.page = headers['x-pagination-page'];
            vm.totalResults = headers['x-pagination-item-count'];
            vm.totalPages = headers['x-pagination-page-count'];
        }
        
    }
    
})();