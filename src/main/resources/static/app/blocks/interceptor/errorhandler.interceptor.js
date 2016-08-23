(function() {
    'use strict';

    angular
        .module('social.blocks')
        .factory('errorHandlerInterceptor', errorHandlerInterceptor);

    errorHandlerInterceptor.$inject = ['$q', '$rootScope'];
    
    /*@ngInject*/
    function errorHandlerInterceptor ($q, $rootScope) {
        var service = {
            responseError: responseError
        };

        return service;

        function responseError (response) {
            if (!(response.status === 401 && (response.data === '' || (response.data.path && response.data.path.indexOf('/api/rest/account') === 0 )))) {
                $rootScope.$emit('socialApp.httpError', response);
            }
            return $q.reject(response);
        }
    }
})();
