(function() {

	'use strict';

	angular.module('social').config(config);

	config.$inject = [ '$stateProvider', '$locationProvider' ];

	/* @ngInject* */
	function config($stateProvider, $locationProvider) {

		$stateProvider

		.state('social', {
			abstract : true,
			views : {
				'navbar@' : {
					templateUrl : 'app/layouts/navbar/navbar.html'
				}
			}
		});

		$locationProvider.html5Mode(true);

	}

})();