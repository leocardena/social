(function () {
	
	'use strict';
	
	angular
			.module('social.title')
			.controller('TitleShowController', TitleShowController);
	
	TitleShowController.$inject = ['$stateParams', '$window', '$state', 'showTranslationsPrepService',
	                               'showSummaryPrepService', 'showPeoplePrepService', 'relatedShowsPrepService',
	                               'seasonsShowPrepService'];
	
	/*@ngInject*/
	function TitleShowController($stateParams, $window, $state, showTranslationsPrepService,
			showSummaryPrepService, showPeoplePrepService, relatedShowsPrepService, seasonsShowPrepService) {
		var vm = this;
		/*tests*/
		vm.translation = showTranslationsPrepService;
		vm.summ = showSummaryPrepService;
		vm.people = showPeoplePrepService;
		vm.rela = relatedShowsPrepService;
		vm.season  = seasonsShowPrepService;
		
	}
	
})();