(function () {
	
	'use strict';
	
	angular
		   .module('social.services.domain')
		   .value('DomainBase', {
				url : "/api/rest",
				movie : "/api/rest/movies",
				account : "/api/rest/accounts",
				avatar : "/api/rest/avatars",
				lists : "/api/rest/lists",
				show: "/api/rest/shows",
				actor: "/api/rest/actors"
		   });
	
})();