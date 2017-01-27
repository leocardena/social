(function () {
	'use strict';
	
	angular
			.module('social.services.trakt')
			.factory('TraktPersonService', TraktPersonService);
	
	TraktPersonService.$inject = ['TraktBase', '$resource'];
	
	/*@ngInject*/
	function TraktPersonService(TraktBase, $resource) {
		var service =  $resource( TraktBase.person, {}, {
			'getSummaryPerson' : {
				method: 'GET',
				url: TraktBase.person + '/:personId',
				params : {
					personId : '@personId',
					extended : '@extended'
				},
				ignoreLoadingBar: true
			},
			'getPersonMovies' : {
				method: 'GET',
				url: TraktBase.person + '/:personId/movies',
				params : {
					personId : '@personId',
					extended : '@extended'
				},
				ignoreLoadingBar: true
			},
			'getPersonShows' : {
				method: 'GET',
				url: TraktBase.person + '/:personId/shows',
				params : {
					personId : '@personId',
					extended : '@extended'
				},
				ignoreLoadingBar: true
			}
		});
		
		return service;
	}
	
})();