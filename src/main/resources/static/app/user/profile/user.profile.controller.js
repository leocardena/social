(function() {
    'use strict';

    angular
        .module('social.user.profile')
        .controller('UserProfileController', UserProfileController);

    UserProfileController.$inject = ['UploadService', 'PrincipalService', '$rootScope'];

    function UserProfileController (UploadService, PrincipalService, $rootScope) {
        var vm = this;
        vm.defaultAvatar = 'content/images/avatar/avatar-300x300.png';
        vm.openUploadModal = _openUploadModal;
        vm.user = PrincipalService.getUserInformation();
        
        function _openUploadModal(avatar) {
        	UploadService.openModal(avatar);
        }
        
        $rootScope.$on('avatarChanged', function(event, url) {
        	vm.user.avatar = url;
        });
        
        
    }
    
})();
