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
	    	 var defaultUrl = 'https://walter.trakt.us/images/shows/000/001/409/fanarts/original/cff0b01ee7.jpg';
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