(function () {

	'use strict';

	angular
			.module('social.services.trakt')
			.value('TraktMovieBase', {
				url : '/api/rest/trakt/movie'
			});
	
})();


