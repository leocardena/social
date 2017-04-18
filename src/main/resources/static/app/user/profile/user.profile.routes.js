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
	    	  url: '/{username}',
	    	  params: {
	    		  username : null
	    	  },
	    	  data: {
					authorities: ['ROLE_USER'],
					pageTitle: 'Profile'
			  },
			  views: {
	    		  'content@': {
	    			  controller: 'ProfileController'
	    		  }
	    	  },
	    	  resolve: {
	    		  usernamePrepService: usernamePrepService
	    	  }
	    })
	    
	    .state('my-profile', {
	    	parent: 'profile',
	    	url: '',
	    	params: {
	    		username : null,
	    		user: null
	    	},
	    	data: {
	    		authorities: ['ROLE_USER'],
	    		pageTitle: 'Profile'
	    	},
	    	views: {
	    		'content@': {
	    			templateUrl : 'app/user/profile/my-profile.html',
	    			controller: 'MyProfileController',
	    			controllerAs : 'vm',
	    		}
	    	}
	    })
	    
	    .state('other-profile', {
	    	parent: 'profile',
	    	url: '',
	    	params: {
	    		username : null,
	    		user: null
	    	},
	    	data: {
	    		authorities: ['ROLE_USER'],
	    		pageTitle: 'Profile'
	    	},
	    	views: {
	    		'content@': {
	    			templateUrl : 'app/user/profile/other-profile.html',
	    			controller: 'OtherProfileController',
	    			controllerAs : 'vm',
	    		}
	    	}
	    });
		
		usernamePrepService.$inject = ['DomainProfilesService', '$stateParams'];
		
		/*@ngInject*/
		function usernamePrepService(DomainProfilesService, $stateParams) {
        	return DomainProfilesService.getOneByUsername({
        		username : $stateParams.username
        	}).$promise.then(function (data) {
        		return data;
        	}).catch(function (err) {
        		return 'NOT-FOUND';
        	});
		}
		
	}

})();