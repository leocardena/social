(function() {
	'use strict';

	angular.module('social.user.friends').controller('FriendsController',
			FriendsController);

	FriendsController.$inject = [ 'myFriendsPrepService',
			'waitingFriendsPrepService', 'DomainFriendsService', 'waitingFriendsTotalPrepService', 
			'myFriendsTotalPrepService'];

	function FriendsController(myFriendsPrepService, waitingFriendsPrepService,
			DomainFriendsService, waitingFriendsTotalPrepService, myFriendsTotalPrepService) {
		var vm = this;

		// variables my friends
		vm.myFriendsTotalItens = myFriendsPrepService.totalElements;
		vm.myFriendsTotalPages = myFriendsPrepService.totalPages;
		vm.myFriendsItensPerPage = myFriendsPrepService.size;
		vm.myFriendsCurrentPage = myFriendsPrepService.number + 1;
		vm.myFriends = myFriendsPrepService.content;
		vm.myFriendsQtd = myFriendsTotalPrepService.total;
		
		// variables waiting friends
		vm.waitingFriends = waitingFriendsPrepService.content;
		vm.waitingFriendsTotalItens = waitingFriendsPrepService.totalElements;
		vm.waitingFriendsTotalPages = waitingFriendsPrepService.totalPages;
		vm.waitingFriendsItensPerPage = waitingFriendsPrepService.size;
		vm.waitingFriendsCurrentPage = waitingFriendsPrepService.number + 1;
		vm.waitingFriendsQtd = waitingFriendsTotalPrepService.total;
		
		// utilities variables
        vm.defaultAvatar = 'content/images/avatar/avatar-300x300.png';
        vm.isLoadingReply = false;

		// methods
		vm.pageMyFriendsChanged = _pageMyFriendsChanged;
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
			getMyFriends();
			getMyFriendsTotal();
			getWatingFriends();
			getWaitingFriendsTotal();
		}
		
		function getMyFriends() {
        	DomainFriendsService.getMyFriends({
        		status : 'Accept',
        		page: 0,
        		size: 10
        	}).$promise.then(function (data) {
        		vm.myFriendsTotalItens = data.totalElements;
        		vm.myFriendsTotalPages = data.totalPages;
        		vm.myFriendsItensPerPage = data.size;
        		vm.myFriendsCurrentPage = data.number + 1;
        		vm.myFriends = data.content;
        	});
		}
		
		function getMyFriendsTotal() {
        	DomainFriendsService.getTotalFriends({
        		status : 'Accept'
        	}).$promise.then(function (data) {
        		vm.myFriendsQtd = data.total;
        	});
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
		
		function getWaitingFriendsTotal() {
			DomainFriendsService.getTotalFriends({
        		status : 'Waiting'
        	}).$promise.then(function (data) {
        		vm.waitingFriendsQtd =  data.total;
        	});
		}

	}

})();
