(function () {
	'use strict';
	
	angular
			.module('social.services.tmdb')
			.factory('TmdbPersonService', TmdbPersonService);
	
	TmdbPersonService.$inject = ['TmdbBase', '$resource'];
	
	/*@ngInject*/
	function TmdbPersonService(TmdbBase, $resource) {
		var service =  $resource( TmdbBase.person, {}, {
			'getPersonImage' : {
				method: 'GET',
				url: TmdbBase.person + '/:personId/images',
				params: {
					profileSize : '@profileSize',
					personId: '@personId'
				}
			}
		} );
		
		return service;
	}
	
})();