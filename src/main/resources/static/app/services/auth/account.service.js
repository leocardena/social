(function() {
    'use strict';

    angular
        .module('social.services')
        .factory('AccountService', AccountService);

    AccountService.$inject = ['$resource'];

    function AccountService ($resource) {
        var service = $resource('api/rest/account', {}, {
            'get': { method: 'GET', params: {}, isArray: false,
                interceptor: {
                    response: function(response) {
                        // expose response
                        return response;
                    }
                }
            }
        });

        return service;
    }
})();
