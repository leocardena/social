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
				activateAccount : activateAccount,
				authorize : authorize,
				createAccount : createAccount,
				loginWithToken: loginWithToken,
				getPreviousState : getPreviousState,
				login : login,
				logout: logout,
				resetPreviousState : resetPreviousState,
				storePreviousState: storePreviousState
		}
		
		return services;
		
        function activateAccount (key, callback) {
            var cb = callback || angular.noop;

            return ActivateService.get(key,
                function (response) {
                    return cb(response);
                },
                function (err) {
                    return cb(err);
                }.bind(this)).$promise;
        }
        
        function authorize (force) {
            var authReturn = PrincipalService.identity(force).then(authThen);

            return authReturn;

            function authThen () {
                var isAuthenticated = PrincipalService.isAuthenticated();

                // an authenticated user can't access to login and register pages
                if (isAuthenticated && $rootScope.toState.parent === 'account' && ($rootScope.toState.name === 'login' || $rootScope.toState.name === 'register' 
                		|| $rootScope.toState.name === 'social-auth' || $rootScope.toState.name === 'activate' )) {
                    $state.go('home');
                }

                // recover and clear previousState after external login redirect (e.g. oauth2)
                if (isAuthenticated && !$rootScope.fromState.name && getPreviousState()) {
                    var previousState = getPreviousState();
                    resetPreviousState();
                    $state.go(previousState.name, previousState.params);
                }

                if ($rootScope.toState.data.authorities && $rootScope.toState.data.authorities.length > 0 && 
                		!PrincipalService.hasAnyAuthority($rootScope.toState.data.authorities)) {
                    if (isAuthenticated) {
                        // user is signed in but not authorized for desired state
                        $state.go('accessdenied');
                    }
                    else {
                        // user is not authenticated. stow the state they wanted before you
                        // send them to the login service, so you can return them when you're done
                        storePreviousState($rootScope.toState.name, $rootScope.toStateParams);

                       // now, send them to the signin state so they can log in
                       // $state.go('accessdenied').then(function() {
                       //    LoginService.open();
                       // });
                        $state.go('login');
                    }
                }
            }
        }
		
		function createAccount (account, callback) {
            var cb = callback || angular.noop;

            return RegisterService.save(account,
                function () {
                    return cb(account);
                },
                function (err) {
                    this.logout();
                    return cb(err);
                }.bind(this)).$promise;
        }
		
		
        function login (credentials, callback) {
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
        
        function loginWithToken(jwt, rememberMe) {
            return AuthServerProvider.loginWithToken(jwt, rememberMe);
        }
        
        function logout () {
            AuthServerProvider.logout();
            PrincipalService.authenticate(null);
        }
        
    	function getPreviousState() {
            var previousState = $sessionStorage.previousState;
            return previousState;
    	}
        
        function resetPreviousState() {
            delete $sessionStorage.previousState;
        }
        
        function storePreviousState(previousStateName, previousStateParams) {
            var previousState = { "name": previousStateName, "params": previousStateParams };
            $sessionStorage.previousState = previousState;
        }

	}
	
})();