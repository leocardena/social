(function () {
	'use strict';
	
	angular
			.module('social.services.trakt')
			.factory('TraktMovieService', TraktMovieService);
	
	TraktMovieService.$inject = ['TraktMovieBase', '$resource'];
	
	/*@ngInject*/
	function TraktMovieService(TraktMovieBase, $resource) {
		var service =  $resource( TraktMovieBase.url, {}, {
			'getPopularMovies' : {
				method: 'GET',
				url: TraktMovieBase.url + '/popular',
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