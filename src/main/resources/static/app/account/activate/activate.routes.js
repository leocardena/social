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
			url : '/activate?key',
			params: {
	            key: null
	        },
			parent : 'account',
			data: {
                authorities: [],
                pageTitle: 'Ativação',
                hideNavbar: false
            },
			views : {
				'content@' : {
					templateUrl : 'app/account/activate/activate.html',
					controller: 'ActivationController',
					controllerAs: 'vm'
				}
			},
			resolve : {
				backgroundPrepService : backgroundPrepService
			}
		});
		
	}
	
	backgroundPrepService.$inject = ['TmdbRandomTitleService'];

    /* @ngInject */
    function backgroundPrepService (TmdbRandomTitleService) {
    	return TmdbRandomTitleService.getRandomStaticTitle();
	}

})();