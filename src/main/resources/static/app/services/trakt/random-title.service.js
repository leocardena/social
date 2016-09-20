(function () {
	'use strict';
	
	angular
			.module('social.services.trakt')
			.factory('RandomTitleService', RandomTitleService);
	
	RandomTitleService.$inject = ['TraktMovieService', 'TraktShowService'];
	
	/*@ngInject*/
	function RandomTitleService(TraktMovieService, TraktShowService) {
		
		var services = {
			getRandomTitle : _getRandomTitle
		}
		
		return services;
		
		function _getRandomTitle() {
        	var randomService = Math.floor((Math.random() * 2) + 1);
        	var randomPage = Math.floor((Math.random() * 5) + 1);
        	switch (randomService) {
        		case 1:
        			return TraktMovieService.getPopularMovies({
                		limit : 1,
                		extended : 'images',
                		page: randomPage
                	}).$promise.then(function(data, headersFun){
                		 return data;
                	}).catch(function () {
                		return "https://walter.trakt.us/images/movies/000/001/170/fanarts/original/c0ad7ea552.jpg";
                	});
        		case 2:
        			return TraktShowService.getPopularShows({
                		limit : 1,
                		extended : 'images',
                		page: randomPage
                	}).$promise.then(function(data, headersFun){
                		 return data;
                	}).catch(function () {
                		return "https://walter.trakt.us/images/movies/000/001/170/fanarts/original/c0ad7ea552.jpg";
                	});
        	}
		}
		
	}
	
})();