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
                pageTitle: 'Login',
                hideLoginDropdown: true
                //backgroundUrl: 'https://walter.trakt.us/images/movies/000/000/120/fanarts/original/f7884a908e.jpg'
            },
			views : {
				'content@' : {
					templateUrl : 'app/account/login/login.html',
					controller: 'LoginController',
					controllerAs: 'vm'
				}
			},
			params: {
				authenticationError: null
			},
			resolve : {
				backgroundPrepService : backgroundPrepService
			}
		});
		
		backgroundPrepService.$inject = ['TmdbRandomTitleService'];

        /* @ngInject */
        function backgroundPrepService (TmdbRandomTitleService) {
        	return TmdbRandomTitleService.getRandomTitle();
    	}
   
		
	}

})();