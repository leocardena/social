<<<<<<< HEAD
(function() {
    'use strict';

    angular
        .module('social.search')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
            .state('search', {
                parent: 'social',
                url: '/search/{type}?page?query',
                data: {
                    authorities: [],
                    pageTitle: 'Resultados da Pesquisa'
                },
                views: {
                    'content@': {
                        templateUrl: 'app/search/search.html',
                        controller: 'SearchController',
                        controllerAs: 'vm'
                    }
                },
                resolve: {
                	searchPrepService : searchPrepService
                }
            });
        
        searchPrepService.$inject = ['TraktSearchService', '$stateParams'];
        
        /*@ngInject*/
        function searchPrepService (TraktSearchService, $stateParams) {
        	return TraktSearchService.getSearch({
        		limit : 15,
        		page : $stateParams.page,
        		query : $stateParams.query,
        		type : $stateParams.type === 'all' ? 'movie,show,person' : $stateParams.type,
        		fields : 'translations,title'
        	}).$promise.then(function(data){
        		return data;
        	}).catch(function () {
        	});
        	
        }
        

    }
})();
=======
(function() {
    'use strict';

    angular
        .module('social.search')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
            .state('search', {
                parent: 'social',
                url: '/search/{type}?page?query',
                data: {
                    authorities: [],
                    pageTitle: 'Resultados da Pesquisa'
                },
                views: {
                    'content@': {
                        templateUrl: 'app/search/search.html',
                        controller: 'SearchController',
                        controllerAs: 'vm'
                    }
                },
                resolve: {
                	searchPrepService : searchPrepService
                }
            });
        
        searchPrepService.$inject = ['TraktSearchService', '$stateParams'];
        
        /*@ngInject*/
        function searchPrepService (TraktSearchService, $stateParams) {
        	return TraktSearchService.getSearch({
        		limit : 18,
        		page : $stateParams.page,
        		query : $stateParams.query,
        		type : $stateParams.type === 'all' ? 'movie,show,person' : $stateParams.type,
        		fields : 'translations,title'
        	}).$promise.then(function(data){
        		return data;
        	}).catch(function () {
        	});
        	
        }
        

    }
})();
>>>>>>> origin/gustavo.fernandes
