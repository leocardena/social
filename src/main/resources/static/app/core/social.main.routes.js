(function () {
	
	'use strict';
	
	angular
		.module('social')
		.config(config);
	
	config.$inject = ['$stateProvider', '$urlRouterProvider', '$locationProvider'];
	
	/*@ngInject**/
	function config($stateProvider, $urlRouterProvider, $locationProvider) {
		
		$stateProvider
			
			.state('welcome', {
				url: '/',
				template: '<div>Welcome</div>'
			});
		
		$urlRouterProvider.otherwise('/');
		
		$locationProvider.html5Mode(true);
		
	}
	
})();