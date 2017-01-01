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
			},
			'getSummaryShow' : {
				method: 'GET',
				url: TraktBase.show + '/:showId',
				params : {
					showId : '@showId',
					extended : '@extended'
				},
				ignoreLoadingBar: true
			},
			'getRelatedShows' : {
				method: 'GET',
				url: TraktBase.show + '/:showId/related',
				params : {
					showId : '@showId',
					page : '@page',
					limit : '@limit',
					extended : '@extended'
				},
				isArray : true,
				ignoreLoadingBar: true
			}, 
			'getAllPeopleForAShow' : {
				method: 'GET',
				url: TraktBase.show + '/:showId/people',
				params : {
					showId : '@showId',
					extended : '@extended'
				},
				ignoreLoadingBar: true
			},
			'getAllSeasonsShow' : {
				method: 'GET',
				url: TraktBase.show + '/:showId/seasons',
				params : {
					showId : '@showId',
					extended : '@extended'
				},
				ignoreLoadingBar: true,
				isArray : true
			}
		});
		
		return service;
	}
	
})();