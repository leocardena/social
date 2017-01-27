(function () {

	'use strict';

	angular
			.module('social.services.tmdb')
			.value('TmdbBase', {
				url : '/api/rest/tmdb',
				movie : '/api/rest/tmdb/movies',
				show : '/api/rest/tmdb/shows',
				person : '/api/rest/tmdb/persons'
			});
	
})();