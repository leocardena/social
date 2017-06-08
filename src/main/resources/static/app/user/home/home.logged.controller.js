(function() {
    'use strict';

    angular
        .module('social.user.home')
        .controller('HomeLoggedController', HomeLoggedController);

    HomeLoggedController.$inject = ['PrincipalService', '$state'];

    function HomeLoggedController (PrincipalService, $state) {
        var vm = this;
        
        getAccount();

        function getAccount() {
        	vm.account = PrincipalService.getUserInformation();
        	vm.isAuthenticated = PrincipalService.isAuthenticated;
    		
        }
                
    }
    
})();
