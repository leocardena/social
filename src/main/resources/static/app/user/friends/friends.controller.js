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

		// variables
		vm.myFriendsTotalItens = myFriendsPrepService.totalElements;
		vm.myFriendsTotalPages = myFriendsPrepService.totalPages;
		vm.myFriendsItensPerPage = myFriendsPrepService.size;
		vm.myFriendsCurrentPage = myFriendsPrepService.number + 1;
		vm.myFriends = myFriendsPrepService.content;
		vm.myFriendsQtd = 'Amigos ' + '(' + myFriendsTotalPrepService.total + ')';
		
		vm.waitingFriends = waitingFriendsPrepService.content;
		vm.waitingFriendsTotalItens = waitingFriendsPrepService.totalElements;
		vm.waitingFriendsTotalPages = waitingFriendsPrepService.totalPages;
		vm.waitingFriendsItensPerPage = waitingFriendsPrepService.size;
		vm.waitingFriendsCurrentPage = waitingFriendsPrepService.number + 1;
		vm.waitingFriendsQtd = 'Pendentes ' + '(' + waitingFriendsTotalPrepService.total + ')';

		// methods
		vm.pageMyFriendsChanged = _pageMyFriendsChanged;
		vm.pageWatingFriendsChanged = _pageWatingFriendsChanged;

		function _pageMyFriendsChanged() {
			return DomainFriendsService.getMyFriends({
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

	}

})();
