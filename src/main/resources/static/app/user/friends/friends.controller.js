(function() {
	'use strict';

	angular.module('social.user.friends').controller('FriendsController',
			FriendsController);

	FriendsController.$inject = [ 'DomainFriendsService',
			'waitingFriendsTotalPrepService', 'myFriendsTotalPrepService',
			'$scope', 'PrincipalService'];

	function FriendsController(DomainFriendsService,
			waitingFriendsTotalPrepService, myFriendsTotalPrepService, $scope, PrincipalService) {
		var vm = this;
		vm.myFriendsQtd = myFriendsTotalPrepService.total;
		vm.waitingFriendsQtd = waitingFriendsTotalPrepService.total;
		vm.user = JSON.parse(JSON.stringify(PrincipalService.getUserInformation()));

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
