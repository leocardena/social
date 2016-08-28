(function() {
	'use strict';

	angular
			.module('social.account.activate')
			.config(config);

	config.$inject = [ '$stateProvider' ];

	/* @ngInejct */
	function config($stateProvider) {

		$stateProvider

		.state('activate', {
			url : '/activate?',
			params: {
	            key: null
	        },
			parent : 'account',
			views : {
				'content@' : {
					templateUrl : 'app/account/activate/activate.html',
					controller: 'ActivationController',
					controllerAs: 'vm'
				}
			}
		})
	}

})();