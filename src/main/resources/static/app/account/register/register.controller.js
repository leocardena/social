(function() {

	'use strict';

	angular
			.module('social.account.register')
			.controller('RegisterController', RegisterController);
	
    RegisterController.$inject = ['AuthService', 'countriesPrepareService', 'backgroundPrepService', 
                                  '$rootScope', 'WizardHandler'];

	/* @ngInject */
	function RegisterController(AuthService, countriesPrepareService, backgroundPrepService, 
			$rootScope, WizardHandler) {
		var vm = this;
		vm.altInputFormats = ['d!/M!/yyyy'];
		vm.countries = countriesPrepareService;
		vm.dateOptions = {
			maxDate : new Date(),
			minDate : new Date(1940, 1, 1),
			startingDay : 1
		};
		vm.next = _next;
		vm.openCalendar = _openCalendar;
		vm.popup = { opened : false };
		vm.register = _register;
		if (backgroundPrepService instanceof Array) {
			$rootScope.background = backgroundPrepService[0].images.fanart.full;
		} else {
			$rootScope.background = backgroundPrepService;
		}
		
		function _next(){
//			if (!vm.formRegister.$invalid) {
//				vm.formInvalid = false;
//				WizardHandler.wizard().next();
//			} else {
//				vm.formInvalid = true;
//			}
			WizardHandler.wizard('register').next();
		}

		function _openCalendar () {
		    vm.popup.opened = true;
		};
		
		function _register(account) {
			if (account.password !== vm.confirmPassword) {
                vm.doNotMatch = 'ERROR';
            } else {
            	AuthService.createAccount(account).then(function () {
                    vm.success = 'OK';
                }).catch(function (response) {
                    vm.success = null;
                    if (response.status === 400 && response.data === 'login already in use') {
                        vm.errorUserExists = 'ERROR';
                    } else if (response.status === 400 && response.data === 'e-mail address already in use') {
                        vm.errorEmailExists = 'ERROR';
                    } else {
                        vm.error = 'ERROR';
                    }
                });
            }
		}
		
	}

})();