(function () {
	
	'use strict';
	
	angular
		.module('social', ['social.core', 
		                   'social.account', 
		                   'social.services',
		                   'social.blocks',
		                   'social.user',
		                   'social.layouts'])
		                   .run(run);

		                   run.$inject = ['stateHandler'];

		                   function run(stateHandler) {
		                       stateHandler.initialize();
		                   }
	
})();