(function () {
	'use strict';
	
	angular
			.module('social.services.domain')
			.factory('DomainAvatarService', DomainAvatarService);
	
	DomainAvatarService.$inject = ['DomainBase', '$resource'];
	
	/*@ngInject*/
	function DomainAvatarService(DomainBase, $resource) {
		var service =  $resource( DomainBase.avatar, {}, {
			'deleteAvatar' : {
				method: 'DELETE',
				url: DomainBase.avatar
			}
		} );
		
		return service;
	}
	
})();