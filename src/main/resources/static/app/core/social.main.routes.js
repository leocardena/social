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
			},
            resolve: {
                authorize: ['AuthService',
                    function (AuthService) {
                        return AuthService.authorize();
                    }
                ]
            }
		});

		$locationProvider.html5Mode(true);

	}

})();