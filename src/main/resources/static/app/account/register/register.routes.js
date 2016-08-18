(function () {
	
	'use strict';
	
	angular
			.module('social.account.register')
			.config(config);
	
	config.$inject = ['$stateProvider'];
	
	/*@ngInject*/
	function config ($stateProvider) {
			
		$stateProvider
					  .state('register', {
						  parent : 'account',
						  url: '/cadastrar',
						  views: {
							  'content@': {
				                    templateUrl: 'app/account/register/register.html',
				                    controller: 'RegisterController',
				                    controllerAs: 'vm'
				                }
						  }
					  })	
		
	}
	
	
})();