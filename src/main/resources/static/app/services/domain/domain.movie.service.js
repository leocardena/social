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
				},
				data: {
					
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
			}
		} );
		
		return service;
	}
	
})();