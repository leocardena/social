(function () {
	'use strict';
	
	angular
			.module('social.layouts.navbar')
			.factory('SearchTextService', SearchTextService);
	
	SearchTextService.$inject = [];
	
	function SearchTextService() {
        
		var data = {
            text : ''
        }
		
		var services = {
			getText : _getText,
			setText : _setText
		}
		
		return services;
		
		function _getText () {
            return data.text;
        }
		
        function _setText (text) {
            data.text = text;
        }
	}
	
})();