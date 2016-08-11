(function () {
	'use strict';
	
	angular
			.module('social.login')
			.config(config);
	
	config.$inject = ['$stateProvider'];
	
	/*@ngInejct*/
	function config($stateProvider) {
		
		$stateProvider
		
						.state('login', {
							url: '/login',
							templateUrl: 'app/login/login.html'
						})
	}
	
	
})();