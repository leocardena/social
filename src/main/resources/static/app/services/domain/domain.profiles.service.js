(function() {
	'use strict';

	angular.module('social.services.domain').factory('DomainProfilesService',
			DomainProfilesService);

	DomainProfilesService.$inject = [ 'DomainBase', '$resource' ];

	/* @ngInject */
	function DomainProfilesService(DomainBase, $resource) {
		var service = $resource(DomainBase.profiles, {}, {
			'getByUsername' : {
				method : 'GET',
				url : DomainBase.profiles,
				params : {
					username : '@username',
					page : '@page',
					size : '@size'
				},
				isArray : false
			},
			'getOneByUsername' : {
				method : 'GET',
				url : DomainBase.profiles + '/:username',
				params : {
					username : '@username'
				},
				isArray : false
			}
		});

		return service;
	}

})();