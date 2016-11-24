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
		vm.dismissAlerts = _dismissAlerts;
		vm.isOpen = false;
		vm.next = _next;
		vm.openCalendar = _openCalendar;
		vm.popup = { opened : false };
		vm.register = _register;
		$rootScope.background = backgroundPrepService.backdrop_path;
		
		function _dismissAlerts() {
			vm.alertEnable = false;
		}
		
		function _next(){
			if (!vm.formRegisterPersonal.$invalid) {
				vm.formPersonalInvalid = false;
				WizardHandler.wizard('register').next();
			} else {
				vm.formPersonalInvalid = true;
			}
		}

		function _openCalendar () {
		    vm.popup.opened = true;
		};
		
		function _register(account) {
			vm.errorUserExists = null;
			vm.errorEmailExists = null;
			vm.error = null;
			vm.doNotMatch = null;
			if (account.password !== vm.confirmPassword) {
				vm.alertEnable = true;
                vm.doNotMatch = 'ERROR';
            } else {
            	if (!vm.formRegisterUser.$invalid) {
            		AuthService.createAccount(account).then(function () {
                        vm.success = 'OK';
                    }).catch(function (response) {
                    	vm.alertEnable = true;
                        vm.success = null;
                        if (response.status === 400 && response.data.titulo === 'Login em uso') {
                        	console.log(response.data);
                            vm.errorUserExists = 'ERROR';
                        } else if (response.status === 400 && response.data.titulo === 'Email em uso') {
                            vm.errorEmailExists = 'ERROR';
                            console.log(response.data);
                        } else {
                            vm.error = 'ERROR';
                            console.log(response.data);
                        }
                    });
            	}
            }
		}
		
	}

})();