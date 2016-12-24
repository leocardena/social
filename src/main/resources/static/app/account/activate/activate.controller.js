(function() {
    'use strict';

    angular
        .module('social.account.activate')
        .controller('ActivationController', ActivationController);

    ActivationController.$inject = ['$stateParams', 'AuthService', '$rootScope', 'backgroundPrepService'];

    function ActivationController ($stateParams, AuthService, $rootScope, backgroundPrepService) {
        var vm = this;
        
        $rootScope.background = backgroundPrepService.backdrop_path;

        AuthService.activateAccount({key: $stateParams.key}).then(function () {
            vm.error = null;
            vm.success = 'OK';
        }).catch(function () {
            vm.success = null;
            vm.error = 'ERROR';
        });

    }
})();
