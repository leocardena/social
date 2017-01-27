(function () {
	'use strict';
	
	angular
			.module('social.services', ['social.services.trakt',
			                            'social.services.tmdb',
			                            'social.services.domain']);
	
})();
