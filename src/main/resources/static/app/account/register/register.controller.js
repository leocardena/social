(function() {

	'use strict';

	angular.module('social.account.register').controller('RegisterController',
			RegisterController);

	/* @ngInject */
	function RegisterController() {
		var vm = this;
		vm.dateOptions = {
			maxDate : new Date(),
			minDate : new Date(1950, 1, 1),
			startingDay : 1
		};
		vm.openCalendar = _openCalendar;
		vm.popup = { opened : false };

		function _openCalendar () {
		    vm.popup.opened = true;
		};

	}

})();