(function() {
	'use strict';

	angular.module('social.user.friends').controller('FriendsController',
			FriendsController);

	FriendsController.$inject = [ 'DomainFriendsService',
			'waitingFriendsTotalPrepService', 'myFriendsTotalPrepService',
			'$scope' ];

	function FriendsController(DomainFriendsService,
			waitingFriendsTotalPrepService, myFriendsTotalPrepService, $scope) {
		var vm = this;
		vm.myFriendsQtd = myFriendsTotalPrepService.total;
		vm.waitingFriendsQtd = waitingFriendsTotalPrepService.total;

		$scope.$on('updateFriendsSidebar', function(event, data) {
			getMyFriendsTotal();
			getWaitingFriendsTotal();
		});

		function getMyFriendsTotal() {
			DomainFriendsService.getTotalFriends({
				status : 'Accept'
			}).$promise.then(function(data) {
				vm.myFriendsQtd = data.total;
			});
		}

		function getWaitingFriendsTotal() {
			DomainFriendsService.getTotalFriends({
				status : 'Waiting'
			}).$promise.then(function(data) {
				vm.waitingFriendsQtd = data.total;
			});
		}

	}

})();
