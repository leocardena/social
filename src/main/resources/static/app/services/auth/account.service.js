(function() {
    'use strict';

    angular
        .module('social.services')
        .factory('AccountService', AccountService);

    AccountService.$inject = ['$resource', 'AccountBase'];

    function AccountService ($resource, AccountBase) {
        var service = $resource(AccountBase.url, {}, {
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
