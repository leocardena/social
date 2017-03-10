(function () {
	'use strict';
	
	angular
			.module('social.services.domain')
			.factory('DomainShowService', DomainShowService);
	
	DomainShowService.$inject = ['DomainBase', '$resource'];
	
	/*@ngInject*/
	function DomainShowService(DomainBase, $resource) {
		var service =  $resource( DomainBase.show, {}, {
			'getShow' : {
				method: 'GET',
				url: DomainBase.show + '/:showId',
				params: {
					showId : '@showId'
				},
				isArray : false
			},
			'postUserRating' : {
				method: 'POST',
				url: DomainBase.show + '/:showId/user-ratings',
				params: {
					showId : '@showId'
				}
			},
			'putUserRating' : {
				method: 'PUT',
				url: DomainBase.show + '/:showId/user-ratings/:userRatingId',
				params: {
					showId : '@showId',
					userRatingId: '@userRatingId'
				}
			},
			'getUserRating': {
				method: 'GET',
				url: DomainBase.show + '/:showId/user-ratings',
				params: {
					showId : '@showId',
					idRatingParent: '@idRatingParent'
				},
				isArray : false
			},
			'deleteUserRating': {
				method: 'DELETE',
				url: DomainBase.show + '/:showId/user-ratings/:userRatingId',
				params: {
					showId : '@showId',
					userRatingId: '@userRatingId'
				},
				isArray : false
			}
		} );
		
		return service;
	}
	
})();