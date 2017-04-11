(function () {
	'use strict';
	
	angular
			.module('social.services.domain')
			.factory('DomainFriendsService', DomainFriendsService);
	
	DomainFriendsService.$inject = ['DomainBase', '$resource'];
	
	/*@ngInject*/
	function DomainFriendsService(DomainBase, $resource) {
		var service =  $resource( DomainBase.friend, {}, {
			'getMyFriends' : {
				method: 'GET',
				url: DomainBase.friend,
				params: {
					status : '@status',
					page: '@page',
					size: '@size'
				},
				isArray : false
			},
			'getTotalFriends' : {
				method: 'GET',
				url: DomainBase.friend + '/total',
				params: {
					status : '@status'
				},
				isArray : false
			}
		} );
		
		return service;
	}
	
})();