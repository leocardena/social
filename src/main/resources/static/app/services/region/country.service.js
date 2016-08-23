(function () {
	'use strict';
	
	angular
			.module('social.services')
			.factory('CountryService', CountryService);
	
	CountryService.$inject = ['CountryBase', '$resource'];
	
	/*@ngInject*/
	function CountryService(CountryBase, $resource) {
		return $resource( CountryBase.url, {}, {} );
	}
	
})();