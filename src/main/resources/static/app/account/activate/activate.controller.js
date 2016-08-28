(function() {
    'use strict';

    angular
        .module('social.account.activate')
        .controller('ActivationController', ActivationController);

    ActivationController.$inject = ['$stateParams', 'Auth'];

    function ActivationController ($stateParams, Auth) {
        var vm = this;

        Auth.activateAccount({key: $stateParams.key}).then(function () {
            vm.error = null;
            vm.success = 'OK';
        }).catch(function () {
            vm.success = null;
            vm.error = 'ERROR';
        });

    }
})();
