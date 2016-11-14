(function () {
	'use strict';
	
	angular
			.module('social.services.trakt')
			.factory('TraktSearchService', TraktSearchService);
	
	TraktSearchService.$inject = ['TraktBase', '$resource'];
	
	/*@ngInject*/
	function TraktSearchService(TraktBase, $resource) {
		var service =  $resource( TraktBase.search, {}, {
			'getSearch' : {
				method: 'GET',
				url: TraktBase.search + '/:type',
				params : {
					limit : '@limit',
					extended : '@extended',
	        		page: '@page',
	        		query :  '@query',
	        		languages : '@languages',
	        		type : '@type',
	        		fields : '@fields'
				},
				isArray : true
			}
		} );
		
		return service;
	}
	
})();