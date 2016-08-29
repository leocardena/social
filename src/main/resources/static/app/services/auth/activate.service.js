(function() {
    'use strict';

    angular
        .module('social.services')
        .factory('ActivateService', ActivateService);

    ActivateService.$inject = ['$resource', 'ActivateBase'];

    function ActivateService ($resource, ActivateBase) {
        var service = $resource(ActivateBase.url, {}, {
            'put': { method: 'PUT', params: {} }
        });

        return service;
    }
})();
