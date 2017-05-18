(function() {
	'use strict';

	angular.module('social.user.settings').config(config);

	config.$inject = [ '$stateProvider' ];

	/* @ngInejct */
	function config($stateProvider) {

		$stateProvider
		
		.state('settings', {
			url: '/settings',
			parent : 'my-profile',
			params: {
				option: null
			},
			data : {
				authorities : [ 'ROLE_USER' ],
				pageTitle : 'Configuração'
			},
			 views : {
					'my-profile' : {
						templateUrl : 'app/user/settings/settings.html',
						controller : 'SettingsController',
						controllerAs : 'vm'
					}
			},
			resolve: {
				countriesPrepareService: countriesPrepareService,
				usernamePrepService: usernamePrepService
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
		
		usernamePrepService.$inject = ['AccountService', '$stateParams'];
		
		/*@ngInject*/
		function usernamePrepService(AccountService, $stateParams) {
        	return AccountService.getAcc().$promise.then(function (data) {
        		return data;
        	}).catch(function (err) {
        		return 'NOT-FOUND';
        	});
		}
		
        
	}

})();