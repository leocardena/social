(function() {
    'use strict';

    angular
        .module('social.user.profile')
        .controller('OtherProfileController', OtherProfileController);

    OtherProfileController.$inject = ['$stateParams', 'DomainFriendsService', 'DomainProfilesService',
    	'friendsByUsernamePrepService', 'PrincipalService'];

    function OtherProfileController ($stateParams, DomainFriendsService, DomainProfilesService,
    		friendsByUsernamePrepService, PrincipalService) {
        var vm = this;
        vm.defaultAvatar = 'content/images/avatar/avatar-300x300.png';
        vm.user = $stateParams.user;
        vm.friends = friendsByUsernamePrepService.content;
		vm.friendsTotalItens = friendsByUsernamePrepService.totalElements;
		vm.friendsTotalPages = friendsByUsernamePrepService.totalPages;
		vm.friendsItensPerPage = friendsByUsernamePrepService.size;
		vm.friendsCurrentPage = friendsByUsernamePrepService.number + 1;
		
        vm.loggedId = PrincipalService.getUserInformation().id;
		
		// methods
		vm.pageFriendsChanged = _pageFriendsChanged;
		vm.replyRequest = _replyRequest;
		vm.addFriend = _addFriend;
	    vm.removeFriend = _removeFriend;
	    vm.removeFriendFromList = _removeFriendFromList;
	    vm.addFriendFromList = _addFriendFromList;
		vm.replyRequestFromList = _replyRequestFromList;
        
        function _addFriend(idFriend) {
        	DomainFriendsService.postFriends({}, 
        			{idFriend : idFriend})
        	.$promise.then(function (data) {
        		vm.user.friendStatus = data.status;
        	}).catch(function (err) {
        		console.log('error');
        	});
        }
        
        function _addFriendFromList(idFriend) {
        	DomainFriendsService.postFriends({}, 
        			{idFriend : idFriend})
        			.$promise.then(function (data) {
        				getProfileFriends(vm.friendsCurrentPage - 1);
        			}).catch(function (err) {
        				console.log('error');
        			});
        }	
        
        function _removeFriend(idFriend) {
        	DomainFriendsService.deleteFriends({
        		friendId : idFriend
        	}).$promise.then(function (data) {
        		getFriendByUsername();
        	}).catch(function (err) {
        		console.log('error');
        	});
        }
        
        function _removeFriendFromList(idFriend) {
        	DomainFriendsService.deleteFriends({
        		friendId : idFriend
        	}).$promise.then(function (data) {
				getProfileFriends(vm.friendsCurrentPage - 1);
        	}).catch(function (err) {
        		console.log('error');
        	});
        }
        
		function _replyRequest(action, friend) {
        	vm.isLoadingReply = true;
        	DomainFriendsService.patchFriends({
        		friendId: friend.id
	     	}, {status: action}).$promise.then(function (data) {
	     		getFriendByUsername();
	     		getProfileFriends();
	     		vm.isLoadingReply = false;
	     	}).catch(function (err) {
	     		vm.isLoadingReply = false;
	     	});
		}
		
		function _replyRequestFromList(action, friend) {
			DomainFriendsService.patchFriends({
				friendId: friend.id
			}, {status: action}).$promise.then(function (data) {
				getProfileFriends(vm.friendsCurrentPage - 1);
			}).catch(function (err) {
			});
		}
		
		function getFriendByUsername() {
			console.log('usrname');
			DomainProfilesService.getOneByUsername({
        		username : $stateParams.username
        	}).$promise.then(function (data) {
        		vm.user = data;
        	}).catch(function (err) {
        		return 'NOT-FOUND';
        	});
		}
		
		function getProfileFriends(currentPage) {
			DomainFriendsService.getFriendsByUsername({
				username : $stateParams.user.username,
				page: currentPage ? currentPage : 0,
				size: 10
			}).$promise.then(function (data) {
		        vm.friends = data.content;
				vm.friendsTotalItens = data.totalElements;
				vm.friendsTotalPages = data.totalPages;
				vm.friendsItensPerPage = data.size;
				vm.friendsCurrentPage = data.number + 1;
			}).catch(function (err) {
				return 'ERROR';
			});
		}
		
		function _pageFriendsChanged() {
			DomainFriendsService.getFriendsByUsername({
				username : $stateParams.user.username,
				page: vm.friendsCurrentPage - 1,
				size: 10
			}).$promise.then(function (data) {
				return data;
			}).catch(function (err) {
		        vm.friends = data.content;
				vm.friendsTotalItens = data.totalElements;
				vm.friendsTotalPages = data.totalPages;
				vm.friendsItensPerPage = data.size;
				vm.friendsCurrentPage = data.number + 1;
			});
		}

    }
    
})();
