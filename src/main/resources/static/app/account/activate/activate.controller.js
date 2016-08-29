(function() {
    'use strict';

    angular
        .module('social.account.activate')
        .controller('ActivationController', ActivationController);

    ActivationController.$inject = ['$stateParams', 'AuthService'];

    function ActivationController ($stateParams, AuthService) {
        var vm = this;
        console.log('key: ' + $stateParams.key);
        AuthService.activateAccount({key: $stateParams.key}).then(function () {
            vm.error = null;
            vm.success = 'OK';
        }).catch(function () {
            vm.success = null;
            vm.error = 'ERROR';
        });

    }
})();
