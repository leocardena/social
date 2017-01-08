(function () {

	'use strict';

	angular
			.module('social.services')
			.value('AccountBase', {
				url: '/api/rest/accounts',
				activate: '/api/rest/account/activate',
				register: '/api/rest/account/register'
			});
	
})();


