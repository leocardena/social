(function() {
	'use strict';

	angular.module('social.user.friends').controller('MyFriendsController',
			MyFriendsController);

	MyFriendsController.$inject = ['DomainFriendsService', 'myFriendsPrepService'];

	function MyFriendsController(DomainFriendsService, myFriendsPrepService) {
		var vm = this;
		// variables my friends
		vm.myFriendsTotalItens = myFriendsPrepService.totalElements;
		vm.myFriendsTotalPages = myFriendsPrepService.totalPages;
		vm.myFriendsItensPerPage = myFriendsPrepService.size;
		vm.myFriendsCurrentPage = myFriendsPrepService.number + 1;
		vm.myFriends = myFriendsPrepService.content;
		
		// utilities variables
	    vm.defaultAvatar = 'content/images/avatar/avatar-300x300.png';
	    
		// methods
		vm.pageMyFriendsChanged = _pageMyFriendsChanged;
		
		function _pageMyFriendsChanged() {
			DomainFriendsService.getMyFriends({
				status : 'Accept',
				page : vm.myFriendsCurrentPage - 1,
				size : 10
			}).$promise.then(function(data) {
				vm.myFriendsTotalItens = data.totalElements;
				vm.myFriendsTotalPages = data.totalPages;
				vm.myFriendsMaxSize = data.size;
				vm.myFriendsCurrentPage = data.number + 1;
				vm.myFriends = data.content;
			});
		}

	}

})();
