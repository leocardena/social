(function () {

	'use strict';

	angular
			.module('social.services.tmdb')
			.value('TmdbBase', {
				url : '/api/rest/tmdb',
				movie : '/api/rest/tmdb/movie',
				show : '/api/rest/tmdb/show',
				person : '/api/rest/tmdb/person'
			});
	
})();


