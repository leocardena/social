(function () {
	'use strict';
	
	angular
			.module('social.services')
			.factory('RegionService', RegionService);
	
	RegionService.$inject = ['CountryService']
	
	function RegionService(CountryService) {
        
		var services = {
				getCountries : _getCountries
		}
		
		return services;
		
		function _getCountries (callback) {
			  var cb = callback || angular.noop;
			  
			  return CountryService.query(
		                function (response) {
		                    return cb(response);
		                },
		                function (err) {
		                    return cb(err);
		                }.bind(this)).$promise;
			  
		}
	}
	
})();