(function() {
    'use strict';

    angular
        .module('social.services')
        .factory('ActivateService', ActivateService);

    ActivateService.$inject = ['$resource', 'AccountBase'];

    function ActivateService ($resource, AccountBase) {
    	var service = $resource(AccountBase.activate, {}, {
            'get': { method:
            	'GET', 
            	params: {},
            	isArray: false
            }
        });

        return service;
    }
})();
