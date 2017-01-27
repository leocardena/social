(function () {
	'use strict';
	
	angular
			.module('social.services.trakt')
			.factory('TraktMovieService', TraktMovieService);
	
	TraktMovieService.$inject = ['TraktBase', '$resource'];
	
	/*@ngInject*/
	function TraktMovieService(TraktBase, $resource) {
		var service =  $resource( TraktBase.movie, {}, {
			'getPopularMovies' : {
				method: 'GET',
				url: TraktBase.movie + '/popular',
				params : {
					limit : '@limit',
					extended : '@extended',
	        		page: '@page'
				},
				isArray : true,
				ignoreLoadingBar: true
			},
			'getTranslationMovie' : {
				method: 'GET',
				url: TraktBase.movie + '/:movieId/translations/:language',
				params : {
					movieId : '@movieId',
					language : '@language'
				},
				isArray : true,
				ignoreLoadingBar: true
			},
			'getRelatedMovies' : {
				method: 'GET',
				url: TraktBase.movie + '/:movieId/related',
				params : {
					movieId : '@movieId',
					page : '@page',
					limit : '@limit',
					extended : '@extended'
				},
				isArray : true,
				ignoreLoadingBar: true
			},
			'getSummaryMovie' : {
				method: 'GET',
				url: TraktBase.movie + '/:movieId',
				params : {
					movieId : '@movieId',
					extended : '@extended'
				}
			}, 
			'getAllPeopleForAMovie' : {
				method: 'GET',
				url: TraktBase.movie + '/:movieId/peoples',
				params : {
					movieId : '@movieId',
					extended : '@extended'
				},
				ignoreLoadingBar: true
			}
		} );
		
		return service;
	}
	
})();