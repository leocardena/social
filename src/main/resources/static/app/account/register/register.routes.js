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
						  data: {
				                authorities: [],
				                pageTitle: 'Cadastrar',
				                hideNavbar: false
				          },
						  views: {
							  'content@': {
				                    templateUrl: 'app/account/register/register.html',
				                    controller: 'RegisterController',
				                    controllerAs: 'vm'
				                }
						  },
						  resolve : {
							  countriesPrepareService : countriesPrepareService
						  }
					  });
		
		countriesPrepareService.$inject = ['RegionService'];
		
		/*@ngInject*/
		function countriesPrepareService(RegionService) {
			return RegionService.getCountries().then(function (response) {
                return response;
            }).catch(function (response) {
                if (response.status === 400) {
                    return 'ERROR';
                }  else {
                	return 'ERROR';
                }
            });
		}
		
	}
	
	
})();