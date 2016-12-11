(function () {
	
	'use strict';
	
	 angular
       .module('social.blocks')
       .config(translateConfig);
	 
	 translateConfig.$inject = ['$translateProvider'];
	 
	 /*@ngInject*/
	 
	 function translateConfig($translateProvider) {
		 
		  $translateProvider.translations('pt', {
			    'movie': 'Filme',
			    'show': 'Série',
			    'person' : 'Pessoa'
		  });
		  
		  $translateProvider.preferredLanguage('pt');
		  $translateProvider.useSanitizeValueStrategy('escape');
		 
	 }

})();