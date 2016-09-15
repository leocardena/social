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
                hideNavbar: true
                //backgroundUrl: 'https://walter.trakt.us/images/movies/000/000/120/fanarts/original/f7884a908e.jpg'
            },
			views : {
				'content@' : {
					templateUrl : 'app/account/login/login.html',
					controller: 'LoginController',
					controllerAs: 'vm'
				}
			},
			resolve : {
				backgroundPrepService : backgroundPrepService
			}
		});
		
		backgroundPrepService.$inject = ['TraktMovieService', 'TraktShowService'];

        /* @ngInject */
        function backgroundPrepService (TraktMovieService, TraktShowService) {
        	var randomService = Math.floor((Math.random() * 2) + 1);
        	var randomPage = Math.floor((Math.random() * 100) + 1);
        	switch (randomService) {
        		case 1:
        			return TraktMovieService.getPopularMovies({
                		limit : 1,
                		extended : 'images',
                		page: randomPage
                	});
        		case 2:
        			return TraktShowService.getPopularShows({
                		limit : 1,
                		extended : 'images',
                		page: randomPage
                	});
        	}
    	}
   
		
	}

})();