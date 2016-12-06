(function () {
	'use strict';
	
	angular
			.module('social.services.tmdb')
			.factory('TmdbShowService', TmdbShowService);
	
	TmdbShowService.$inject = ['TmdbBase', '$resource'];
	
	/*@ngInject*/
	function TmdbShowService(TmdbBase, $resource) {
		var service =  $resource( TmdbBase.show, {}, {
			'getRandomPopularShow' : {
				method: 'GET',
				url: TmdbBase.show + '/popular/random',
				cache : true,
				params : {
					size : '@size',
					language : '@language',
	        		page : '@page'
				}
			},
			'getShowImage' : {
				method: 'GET',
				url: TmdbBase.show + '/:showId/images',
				params: {
					language : '@language',
					posterSize : '@posterSize',
					backdropSize : '@backdropSize',
					showId : '@showId'
				}
			},
			'getSeasonImage' : {
				method: 'GET',
				url: TmdbBase.show + '/:showId/season/:seasonNumber/images',
				params: {
					language : '@language',
					posterSize : '@posterSize',
					showId : '@showId',
					seasonNumber : '@seasonNumber'
				}
			},
			'getEpisodeImage' : {
				method: 'GET',
				url: TmdbBase.show + '/:showId/season/:seasonNumber/episode/:episodeNumber/images',
				params: {
					stillSize : '@stillSize',
					showId : '@showId',
					seasonNumber : '@seasonNumber',
					episodeNumber : '@episodeNumber'
				}
			}
			
		} );
		
		return service;
	}
	
})();