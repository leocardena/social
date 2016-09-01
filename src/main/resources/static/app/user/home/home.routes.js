(function() {
	'use strict';

	angular
			.module('social.user.home')
			.config(config);

	config.$inject = [ '$stateProvider' ];

	/* @ngInejct */
	function config($stateProvider) {

		$stateProvider

		.state('home', {
			url : '/home',
			parent : 'user',
			data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'Home'
            },
			views : {
				'content@' : {
					templateUrl : 'app/user/home/home.html',
					controller: 'HomeController',
					controllerAs: 'vm'
				}
			}
		})
	}

})();