(function() {
    'use strict';

    angular
        .module('social.user.profile')
        .controller('MyProfileController', MyProfileController);

    MyProfileController.$inject = ['UploadService', 'PrincipalService', '$rootScope', '$stateParams'];

    function MyProfileController(UploadService, PrincipalService, $rootScope, $stateParams) {
        var vm = this;
        vm.defaultAvatar = 'content/images/avatar/avatar-300x300.png';
        vm.openUploadModal = _openUploadModal;
        vm.user = $stateParams.user;
        
        function _openUploadModal(avatar) {
        	UploadService.openModal(avatar);
        }
        
        $rootScope.$on('avatarChanged', function(event, url) {
        	vm.user.avatar = url;
        });
        
        
    }
    
})();
