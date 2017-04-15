(function() {
    'use strict';

    angular
        .module('social.layouts.navbar')
        .controller('NavbarController', NavbarController);

    NavbarController.$inject = ['$state', 'PrincipalService', 'AuthService', 
                                '$localStorage', '$scope', 'SearchTextService'];

    function NavbarController ($state, PrincipalService, AuthService, 
    		$localStorage, $scope, SearchTextService) {
        var vm = this;
        vm.collapseNavbar = _collapseNavbar;
        vm.isAuthenticated = PrincipalService.isAuthenticated;
        vm.getUserInfo = _getUserInfo;
        vm.isNavbarCollapsed = true;
        vm.isOpen = false;
        vm.login = _login;
        vm.logout = _logout;
        vm.rememberMe = true;
        vm.state = $state;
        vm.toggleNavbar = _toggleNavbar;
        vm.collapseDropDown = _collapseDropDown;
        vm.searchTypes = [
	        {path: 'movie', name: 'Filmes'},
	        {path: 'show', name: 'Séries'},
	        {path: 'person', name: 'Pessoas'},
	        {path: 'all', name: 'Todos'}
        ];
        vm.submitSearchForm = _submitSearchForm;
        
        vm.search = {};
        vm.search.type = $state.current.name === 'search' && $state.params.type ? 
        		$state.params.type : vm.searchTypes[0].path;
        vm.search.text = $state.current.name === 'search' && $state.params.query ? 
        		$state.params.query : null;
        
        function _collapseNavbar() {
            vm.isNavbarCollapsed = false;
        }
        
        function _collapseDropDown() {
        	 vm.isOpen = false;
        }
        
        function _getUserInfo() {
        	return PrincipalService.getUserInformation();
        }
        
        function _toggleNavbar() {
            vm.isNavbarCollapsed = !vm.isNavbarCollapsed;
        }
        
        function _login (event) {
            event.preventDefault();
            
            if (vm.formLogin.$invalid) {
            	_toggleNavbar();
            	_collapseDropDown();
            	_resetForm();
            	$state.go('login', {authenticationError: true});
            } else {
                AuthService.login({
                    username: vm.username,
                    password: vm.password,
                    rememberMe: vm.rememberMe
                }).then(function () {
                	_collapseDropDown();
                    $state.go('home');
                }).catch(function () {
                	_toggleNavbar();
                	_collapseDropDown();
                	_resetForm();
                	$state.go('login', {authenticationError: true});
                });
            }
            
        }
        
        function _logout() {
            AuthService.logout();
            delete vm.account;
            $state.go('login');
        }
        
        function _resetForm() {
        	vm.formLogin.$setPristine();
        	 vm.username = null;
        	 vm.password = null;
        }
        
        function _submitSearchForm(type, query, page) {
        	if (!query) return;
        	$state.go('search', {type : type, page : page, query : query});
        }
        
        $scope.$watch(function () { 
        	return SearchTextService.getText(); 
        	}, function (newValue, oldValue) {
        		if (newValue !== oldValue) {
        			vm.search.text = newValue;
        		};
        });
        
        $scope.$watch(function () { 
        	return SearchTextService.getType(); 
        	}, function (newValue, oldValue) {
        		if (newValue !== oldValue && newValue != null) {
        			vm.search.type = newValue;
        		};
        });
        
    }
})();