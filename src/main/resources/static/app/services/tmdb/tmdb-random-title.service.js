(function () {
	'use strict';
	
	angular
			.module('social.services.tmdb')
			.factory('TmdbRandomTitleService', TmdbRandomTitleService);
	
	TmdbRandomTitleService.$inject = ['TmdbMovieService', 'TmdbShowService'];
	
	/*@ngInject*/
	function TmdbRandomTitleService(TmdbMovieService, TmdbShowService) {
		
		var services = {
			getRandomTitle : _getRandomTitle
		}
		
		return services;
		
		function _getRandomTitle() {
			var randomService = Math.floor((Math.random() * 2) + 1);
        	var defaultBackground = { backdrop_path: 'https://image.tmdb.org/t/p/w1280/tFI8VLMgSTTU38i8TIsklfqS9Nl.jpg' };
        	switch (randomService) {
        		case 1:
        			return TmdbMovieService.getRandomPopularMovie({
        				size : 'w1280'
                	}).$promise.then(function(data, headers){
                		 return data;
                	}).catch(function () {
                		return defaultBackground;
                	});
        		case 2:
        			return TmdbShowService.getRandomPopularShow({
        				size : 'w1280'
                	}).$promise.then(function(data, headers){
                		 return data;
                	}).catch(function () {
                		return defaultBackground;
                	});
        	}
		}
		
	}
	
})();