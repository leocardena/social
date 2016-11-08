(function() {
    'use strict';

    angular
        .module('social.layouts.navbar')
        .controller('NavbarController', NavbarController);

    NavbarController.$inject = ['$state', 'PrincipalService', 'AuthService', '$localStorage', '$scope'];

    function NavbarController ($state, PrincipalService, AuthService, $localStorage, $scope ) {
        var vm = this;
        vm.collapseNavbar = _collapseNavbar;
        vm.isAuthenticated = PrincipalService.isAuthenticated;
        vm.getUserInfo = _getUserInfo;
        vm.isNavbarCollapsed = true;
        vm.logout = _logout;
        vm.state = $state;
        vm.toggleNavbar = _toggleNavbar;
        
        $scope.$on('authenticationSuccess', function() {
    	    vm.account =  $localStorage.account;
        });
        
        function _collapseNavbar() {
            vm.isNavbarCollapsed = true;
        }
        
        function _getUserInfo() {
        	return PrincipalService.getUserInformation();
        }
        
        function _toggleNavbar() {
            vm.isNavbarCollapsed = !vm.isNavbarCollapsed;
        }
        
        function _logout() {
            AuthService.logout();
            delete vm.account;
            $state.go('login');
        }

    }
})();
