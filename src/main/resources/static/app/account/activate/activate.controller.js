(function() {
    'use strict';

    angular
        .module('social.account.activate')
        .controller('ActivationController', ActivationController);

    ActivationController.$inject = ['$stateParams', 'AuthService', '$state', 'backgroundPrepService'];

    function ActivationController ($stateParams, AuthService, $state, backgroundPrepService) {
        var vm = this;
        
    	$state.current.data.background = backgroundPrepService;

        AuthService.activateAccount({key: $stateParams.key}).then(function () {
            vm.error = null;
            vm.success = 'OK';
        }).catch(function () {
            vm.success = null;
            vm.error = 'ERROR';
        });

    }
})();
