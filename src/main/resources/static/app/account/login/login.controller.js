(function() {
    'use strict';

    angular
        .module('social.account.login')
        .controller('LoginController', LoginController);

    LoginController.$inject = ['$rootScope', '$state', 'AuthService', 'backgroundPrepService'];

    function LoginController ($rootScope, $state, AuthService, backgroundPrepService) {
        var vm = this;
        vm.authenticationError = false;
        vm.cancel = cancel;
        vm.credentials = {};
        vm.dismissAlert = _dismissAlert;
        vm.login = login;
        vm.password = null;
        vm.register = register;
        vm.rememberMe = true;
        vm.requestResetPassword = requestResetPassword;
        vm.username = null;
		if (backgroundPrepService instanceof Array) {
			$rootScope.background = backgroundPrepService[0].images.fanart.full;
		} else {
			$rootScope.background = backgroundPrepService;
		}
        
        function cancel () {
            vm.credentials = {
                username: null,
                password: null,
                rememberMe: true
            };
            vm.authenticationError = false;
        }
        
        function _dismissAlert() {
        	vm.authenticationError = false;
        }

        function login (event) {
            event.preventDefault();
            
            if (vm.formLogin.username.$invalid) {
            	vm.usernameError = true;
            	vm.authenticationError = false;
            } else {
            	vm.usernameError = false;
            }
            
            if (vm.formLogin.password.$invalid && vm.formLogin.username.$valid) {
            	vm.passwordError = true;
            	vm.authenticationError = false;
            } else {
            	vm.passwordError = false;
            }
            
            if (vm.formLogin.$invalid) return;
            	
            AuthService.login({
                username: vm.username,
                password: vm.password,
                rememberMe: vm.rememberMe
            }).then(function () {
                vm.authenticationError = false;
                vm.formError = false;
                
                $rootScope.$broadcast('authenticationSuccess');

                // previousState was set in the authExpiredInterceptor before being redirected to login modal.
                // since login is succesful, go to stored previousState and clear previousState
                if (AuthService.getPreviousState()) {
                    var previousState = AuthService.getPreviousState();
                    AuthService.resetPreviousState();
                    $state.go(previousState.name, previousState.params);
                }
                $state.go('home');
            }).catch(function () {
                vm.authenticationError = true;
                vm.username = null;
                vm.password = null;
                vm.formLogin.$setPristine();
            });
        }

        function register () {
            $state.go('register');
        }

        function requestResetPassword () {
            $state.go('requestReset');
        }
    }
})();
