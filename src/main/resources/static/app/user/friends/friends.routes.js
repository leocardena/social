(function() {
	'use strict';

	angular.module('social.user.friends').config(config);

	config.$inject = [ '$stateProvider' ];

	/* @ngInejct */
	function config($stateProvider) {

		$stateProvider
		
		.state('friends', {
			parent : 'my-profile',
			data : {
				authorities : [ 'ROLE_USER' ],
				pageTitle : 'Amigos'
			},
			 views : {
					'my-profile' : {
						templateUrl : 'app/user/friends/friends.html',
						controller : 'FriendsController',
						controllerAs : 'vm'
					}
			}, 
			resolve: {
				myFriendsTotalPrepService: myFriendsTotalPrepService,
				waitingFriendsTotalPrepService: waitingFriendsTotalPrepService
			}
		})

		.state('myFriends', {
			url : "/friends",
			parent : 'friends',
			data : {
				authorities : [ 'ROLE_USER' ],
				pageTitle : 'Meus Amigos'
			},
					templateUrl : 'app/user/friends/my-friends.html',
					controller : 'MyFriendsController',
					controllerAs : 'vm'
				,
			resolve : {
				myFriendsPrepService: myFriendsPrepService
			}
		})
		
		.state('pending', {
			url : "/friends/pending",
			parent : 'friends',
			data : {
				authorities : [ 'ROLE_USER' ],
				pageTitle : 'Amigos Pendentes'
			},
					templateUrl : 'app/user/friends/pending-friends.html',
					controller : 'PendingFriendsController',
					controllerAs : 'vm',
			resolve : {
				pendingFriendsPrepService: pendingFriendsPrepService
			}
		})
		
		.state('search-friends', {
			url : "/friends/search?query?page",
			parent : 'friends',
			data : {
				authorities : [ 'ROLE_USER' ],
				pageTitle : 'Pesquisa de Usuários'
			},
			templateUrl : 'app/user/friends/search-friends.html',
			controller : 'SearchFriendsController',
			controllerAs : 'vm',
			resolve : {
				searchPrepService : searchPrepService
			}
		});

		myFriendsPrepService.$inject = ['DomainFriendsService'];

        /* @ngInject */
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

        /* @ngInject */
        function myFriendsTotalPrepService (DomainFriendsService) {
        	return DomainFriendsService.getTotalFriends({
        		status : 'Accept'
        	}).$promise.then(function (data) {
        		return data;
        	});
        }

        pendingFriendsPrepService.$inject = ['DomainFriendsService'];

        /* @ngInject */
        function pendingFriendsPrepService (DomainFriendsService) {
        	return DomainFriendsService.getMyFriends({
        		status : 'Waiting',
        		page: 0,
        		size: 1
        	}).$promise.then(function (data) {
        		return data;
        	});
        }

        waitingFriendsTotalPrepService.$inject = ['DomainFriendsService'];

        /* @ngInject */
        function waitingFriendsTotalPrepService (DomainFriendsService) {
        	return DomainFriendsService.getTotalFriends({
        		status : 'Waiting'
        	}).$promise.then(function (data) {
        		return data;
        	});
        }

        searchPrepService.$inject = ['DomainProfilesService', '$stateParams'];

        /* @ngInject */
        function searchPrepService (DomainProfilesService, $stateParams) {
        	if ($stateParams.query) {
                	return DomainProfilesService.getByUsername({
                		page : $stateParams.page ? $stateParams.page - 1 : '0',
                		size : '10',
                		username : $stateParams.query
                	}).$promise.then(function(data){
                		return data;
                	}).catch(function () {
                	});
        	} else {
                return 'NO_SEARCH';
            }
        }

	}

})();