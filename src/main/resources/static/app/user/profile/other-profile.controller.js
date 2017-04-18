(function() {
    'use strict';

    angular
        .module('social.user.profile')
        .controller('OtherProfileController', OtherProfileController);

    OtherProfileController.$inject = ['$stateParams'];

    function OtherProfileController ($stateParams) {
        var vm = this;
        vm.defaultAvatar = 'content/images/avatar/avatar-300x300.png';
        vm.user = $stateParams.user;

    }
    
})();
