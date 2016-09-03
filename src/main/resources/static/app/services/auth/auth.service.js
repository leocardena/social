(function () {
	'use strict';
	
	angular
			.module('social.services')
			.factory('AuthService', AuthService);
	
	AuthService.$inject = ['$q', 'RegisterService', 'ActivateService', 'AuthServerProvider', 'PrincipalService',
	                       '$sessionStorage', '$rootScope', '$state']
	
	function AuthService($q, RegisterService, ActivateService, AuthServerProvider, 
			PrincipalService, $sessionStorage, $rootScope, $state) {
        
		var services = {
				activateAccount : _activateAccount,
				authorize : _authorize,
				createAccount : _createAccount,
				getPreviousState : _getPreviousState,
				login : _login,
				logout: _logout,
				resetPreviousState : _resetPreviousState,
				storePreviousState: _storePreviousState
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
        
        function _authorize (force) {
            var authReturn = PrincipalService.identity(force).then(authThen);
            
            return authReturn;

            function authThen () {
                var isAuthenticated = PrincipalService.isAuthenticated();

                // an authenticated user can't access to login and register pages
                if (isAuthenticated && $rootScope.toState.parent === 'account' && ($rootScope.toState.name === 'login'
                		|| $rootScope.toState.name === 'register' || $rootScope.toState.name === 'activate')) {
                    $state.go('home');
                }

                // recover and clear previousState after external login redirect (e.g. oauth2)
                if (isAuthenticated && !$rootScope.fromState.name && _getPreviousState()) {
                    var previousState = _getPreviousState();
                    _resetPreviousState();
                    $state.go(previousState.name, previousState.params);
                }

                if ($rootScope.toState.data.authorities && $rootScope.toState.data.authorities.length > 0 && !PrincipalService.hasAnyAuthority($rootScope.toState.data.authorities)) {
                    if (isAuthenticated) {
                    	// user is signed in but not authorized for desired state
                        $state.go('accessdenied');
                    }
                    else {
                        // user is not authenticated. stow the state they wanted before you
                        // send them to the login service, so you can return them when you're done
                        _storePreviousState($rootScope.toState.name, $rootScope.toStateParams);

                        // now, send them to the signin state so they can log in
                        $state.go('login');
                    }
                }
            }
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
        
        function _storePreviousState(previousStateName, previousStateParams) {
            var previousState = { "name": previousStateName, "params": previousStateParams };
            $sessionStorage.previousState = previousState;
        }

	}
	
})();