(function () {

	'use strict';

	angular
			.module('social.services.trakt')
			.value('TraktShowBase', {
				url : '/api/rest/trakt/show'
			});
	
})();


