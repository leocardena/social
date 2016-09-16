(function () {
	'use strict';
	
	angular
			.module('social.services.trakt')
			.factory('TraktShowService', TraktShowService);
	
	TraktShowService.$inject = ['TraktShowBase', '$resource'];
	
	/*@ngInject*/
	function TraktShowService(TraktShowBase, $resource) {
		var service =  $resource( TraktShowBase.url, {}, {
			'getPopularShows' : {
				method: 'GET',
				url: TraktShowBase.url + '/popular',
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