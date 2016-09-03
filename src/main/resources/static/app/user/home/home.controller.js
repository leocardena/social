(function() {
    'use strict';

    angular
        .module('social.user.home')
        .controller('HomeController', HomeController);

    HomeController.$inject = ['AuthService', '$state'];

    function HomeController (AuthService, $state) {
        var vm = this;
        vm.logout = _logout;
        
        function _logout() {
            AuthService.logout();
            $state.go('login');
        }

    }
    
})();
