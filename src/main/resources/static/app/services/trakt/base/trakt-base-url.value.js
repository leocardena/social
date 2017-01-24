(function () {

	'use strict';

	angular
			.module('social.services.trakt')
			.value('TraktBase', {
				url : '/api/rest/trakt',
				movie : '/api/rest/trakt/movies',
				show : '/api/rest/trakt/shows',
				search : '/api/rest/trakt/search' ,
				person: '/api/rest/trakt/persons'
			});
	
})();


