(function() {
	'use strict';

	angular.module('social.user.friends').controller('PendingFriendsController',
			PendingFriendsController);

	PendingFriendsController.$inject = ['DomainFriendsService', 'pendingFriendsPrepService', '$scope'];

	function PendingFriendsController(DomainFriendsService, pendingFriendsPrepService, $scope) {
		var vm = this;

		// variables peding friends
		vm.waitingFriends = pendingFriendsPrepService.content;
		vm.waitingFriendsTotalItens = pendingFriendsPrepService.totalElements;
		vm.waitingFriendsTotalPages = pendingFriendsPrepService.totalPages;
		vm.waitingFriendsItensPerPage = pendingFriendsPrepService.size;
		vm.waitingFriendsCurrentPage = pendingFriendsPrepService.number + 1;
		
		// utilities variables
	    vm.defaultAvatar = 'content/images/avatar/avatar-300x300.png';
	    
		// methods
		vm.pageWatingFriendsChanged = _pageWatingFriendsChanged;
		vm.replyRequest = _replyRequest;
		
		function _replyRequest(action, friend) {
        	vm.isLoadingReply = true;
        	DomainFriendsService.patchFriends({
        		friendId: friend.id
	     	}, {status: action}).$promise.then(function (data) {
	     		refreshFriendsData();
	     		vm.isLoadingReply = false;
	     	}).catch(function (err) {
	     		vm.isLoadingReply = false;
	     	});
		}
		
		function _pageWatingFriendsChanged() {
			DomainFriendsService.getMyFriends({
				status : 'Waiting',
				page : vm.waitingFriendsCurrentPage - 1,
				size : 1
			}).$promise.then(function(data) {
				vm.waitingFriends = data.content;
				vm.waitingFriendsTotalItens = data.totalElements;
				vm.waitingFriendsTotalPages = data.totalPages;
				vm.waitingFriendsMaxSize = data.size;
				vm.waitingFriendsCurrentPage = data.number + 1;
			});
		}
		
		function refreshFriendsData() {
			getWatingFriends();
			$scope.$emit('updateFriendsSidebar', {});
		}
		
		function getWatingFriends() {
        	DomainFriendsService.getMyFriends({
        		status : 'Waiting',
        		page: 0,
        		size: 1
        	}).$promise.then(function (data) {
        		vm.waitingFriends = data.content;
        		vm.waitingFriendsTotalItens = data.totalElements;
        		vm.waitingFriendsTotalPages = data.totalPages;
        		vm.waitingFriendsItensPerPage = data.size;
        		vm.waitingFriendsCurrentPage = data.number + 1;
        	});
		}

	}

})();
