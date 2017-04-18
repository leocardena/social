(function() {
    'use strict';

    angular
        .module('social.user.profile')
        .controller('ProfileController', ProfileController);

    ProfileController.$inject = ['$state', 'usernamePrepService', 'PrincipalService'];

    function ProfileController ($state, usernamePrepService, PrincipalService) {
    	var search = usernamePrepService;
        var logged = PrincipalService.getUserInformation();
    	
    	if (search === 'NOT-FOUND') {
    		console.log('n encontrado');
    		$state.go('notfound');
    	}
    	
    	if (search.id === logged.id) {
    		$state.go('my-profile', {user : logged});
    	} else {
    		$state.go('other-profile', {user : search});
    	}
    	
    }
    
})();
