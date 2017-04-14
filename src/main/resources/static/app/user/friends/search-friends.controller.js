(function() {
	'use strict';

	angular.module('social.user.friends').controller('SearchFriendsController',
			SearchFriendsController);

	SearchFriendsController.$inject = ['DomainFriendsService', 'searchPrepService'];

	function SearchFriendsController(DomainFriendsService, searchPrepService) {
		var vm = this;

		console.log(searchPrepService);
	}

})();
