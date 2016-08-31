(function() {
    'use strict';

    angular
        .module('social.services')
        .factory('AuthServerProvider', AuthServerProvider);

    AuthServerProvider.$inject = ['$http', '$localStorage' ];

    function AuthServerProvider ($http, $localStorage ) {
        var service = {
            getToken: _getToken,
            hasValidToken: _hasValidToken,
            login: _login,
            logout: _logout
        };

        return service;

        function _getToken () {
            var token = $localStorage.authenticationToken;
            return token;
        }

        function _hasValidToken () {
            var token = this.getToken();
            return !!token;
        }

        function _login (credentials) {
            var data = 'j_username=' + encodeURIComponent(credentials.username) +
                '&j_password=' + encodeURIComponent(credentials.password) +
                '&remember-me=' + credentials.rememberMe + '&submit=Login';

            return $http.post('api/authentication', data, {
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                }
            }).success(function (response) {
                return response;
            });
        }

        function _logout () {
            // logout from the server
            $http.post('api/logout').success(function (response) {
                delete $localStorage.authenticationToken;
                // to get a new csrf token call the api
                //$http.get('api/rest/account');
                return response;
            });
            
        }
    }
})();
