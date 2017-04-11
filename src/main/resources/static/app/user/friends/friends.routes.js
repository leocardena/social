(function() {
	'use strict';

	angular.module('social.user.friends').config(config);

	config.$inject = [ '$stateProvider' ];

	/* @ngInejct */
	function config($stateProvider) {

		$stateProvider

		.state('friends', {
			url : "/friends",
			parent : 'social',
			data : {
				authorities : [ 'ROLE_USER' ],
				pageTitle : 'Amigos'
			},
			views : {
				'content@' : {
					templateUrl : 'app/user/friends/friends.html',
					controller : 'FriendsController',
					controllerAs : 'vm'
				}
			}, 
			resolve : {
				myFriendsPrepService: myFriendsPrepService,
				myFriendsTotalPrepService: myFriendsTotalPrepService,
				waitingFriendsPrepService: waitingFriendsPrepService,
				waitingFriendsTotalPrepService: waitingFriendsTotalPrepService
			}
		});
		
		myFriendsPrepService.$inject = ['DomainFriendsService'];
        
        /*@ngInject*/
        function myFriendsPrepService (DomainFriendsService) {
        	return DomainFriendsService.getMyFriends({
        		status : 'Accept',
        		page: 0,
        		size: 10
        	}).$promise.then(function (data) {
        		return data;
        	});
        }
        
        myFriendsTotalPrepService.$inject = ['DomainFriendsService'];
        
        /*@ngInject*/
        function myFriendsTotalPrepService (DomainFriendsService) {
        	return DomainFriendsService.getTotalFriends({
        		status : 'Accept'
        	}).$promise.then(function (data) {
        		return data;
        	});
        }
        
        waitingFriendsPrepService.$inject = ['DomainFriendsService'];
        
        /*@ngInject*/
        function waitingFriendsPrepService (DomainFriendsService) {
        	return DomainFriendsService.getMyFriends({
        		status : 'Waiting',
        		page: 0,
        		size: 1
        	}).$promise.then(function (data) {
        		return data;
        	});
        }
        
        waitingFriendsTotalPrepService.$inject = ['DomainFriendsService'];
        
        /*@ngInject*/
        function waitingFriendsTotalPrepService (DomainFriendsService) {
        	return DomainFriendsService.getTotalFriends({
        		status : 'Waiting'
        	}).$promise.then(function (data) {
        		return data;
        	});
        }

	}

})();