(function() {
    'use strict';

    angular
        .module('social.user.home')
        .controller('HomeLoggedController', HomeLoggedController);

    HomeLoggedController.$inject = ['PrincipalService', '$state', '$scope'];

    function HomeLoggedController (PrincipalService, $state, $scope) {
        var vm = this;
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
        
        

    }
    
})();
