(function () {

	'use strict';

	angular
			.module('social.services.trakt')
			.value('TraktBase', {
				url : '/api/rest/trakt',
				movie : '/api/rest/trakt/movie',
				show : '/api/rest/trakt/show',
				search : '/api/rest/trakt/search' 
			});
	
})();


