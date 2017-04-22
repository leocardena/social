(function () {
	'use strict';
	
	angular
			.module('social.services.domain')
			.factory('DomainFriendsService', DomainFriendsService);
	
	DomainFriendsService.$inject = ['DomainBase', '$resource'];
	
	/* @ngInject */
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
			},
			'patchFriends' : {
				method: 'PATCH',
				url: DomainBase.friend + '/:friendId',
				params: {
					friendId : '@friendId'
				}
			},
			'postFriends' : {
				method: 'POST',
				url: DomainBase.friend
			},
			'deleteFriends' : {
				method: 'DELETE',
				url: DomainBase.friend + '/:friendId',
				params: {
					friendId : '@friendId'
				}
			},
			'getFriendsByUsername' : {
				method: 'GET',
				url: DomainBase.friend + '/:username/friends',
				params: {
					username : '@username',
					page: '@page',
					size: '@size'
				},
				isArray : false
			}
		} );
		
		return service;
	}
	
})();