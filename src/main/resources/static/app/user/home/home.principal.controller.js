(function() {
    'use strict';

    angular
        .module('social.user.home')
        .controller('HomePrincipalController', HomePrincipalController);

    HomePrincipalController.$inject = ['$state', 'PrincipalService'];

    function HomePrincipalController ($state, PrincipalService) {
       
    	if(PrincipalService.isAuthenticated()) {
        	$state.go('logged');
        } else {
        	$state.go('public');
        }
        
    }
    
})();
