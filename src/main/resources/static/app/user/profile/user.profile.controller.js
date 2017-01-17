(function() {
    'use strict';

    angular
        .module('social.user.profile')
        .controller('UserProfileController', UserProfileController);

    UserProfileController.$inject = ['UploadService', 'PrincipalService'];

    function UserProfileController (UploadService, PrincipalService) {
        var vm = this;
        vm.defaultAvatar = 'content/images/avatar/avatar-20x20.png';
        vm.openUploadModal = _openUploadModal;
        vm.user = PrincipalService.getUserInformation();
        
        function _openUploadModal() {
        	UploadService.openModal();
        }
        
        
    }
    
})();
