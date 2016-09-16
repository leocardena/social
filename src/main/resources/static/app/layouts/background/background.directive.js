(function () {
	
	'use strict';
	
	 angular
		    .module('social.layouts.background')
		    .directive('backImg', backImg);
	 
	 function backImg(){
		 
		 var directive = {
			        link: link,
			        restrict: 'A'
			    };
		 
	     return directive;
	     
	     function link (scope, element, attrs, ngModel) {
	         return attrs.$observe('backImg', function(value) {
	             element.css({
	                 'background-image': 'url(' + value +')',
	                 'background-size' : 'cover',
	                 'background-repeat': 'no-repeat'
	             });
	         });
	     }
	     
	     
	 }
	
	
})();