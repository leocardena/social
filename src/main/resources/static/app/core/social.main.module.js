(function () {
	
	'use strict';
	
	angular
		.module('social', ['social.core', 
		                   'social.account', 
		                   'social.services',
		                   'social.blocks',
		                   'social.user',
		                   'social.layouts',
		                   'social.search',
		                   'social.title'])
		                   .run(runStateHandler);

		                   runStateHandler.$inject = ['stateHandler'];

		                   function runStateHandler(stateHandler) {
		                       stateHandler.initialize();
		                   }
	
})();