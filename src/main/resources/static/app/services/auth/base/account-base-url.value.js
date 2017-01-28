(function () {

	'use strict';

	angular
			.module('social.services')
			.value('AccountBase', {
				url: '/api/rest/accounts',
				activate: '/api/rest/accounts/activate',
				register: '/api/rest/accounts/register'
			});
	
})();


