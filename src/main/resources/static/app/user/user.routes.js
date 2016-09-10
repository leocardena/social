(function() {
    'use strict';

    angular
        .module('social.user')
        .config(config);

    config.$inject = ['$stateProvider'];

    function config($stateProvider) {
        $stateProvider.state('user', {
            abstract: true,
            parent: 'social'
        });
    }
})();
