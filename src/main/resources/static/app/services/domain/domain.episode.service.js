(function () {
	'use strict';
	
	angular
			.module('social.services.domain')
			.factory('DomainEpisodeService', DomainEpisodeService);
	
	DomainEpisodeService.$inject = ['DomainBase', '$resource'];
	
	/*@ngInject*/
	function DomainEpisodeService(DomainBase, $resource) {
		var service =  $resource( DomainBase.show, {}, {
			'getEpisode' : {
				method: 'GET',
				url: DomainBase.show + '/:showId/seasons/:seasonNumber/episodes/:episodeNumber',
				params: {
					showId : '@showId',
					seasonNumber : '@seasonNumber',
					episodeNumber : '@episodeNumber'
				},
				isArray : false
			},
			'postUserRating' : {
				method: 'POST',
				url: DomainBase.show + '/:showId/seasons/:seasonNumber/episodes/:episodeNumber/user-ratings',
				params: {
					showId : '@showId',
					seasonNumber : '@seasonNumber',
					episodeNumber : '@episodeNumber'
				}
			},
			'putUserRating' : {
				method: 'PUT',
				url: DomainBase.show + '/:showId/seasons/:seasonNumber/episodes/:episodeNumber/user-ratings/:userRatingId',
				params: {
					showId : '@showId',
					userRatingId: '@userRatingId',
					seasonNumber : '@seasonNumber',
					episodeNumber : '@episodeNumber'
				}
			},
			'getUserRating': {
				method: 'GET',
				url: DomainBase.show + '/:showId/seasons/:seasonNumber/episodes/:episodeNumber/user-ratings',
				params: {
					showId : '@showId',
					idRatingParent: '@idRatingParent',
					seasonNumber : '@seasonNumber',
					episodeNumber : '@episodeNumber'
				},
				isArray : false
			},
			'deleteUserRating': {
				method: 'DELETE',
				url: DomainBase.show + '/:showId/seasons/:seasonNumber/episodes/:episodeNumber/user-ratings/:userRatingId',
				params: {
					showId : '@showId',
					userRatingId: '@userRatingId',
					seasonNumber : '@seasonNumber',
					episodeNumber : '@episodeNumber'
				},
				isArray : false
			}
		} );
		
		return service;
	}
	
})();