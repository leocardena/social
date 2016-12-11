(function () {
	'use strict';
	
	angular
			.module('social.layouts.navbar')
			.factory('SearchTextService', SearchTextService);
	
	SearchTextService.$inject = [];
	
	function SearchTextService() {
        
		var data = {
            text : '',
            type : ''
        }
		
		var services = {
			getText : _getText,
			setText : _setText,
			getType : _getType,
			setType : _setType
		}
		
		return services;
		
		function _getText () {
            return data.text;
        }
		
        function _setText (text) {
            data.text = text;
        }
        
		function _getType () {
            return data.type;
        }
		
        function _setType (type) {
            data.type = type;
        }
	}
	
})();