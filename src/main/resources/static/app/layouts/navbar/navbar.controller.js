(function() {
    'use strict';

    angular
        .module('social.layouts.navbar')
        .controller('NavbarController', NavbarController);

    NavbarController.$inject = ['$state'];

    function NavbarController ($state) {
        var vm = this;
        vm.state = $state;

    }
})();
