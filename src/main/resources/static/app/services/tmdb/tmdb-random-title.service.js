(function () {
	'use strict';
	
	angular
			.module('social.services.tmdb')
			.factory('TmdbRandomTitleService', TmdbRandomTitleService);
	
	TmdbRandomTitleService.$inject = ['TmdbMovieService', 'TmdbShowService'];
	
	/*@ngInject*/
	function TmdbRandomTitleService(TmdbMovieService, TmdbShowService) {
		
		var services = {
			getRandomTitle : _getRandomTitle,
			getRandomStaticTitle : _getRandomStaticTitle
		}
		
		return services;
		
		function _getRandomStaticTitle() {
			var randomService = Math.floor((Math.random() * 2) + 1);
        	
        	switch (randomService) {
        		case 1:
        			var movies = [
        			    { name : 'Dr strange', background: 'https://image.tmdb.org/t/p/w1280/tFI8VLMgSTTU38i8TIsklfqS9Nl.jpg'},
        			    { name: 'Moana', background: 'https://image.tmdb.org/t/p/w1280/1qGzqGUd1pa05aqYXGSbLkiBlLB.jpg' },
        			    { name: 'Assassins Creed', background: 'https://image.tmdb.org/t/p/w1280/r8aRipzR4wlDx0m7Bpi43Q84imc.jpg' },
        			    { name: 'Fantastic Beasts and Where to Find Them', background: 'https://image.tmdb.org/t/p/w1280/6I2tPx6KIiBB4TWFiWwNUzrbxUn.jpg' },
        			    { name: 'Interstellar', background: 'https://image.tmdb.org/t/p/w1280/xu9zaAevzQ5nnrsXN6JcahLnG4i.jpg' },
        			    { name: 'Guerra Civil', background: 'https://image.tmdb.org/t/p/w1280/m5O3SZvQ6EgD5XXXLPIP1wLppeW.jpg' },
        			    { name: 'rogue one', background: 'https://image.tmdb.org/t/p/w1280/tZjVVIYXACV4IIIhXeIM59ytqwS.jpg' }
        			];
        			
        			var randomMovie = Math.floor((Math.random() * ( movies.length - 1 ) ) + 0);
        			
        			return movies[randomMovie].background;
        		case 2:
        			var shows = [
        			    { name : 'GOT', background: 'https://image.tmdb.org/t/p/w1280/mUkuc2wyV9dHLG0D0Loaw5pO2s8.jpg'},
        	        	{ name: 'Breaking Bead', background: 'https://image.tmdb.org/t/p/w1280/eSzpy96DwBujGFj0xMbXBcGcfxX.jpg' },
        	        	{ name: 'The Walking Dead', background: 'https://image.tmdb.org/t/p/w1280/qCqGdMqt4YUeNijzuISH8NVLyjM.jpg' },
        	        	{ name: 'TBBT', background: 'https://image.tmdb.org/t/p/w1280/nGsNruW3W27V6r4gkyc3iiEGsKR.jpg' },
        	        	{ name: 'Dexter', background: 'https://image.tmdb.org/t/p/w1280/cqxbVAJF2diILYtXKujBJDADT3y.jpg' },
        	        	{ name: 'Friends', background: 'https://image.tmdb.org/t/p/w1280/k0YPULhTeFaTIcttOZpnzc6g9rE.jpg' },
        	        	{ name: 'Supernatural', background: 'https://image.tmdb.org/t/p/w1280/ommJ8rutMqJ7zcjpH9Q4UrEHGvh.jpg' }
        	        ];
        	        			
        			var randomShow = Math.floor((Math.random() * ( shows.length - 1 ) ) + 0);
        	        			
        			return shows[randomShow].background;
        	}
		}
		
		/* em desuso */
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