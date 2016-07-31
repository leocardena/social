(function () {
	
	'use strict';
	
	angular
		.module('social')
		.config(config);
	
	config.$inject = ['$stateProvider', '$urlRouterProvider'];
	
	/*@ngInject**/
	function config($stateProvider, $urlRouterProvider) {
		
		$stateProvider
			
			.state('welcome', {
				url: '/',
				template: '<div>Welcome</div>'
			});
		
		$urlRouterProvider.otherwise('/');
		
	}
	
})();