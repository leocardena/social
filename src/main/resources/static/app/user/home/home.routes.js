(function() {
	'use strict';

	angular
			.module('social.user.home')
			.config(config);

	config.$inject = ['$stateProvider'];

	/* @ngInejct */
	function config($stateProvider) {

		$stateProvider
		
	    .state('home', {
	    	  url: "/",
	    	  parent: 'social',
	    	  data: {
					authorities: [],
					pageTitle: 'Social'
			  },
			  views: {
	    		  'content@': {
	    			  controller: 'HomePrincipalController'
	    		  }
	    	  }
	    })
		
		.state('public', {
			url: '',
			parent: 'home',
			data: {
				authorities: [],
				pageTitle: 'Social'
			},
			views : {
				'content@' : {
					templateUrl : 'app/user/home/home.public.html',
					controller: 'HomePublicController',
					controllerAs: 'vm'
				}
			}
		})

		.state('logged', {
			url: '',
			parent: 'home',
			data: {
				authorities: ['ROLE_USER'],
				pageTitle: 'Dashboard'
			},
			views : {
				'content@' : {
					templateUrl : 'app/user/home/home.logged.html',
					controller: 'HomeLoggedController',
					controllerAs: 'vm'
				}
			}
		});
		
		
	}

})();