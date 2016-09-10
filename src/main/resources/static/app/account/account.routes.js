(function() {
    'use strict';

    angular
        .module('social.account')
        .config(config);

    config.$inject = ['$stateProvider'];

    function config($stateProvider) {
        $stateProvider.state('account', {
            abstract: true,
            parent: 'social'
        });
    }
})();
