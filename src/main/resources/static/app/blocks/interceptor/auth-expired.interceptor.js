(function() {
    'use strict';

    angular
        .module('social.blocks')
        .factory('authExpiredInterceptor', authExpiredInterceptor);

    
    authExpiredInterceptor.$inject = ['$rootScope', '$q', '$injector', '$localStorage', '$sessionStorage'];

    function authExpiredInterceptor($rootScope, $q, $injector, $localStorage, $sessionStorage) {
        var service = {
            responseError: responseError
        };

        return service;

        function responseError(response) {
            if (response.status === 401) {
                delete $localStorage.authenticationToken;
                delete $sessionStorage.authenticationToken;
                var PrincipalService = $injector.get('PrincipalService');
                if (PrincipalService.isAuthenticated()) {
                    var AuthService = $injector.get('AuthService');
                    AuthService.authorize(true);
                }
            }
            return $q.reject(response);
        }

    }
})();
