(function() {
    'use strict';

    angular
        .module('social.user.profile')
        .controller('OtherProfileController', OtherProfileController);

    OtherProfileController.$inject = ['$stateParams', 'DomainFriendsService'];

    function OtherProfileController ($stateParams, DomainFriendsService) {
        var vm = this;
        vm.defaultAvatar = 'content/images/avatar/avatar-300x300.png';
        vm.user = $stateParams.user;
        vm.addFriend = _addFriend;
        vm.removeFriend = _removeFriend;
        
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

    }
    
})();
