(function() {
    'use strict';

    angular
        .module('social.blocks')
        .factory('errorHandlerInterceptor', errorHandlerInterceptor);

    errorHandlerInterceptor.$inject = ['$q', '$rootScope'];
    
    /*@ngInject*/
    function errorHandlerInterceptor ($q, $rootScope) {
        var service = {
            responseError: _responseError
        };

        return service;

        function _responseError (response) {
            if (!(response.status === 401 && (response.data === '' 
            	|| (response.data.path && response.data.path.indexOf('/api/rest/account') === 0 )))) {
            	$rootScope.$emit('social.httpError', response);
            }
            return $q.reject(response);
        }
    }
})();
