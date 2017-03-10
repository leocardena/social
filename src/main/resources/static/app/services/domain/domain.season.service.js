(function () {
	'use strict';
	
	angular
			.module('social.services.domain')
			.factory('DomainSeasonService', DomainSeasonService);
	
	DomainSeasonService.$inject = ['DomainBase', '$resource'];
	
	/*@ngInject*/
	function DomainSeasonService(DomainBase, $resource) {
		var service =  $resource( DomainBase.show, {}, {
			'getSeason' : {
				method: 'GET',
				url: DomainBase.show + '/:showId/seasons/:seasonNumber',
				params: {
					showId : '@showId',
					seasonNumber : '@seasonNumber'
				},
				isArray : false
			},
			'postUserRating' : {
				method: 'POST',
				url: DomainBase.show + '/:showId/seasons/:seasonNumber/user-ratings',
				params: {
					showId : '@showId',
					seasonNumber : '@seasonNumber'
				}
			},
			'putUserRating' : {
				method: 'PUT',
				url: DomainBase.show + '/:showId/seasons/:seasonNumber/user-ratings/:userRatingId',
				params: {
					showId : '@showId',
					userRatingId: '@userRatingId',
					seasonNumber : '@seasonNumber'
				}
			},
			'getUserRating': {
				method: 'GET',
				url: DomainBase.show + '/:showId/seasons/:seasonNumber/user-ratings',
				params: {
					showId : '@showId',
					idRatingParent: '@idRatingParent',
					seasonNumber : '@seasonNumber'
				},
				isArray : false
			},
			'deleteUserRating': {
				method: 'DELETE',
				url: DomainBase.show + '/:showId/seasons/:seasonNumber/user-ratings/:userRatingId',
				params: {
					showId : '@showId',
					userRatingId: '@userRatingId',
					seasonNumber : '@seasonNumber'
				},
				isArray : false
			}
		} );
		
		return service;
	}
	
})();