(function() {
    'use strict';

    angular
        .module('social.layouts.navbar')
        .controller('NavbarController', NavbarController);

    NavbarController.$inject = ['$state', 'PrincipalService', 'AuthService'];

    function NavbarController ($state, PrincipalService, AuthService) {
        var vm = this;
        vm.collapseNavbar = _collapseNavbar;
        vm.isAuthenticated = PrincipalService.isAuthenticated;
        vm.isNavbarCollapsed = true;
        vm.logout = _logout;
        vm.state = $state;
        vm.toggleNavbar = _toggleNavbar;
        
        function _collapseNavbar() {
            vm.isNavbarCollapsed = true;
        }
        
        function _toggleNavbar() {
            vm.isNavbarCollapsed = !vm.isNavbarCollapsed;
        }
        
        function _logout() {
            AuthService.logout();
            $state.go('login');
        }

    }
})();
