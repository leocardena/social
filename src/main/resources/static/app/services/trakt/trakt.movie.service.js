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
			}
		} );
		
		return service;
	}
	
})();