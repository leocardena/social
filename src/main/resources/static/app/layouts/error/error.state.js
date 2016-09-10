(function() {
    'use strict';

    angular
        .module('social.layouts.error')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
            .state('error', {
                parent: 'social',
                url: '/error',
                data: {
                    authorities: [],
                    pageTitle: 'Error page'
                },
                views: {
                    'content@': {
                        templateUrl: 'app/layouts/error/error.html'
                    }
                }
            })
            .state('accessdenied', {
                parent: 'social',
                url: '/accessdenied',
                data: {
                    authorities: [],
                    pageTitle: 'Error page'
                },
                views: {
                    'content@': {
                        templateUrl: 'app/layouts/error/accessdenied.html'
                    }
                }
            });
    }
})();
