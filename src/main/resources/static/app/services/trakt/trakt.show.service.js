(function () {
	'use strict';
	
	angular
			.module('social.services.trakt')
			.factory('TraktShowService', TraktShowService);
	
	TraktShowService.$inject = ['TraktBase', '$resource'];
	
	/*@ngInject*/
	function TraktShowService(TraktBase, $resource) {
		var service =  $resource( TraktBase.show, {}, {
			'getPopularShows' : {
				method: 'GET',
				url: TraktBase.show + '/popular',
				params : {
					limit : '@limit',
					extended : '@extended',
	        		page: '@page'
				},
				isArray : true,
				ignoreLoadingBar: true
			}
		} );
		
		return service;
	}
	
})();