(function() {
    'use strict';

    angular
        .module('social.title')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
            .state('title', {
                parent: 'social',
                url: '/{type}/{traktSlug}',
                params: {
                	title : null
                },
                data: {
                    authorities: [],
                    pageTitle: ''
                },
                views: {
                    'content@': {
                        templateUrl: 'app/title/title.html',
                        controller: 'TitleController',
                        controllerAs: 'vm'
                    }
                },
                resolve: {
                	titlePrepService : titlePrepService
                }
            });
        
        titlePrepService.$inject = ['$stateParams'];
        
        /*@ngInject*/
        function titlePrepService ($stateParams) {
        	
        	/* Call request with $stateParams.traktSlug
        		in the end of request if ($stateParams.title == null) call images service
        	*/
        	
        }
        
    }
})();
