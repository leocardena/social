(function() {
    'use strict';

    angular
        .module('social.user.home')
        .controller('HomeLoggedController', HomeLoggedController);

    HomeLoggedController.$inject = ['PrincipalService', '$http'];

    function HomeLoggedController (PrincipalService, $http) {
        var vm = this;
        
        getAccount();
        
        //$rootScope.$broadcast('authenticationSuccess');

        function getAccount() {
//            PrincipalService.identity().then(function(account) {
//                vm.account = account;
//                vm.isAuthenticated = PrincipalService.isAuthenticated;
//            });
        	
        	vm.account = PrincipalService.getUserInformation();
        	vm.isAuthenticated = PrincipalService.isAuthenticated;
        }
        
    }
    
})();
