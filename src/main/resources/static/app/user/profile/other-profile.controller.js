(function() {
    'use strict';

    angular
        .module('social.user.profile')
        .controller('OtherProfileController', OtherProfileController);

    OtherProfileController.$inject = ['$stateParams', 'DomainFriendsService', 'DomainProfilesService',
    	'friendsByUsernamePrepService'];

    function OtherProfileController ($stateParams, DomainFriendsService, DomainProfilesService,
    		friendsByUsernamePrepService) {
        var vm = this;
        vm.defaultAvatar = 'content/images/avatar/avatar-300x300.png';
        vm.user = $stateParams.user;
        vm.addFriend = _addFriend;
        vm.removeFriend = _removeFriend;
        vm.friends = friendsByUsernamePrepService;
		vm.replyRequest = _replyRequest;
        
        function _addFriend(idFriend) {
        	DomainFriendsService.postFriends({}, 
        			{idFriend : idFriend})
        	.$promise.then(function (data) {
        		vm.user.friendStatus = data.status;
        	}).catch(function (err) {
        		console.log('error');
        	});
        }	
        
        function _removeFriend(idFriend) {
        	DomainFriendsService.deleteFriends({
        		friendId : idFriend
        	}).$promise.then(function (data) {
        		vm.user.friendStatus = 'None';
        	}).catch(function (err) {
        		console.log('error');
        	});
        }
        
		function _replyRequest(action, friend) {
			console.log(friend);
        	vm.isLoadingReply = true;
        	DomainFriendsService.patchFriends({
        		friendId: friend.id
	     	}, {status: action}).$promise.then(function (data) {
				console.log('oka');

	     		getFriendByUsername();
	     		getProfileFriends();
	     		vm.isLoadingReply = false;
	     	}).catch(function (err) {
	     		vm.isLoadingReply = false;
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
		
		function getProfileFriends() {
			console.log('fr');
			DomainFriendsService.getFriendsByUsername({
				username : $stateParams.user.username,
				page: 0,
				size: 10
			}).$promise.then(function (data) {
				 vm.friends = data;
			}).catch(function (err) {
				return 'ERROR';
			});
		}

    }
    
})();
