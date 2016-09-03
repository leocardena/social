(function () {
	angular
			.module('social.blocks')
	  		.config(config);
	
	config.$inject = ['cfpLoadingBarProvider'];
	
	/*@ngInject*/
	function config(cfpLoadingBarProvider) {
		cfpLoadingBarProvider.includeSpinner = false;
	}
	
})();