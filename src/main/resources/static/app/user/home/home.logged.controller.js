(function() {
    'use strict';

    angular
        .module('social.user.home')
        .controller('HomeLoggedController', HomeLoggedController);

    HomeLoggedController.$inject = ['PrincipalService', '$state', '$scope', 'AuthService'];

    function HomeLoggedController (PrincipalService, $state, $scope, AuthService) {
        var vm = this;
        vm.logout = _logout;
        $scope.$on('authenticationSuccess', function() {
            getAccount();
        });

        getAccount();

        function getAccount() {
            PrincipalService.identity().then(function(account) {
                vm.account = account;
                vm.isAuthenticated = PrincipalService.isAuthenticated;
            });
        }
        
        function _logout() {
            AuthService.logout();
            $state.go('login');
        }

    }
    
})();
