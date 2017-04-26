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
        vm.itemsPerPage = 18;
        vm.results = searchPrepService.data;
        vm.changePage = _changePage;
        vm.maxSize = 6;
        vm.query = $stateParams.query;
        vm.searchInput = { text : $stateParams.query };
        vm.type = $stateParams.type;
        vm.getImage = _getImage;
        vm.imageNotAvailable = 'content/images/search/phosto-not-available.jpg';
        vm.search = _search;
        vm.exibirTitulo = _exibirTitulo;

        SearchTextService.setText(vm.query);
		SearchTextService.setType(vm.type);
        
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
        			break;
        		case 'show':
        			return TmdbShowService.getShowImage({
        				showId: tmdb,
        				posterSize: 'w300',
        				backdropSize: 'w1280',
        				language: 'pt'
        				});
        			break;
        		case 'person':
        			return TmdbPersonService.getPersonImage({
        				personId: tmdb,
        				profileSize: 'w300'
        				});
        			break;
        	}
        }
        
        function _search (page, query, type) {
    		SearchTextService.setText(null);
    		SearchTextService.setType(null);
        	if (!query) {
        		vm.searchInput.text = vm.query;
        		query = vm.query;
        	} 
        	TraktSearchService.getSearch({
        		limit : vm.itemsPerPage,
        		page :  page ,
        		query : query,
        		type : type === 'all' ? 'movie,show,person' : type,
        		fields : 'translations,title,name'
        	}).$promise.then(function(data){
        		vm.results = data.data;
        		_loadHeaders(data.headers);
        		_loadImages();
        		vm.query = query;
        		vm.type = type;
        		SearchTextService.setText(vm.query);
        		SearchTextService.setType(vm.type);
        		$state.go('search', {type : vm.type, page : 
        			vm.page, query : vm.query}, {notify : false}); 
        	});
        }
        
        function _changePage( page, query, type, inputText ) {
        	if (query != inputText) vm.searchInput.text = query;
        	_search(page, query, type);
        }
        
        function _loadHeaders (headers) {
            vm.page = headers['x-pagination-page'];
            vm.totalResults = headers['x-pagination-item-count'];
            vm.totalPages = headers['x-pagination-page-count'];
        }
        
        function _exibirTitulo(type, traktSlug, title) {
        	switch (type) {
				case 'movie':
					$state.go('movie', {
						'title' : title, 
						'traktSlug' : traktSlug
					});
					break;
				case 'show':
					$state.go('show', {
						'title' : title, 
						'traktSlug' : traktSlug
					});
					break;
				case 'season':
					break;
				case 'episode':
					break;
				case 'person':
					$state.go('people', {
						'people' : title, 
						'traktSlug' : traktSlug
					});
					break;
        	}
        }
        
    }
    
})();