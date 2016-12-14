(function () {
	
	'use strict';
	
	angular
			.module('social.title')
			.controller('TitleController', TitleController);
	
	TitleController.$inject = ['titlePrepService', '$stateParams', '$state', '$window'];
	
	/*@ngInject*/
	function TitleController (titlePrepService, $stateParams, $state, $window) {
		var vm = this;
		vm.type = {type : $stateParams.type};
		
		/*provisorio*/
		$window.document.title = $stateParams.traktSlug;
		
	}
	
})();