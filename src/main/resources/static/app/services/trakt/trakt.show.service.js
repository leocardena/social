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
			},
			'getTranslationShow' : {
				method: 'GET',
				url: TraktBase.show + '/:showId/translations/:language',
				params : {
					showId : '@showId',
					language : '@language'
				},
				isArray : true,
				ignoreLoadingBar: true
			}
		} );
		
		return service;
	}
	
})();