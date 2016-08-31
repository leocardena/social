(function () {
	'use strict';
	
	angular
			.module('social.services')
			.factory('AuthService', AuthService);
	
	AuthService.$inject = ['$q', 'RegisterService', 'ActivateService', 'AuthServerProvider', 'PrincipalService',
	                       '$sessionStorage']
	
	function AuthService($q, RegisterService, ActivateService, AuthServerProvider, PrincipalService, $sessionStorage) {
        
		var services = {
				activateAccount : _activateAccount,
				createAccount : _createAccount,
				getPreviousState : _getPreviousState,
				login : _login,
				logout: _logout,
				resetPreviousState : _resetPreviousState
		}
		
		return services;
		
        function _activateAccount (key, callback) {
            var cb = callback || angular.noop;

            return ActivateService.get(key,
                function (response) {
                    return cb(response);
                },
                function (err) {
                    return cb(err);
                }.bind(this)).$promise;
        }
		
		function _createAccount (account, callback) {
            var cb = callback || angular.noop;

            return RegisterService.save(account,
                function () {
                    return cb(account);
                },
                function (err) {
                    //this.logout();
                    return cb(err);
                }.bind(this)).$promise;
        }
		
		 function _getPreviousState() {
	            var previousState = $sessionStorage.previousState;
	            return previousState;
	        }
		
        function _login (credentials, callback) {
            var cb = callback || angular.noop;
            var deferred = $q.defer();

            AuthServerProvider.login(credentials)
                .then(loginThen)
                .catch(function (err) {
                    this.logout();
                    deferred.reject(err);
                    return cb(err);
                }.bind(this));

            function loginThen (data) {
                PrincipalService.identity(true).then(function(account) {
                    deferred.resolve(data);
                });
                return cb();
            }

            return deferred.promise;
        }
        
        function _logout () {
            AuthServerProvider.logout();
            PrincipalService.authenticate(null);
        }
        
        function _resetPreviousState() {
            delete $sessionStorage.previousState;
        }

	}
	
})();