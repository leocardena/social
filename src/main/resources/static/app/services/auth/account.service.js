(function() {
	'use strict';

	angular.module('social.services').factory('AccountService', AccountService);

	AccountService.$inject = [ '$resource', 'AccountBase' ];

	function AccountService($resource, AccountBase) {
		var service = $resource(AccountBase.url, {}, {
			'get' : {
				method : 'GET',
				params : {},
				isArray : false,
				interceptor : {
					response : function(response) {
						// expose response
						return response;
					}
				}
			},
			'putAccount' : {
				method : 'PUT',
				url : AccountBase.url + '/:userId',
				params : {
					userId : '@userId'
				},
				isArray : false
			},
			'putPassword' : {
				method : 'PUT',
				url : AccountBase.url + '/credentials/:userId',
				params : {
					userId : '@userId'
				},
				isArray : false
			},
		});

		return service;
	}
})();
