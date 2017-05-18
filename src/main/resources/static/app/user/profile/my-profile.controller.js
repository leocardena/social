(function() {
    'use strict';

    angular
        .module('social.user.profile')
        .controller('MyProfileController', MyProfileController);

    MyProfileController.$inject = ['UploadService', 'PrincipalService', '$rootScope', '$stateParams', '$state'];

    function MyProfileController(UploadService, PrincipalService, $rootScope, $stateParams, $state) {
        var vm = this;
        vm.defaultAvatar = 'content/images/avatar/avatar-300x300.png';
        vm.openUploadModal = _openUploadModal;
        vm.updateStateName = _updateStateName;
        vm.stateName = $rootScope.toState.name;
        if ($stateParams.user) {
        	vm.user = $stateParams.user;
        } else {
        	vm.user = JSON.parse(JSON.stringify(PrincipalService.getUserInformation()));
        }
    
        function _openUploadModal(avatar) {
        	UploadService.openModal(avatar);
        }
        
        function _updateStateName() {
            vm.stateName = '';
        }
        
        $rootScope.$on('avatarChanged', function(event, url) {
        	vm.user.avatar = url;
        });
        
        $rootScope.$on('profileUpdated', function(event, user) {
        	vm.user = user;
        });
        
    }
    
})();
