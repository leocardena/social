(function () {
	'use strict';
	
	angular
			.module('social.account', 
			['social.account.login',
			 'social.account.register',
			 'social.account.activate']);
})();