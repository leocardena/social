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
				params : {
					size : '@size',
					language : '@language',
	        		page: '@page'
				},
				ignoreLoadingBar: true
			}
		} );
		
		return service;
	}
	
})();