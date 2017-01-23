(function() {
	'use strict';

	angular
			.module('social.user.profile')
			.config(config);

	config.$inject = ['$stateProvider'];

	/* @ngInejct */
	function config($stateProvider) {

		$stateProvider
		
	    .state('profile', {
	   	  	  parent: 'social',
	    	  url: "/{username}/profile",
	    	  params: {
	    		  username : null
	    	  },
	    	  data: {
					authorities: ['ROLE_USER'],
					pageTitle: 'Profile'
			  },
			  views: {
	    		  'content@': {
	    			  templateUrl : 'app/user/profile/user.profile.html',
	    			  controller: 'UserProfileController',
	    			  controllerAs : 'vm',
	    		  }
	    	  }
	    });
		
	}

})();