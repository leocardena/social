(function () {
	'use strict';
	
	angular
			.module('social.services')
			.factory('RegisterService', RegisterService);
	
	RegisterService.$inject = ['RegisterBase', '$resource'];
	
	/*@ngInject*/
	function RegisterService(RegisterBase, $resource) {
		return $resource( RegisterBase.url, {}, {} );
	}
	
})();