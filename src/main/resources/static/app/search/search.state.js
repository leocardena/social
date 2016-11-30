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
                url: '/search/{type}?query',
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
        		limit : 10,
        		query : $stateParams.query,
        		type : $stateParams.type,
        		fields : 'translations,title'
        	});
        }
    }
})();
