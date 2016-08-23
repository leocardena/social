(function () {
	angular
			.module('social.core')
	  		.config(config);
	
	config.$inject = ['cfpLoadingBarProvider'];
	
	/*@ngInject*/
	function config(cfpLoadingBarProvider) {
		cfpLoadingBarProvider.includeSpinner = false;
	}
	
})();