(function () {
	'use strict';
	
	angular
			.module('social.user', 
			['social.user.home',
			 'social.user.profile',
			 'social.user.friends',
			 'social.user.settings']);
})();