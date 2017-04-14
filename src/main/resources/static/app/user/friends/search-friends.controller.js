(function() {
	'use strict';

	angular.module('social.user.friends').controller('SearchFriendsController',
			SearchFriendsController);

	SearchFriendsController.$inject = ['DomainProfilesService', 'searchPrepService', '$state', '$stateParams'];

	function SearchFriendsController(DomainProfilesService, searchPrepService, $state, $stateParams) {
		var vm = this;
		var isParameter = searchPrepService !== 'NO_SEARCH';
		vm.friends = [];
		vm.check = _check;
		vm.lastSearchTerm = '';
		vm.search = '';
		vm.noResults = false;
		
		if (isParameter) {
			vm.lastSearchTerm = $stateParams.username;
			vm.search = $stateParams.username;
			vm.friends = searchPrepService.content;
			vm.friendsTotalItens = searchPrepService.totalElements;
			vm.noResults = vm.friendsTotalItens == 0;
			vm.friendsTotalPages = searchPrepService.totalPages;
			vm.friendsItensPerPage = searchPrepService.size;
			vm.friendsCurrentPage = searchPrepService.number + 1;
		}
		
		// methods
		vm.searchFriend = _searchFriend;
		vm.pageChanged = _pageChanged
		
		// utilities variables
	    vm.defaultAvatar = 'content/images/avatar/avatar-300x300.png';
		
		function _searchFriend(username) {
        	DomainProfilesService.getByUsername({
        		page : 0,
        		size : 10,
        		username : username
        	}).$promise.then(function(data){
        		vm.friends = data.content;
        		vm.friendsTotalItens = data.totalElements;
        		vm.noResults = vm.friendsTotalItens == 0;
        		vm.friendsTotalPages = data.totalPages;
        		vm.friendsItensPerPage = data.size;
        		vm.friendsCurrentPage = data.number + 1;
        		vm.lastSearchTerm = username;
        		$state.go('search-friends', {username : username, page : 0}, {notify : false}); 
        	}).catch(function () {
        	});
		}
		
		function _pageChanged() {
			DomainProfilesService.getByUsername({
				page : vm.friendsCurrentPage - 1,
				size : 10,
		 		username : vm.search
			}).$promise.then(function(data) {
        		vm.friends = data.content;
        		vm.friendsTotalItens = data.totalElements;
        		vm.noResults = vm.friendsTotalItens == 0;
        		vm.friendsTotalPages = data.totalPages;
        		vm.friendsItensPerPage = data.size;
        		vm.friendsCurrentPage = data.number + 1;
        		vm.lastSearchTerm = vm.search;
        		$state.go('search-friends', {username : vm.search, page : 0}, {notify : false}); 
			});
		}
		
		function _check() {
			if (vm.lastSearchTerm) {
				return vm.lastSearchTerm == vm.search;
			}
			return true;
		}
		
	}

})();
