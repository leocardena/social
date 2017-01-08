(function () {
	
	'use strict';
	
	angular
			.module('social.title')
			.controller('TitleShowSeasonController', TitleShowSeasonController);
	
	TitleShowSeasonController.$inject = ['seasonPrepService', 'showSummaryPrepService', 'showTranslationsPrepService'];
	
	/*@ngInject*/
	function TitleShowSeasonController(seasonPrepService, showSummaryPrepService, showTranslationsPrepService) {
		
		var vm = this;
		vm.show = showSummaryPrepService
		vm.season = seasonPrepService;
		
		/* TODO
		 * carregar imagens quando o objeto vm.show não possuir imagens
		 * carregar imagens dos episodios
		 * carregar traducao da serie caso exista
		 * carregar traducao dos episodios caso exista
		  */
		
	}
	
})();