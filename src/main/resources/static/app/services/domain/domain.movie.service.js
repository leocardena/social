(function () {
	'use strict';
	
	angular
			.module('social.services.domain')
			.factory('DomainMovieService', DomainMovieService);
	
	DomainMovieService.$inject = ['DomainBase', '$resource'];
	
	/*@ngInject*/
	function DomainMovieService(DomainBase, $resource) {
		var service =  $resource( DomainBase.movie, {}, {
			'getMovie' : {
				method: 'GET',
				url: DomainBase.movie + '/:movieId',
				params: {
					movieId : '@movieId'
				},
				isArray : false
			},
			'postMovie' : {
				method: 'POST',
				url: DomainBase.movie + '/:movieId/user-ratings',
				params: {
					movieId : '@movieId'
				}
			},
			'putUserRating' : {
				method: 'PUT',
				url: DomainBase.movie + '/:movieId/user-ratings/:userRatingId',
				params: {
					movieId : '@movieId',
					userRatingId: '@userRatingId'
				}
			},
			'getUserRating': {
				method: 'GET',
				url: DomainBase.movie + '/:movieId/user-ratings',
				params: {
					movieId : '@movieId',
					idRatingParent: '@idRatingParent'
				},
				isArray : false
			},
			'deleteUserRating': {
				method: 'DELETE',
				url: DomainBase.movie + '/:movieId/user-ratings/:userRatingId',
				params: {
					movieId : '@movieId',
					userRatingId: '@userRatingId'
				},
				isArray : false
			}
		} );
		
		return service;
	}
	
})();