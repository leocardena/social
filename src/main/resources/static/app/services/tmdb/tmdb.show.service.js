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
	        		page: '@page'
				}
			}
		} );
		
		return service;
	}
	
})();