(function () {
	
	'use strict';
	
	angular
			.module('social.title')
			.controller('TitleController', TitleController);
	
	TitleController.$inject = ['$stateParams', '$state'];
	
	/*@ngInject*/
	function TitleController ($stateParams, $state) {
		_init();
		
		function _init() {
			switch ($stateParams.type.toLowerCase()) {
				case 'movie':
					$state.go('movie', {
						'title' : $stateParams.title, 
						'traktSlug' : $stateParams.traktSlug,
						'type' : $stateParams.type
					});
					break;
				case 'show':
					break;
				case 'season':
					break;
				case 'episode':
					break;
				case 'people':
					break;
			}
		}
		
	}
	
})();