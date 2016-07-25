(function () {
	
	'use strict';
	
	angular
		.module('social')
		.config(config);
	
	config.$inject = ['$stateProvider', '$urlRouterProvider', '$locationProvider'];
	
	/*@ngInject**/
	function config($stateProvider, $urlRouterProvider, $locationProvider) {
		 
		$locationProvider.html5Mode(true);
		
		$urlRouterProvider.otherwise('/');
		
		$stateProvider
			
			.state('welcome', {
				url: '/',
				template: '<div>Welcome</div>'
			});
		
	}
	
})();