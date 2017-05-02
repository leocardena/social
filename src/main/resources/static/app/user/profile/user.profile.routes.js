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
	    
	    .state('my-profile-activities', {
	    	parent: 'my-profile',
	    	url: '/activities',
	    	params: {
	    		ratings: null
	    	},
	    	data: {
	    		authorities: ['ROLE_USER'],
	    		pageTitle: 'Profile'
	    	},
	    	views: {
	    		'my-profile': {
	    			templateUrl : 'app/user/profile/my-profile-activities.html',
	    			controller: function(usernamePrepService){
	    			   var vm = this;
	    			   vm.ratings = usernamePrepService.ratings;
	    			},
	    			controllerAs: 'vm'
	    		}
	    	}
	    })
	    
	    .state('my-profile-info', {
	    	parent: 'my-profile',
	    	url: '/info',
	    	data: {
	    		authorities: ['ROLE_USER'],
	    		pageTitle: 'Profile'
	    	},
	    	views: {
	    		'my-profile': {
	    			templateUrl : 'app/user/profile/my-profile-info.html',
	    			controller: function(usernamePrepService, $rootScope){
	    				var vm = this;
	    				vm.user = JSON.parse(JSON.stringify(usernamePrepService));
	    			},
	    			controllerAs: 'vm'
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
	    	},
	    	resolve: {
	    		friendsByUsernamePrepService : friendsByUsernamePrepService
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
		
		friendsByUsernamePrepService.$inject = ['DomainFriendsService', '$stateParams'];
		
		/*@ngInject*/
		function friendsByUsernamePrepService(DomainFriendsService, $stateParams) {
			return DomainFriendsService.getFriendsByUsername({
				username : $stateParams.user.username,
				page: 0,
				size: 10
			}).$promise.then(function (data) {
				return data;
			}).catch(function (err) {
				return 'ERROR';
			});
		}
		
	}

})();