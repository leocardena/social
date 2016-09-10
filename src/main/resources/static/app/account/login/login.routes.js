(function() {
	'use strict';

	angular
			.module('social.account.login')
			.config(config);

	config.$inject = [ '$stateProvider' ];

	/* @ngInejct */
	function config($stateProvider) {

		$stateProvider

		.state('login', {
			url : '/login',
			parent : 'account',
			data: {
                authorities: [],
                pageTitle: 'Login'
            },
			views : {
				'content@' : {
					templateUrl : 'app/account/login/login.html',
					controller: 'LoginController',
					controllerAs: 'vm'
				}
			}
		})
	}

})();