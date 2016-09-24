(function () {
	'use strict';
	
	angular
			.module('social.services')
			.factory('RegisterService', RegisterService);
	
	RegisterService.$inject = ['AccountBase', '$resource'];
	
	/*@ngInject*/
	function RegisterService(AccountBase, $resource) {
		return $resource( AccountBase.register, {}, {} );
	}
	
})();