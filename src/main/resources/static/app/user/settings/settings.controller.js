(function() {
	'use strict';

	angular.module('social.user.settings').controller('SettingsController',
			SettingsController);

	SettingsController.$inject = ['countriesPrepareService', 'AccountService', 'PrincipalService', '$stateParams',
		'$rootScope'];

	function SettingsController(countriesPrepareService, AccountService, PrincipalService, $stateParams,
			$rootScope) {
		var vm = this;
		var userTemp = JSON.parse(JSON.stringify(PrincipalService.getUserInformation()));
		vm.user = userTemp;
		vm.countries = countriesPrepareService;
		vm.sidebarOption = $stateParams.option ? $stateParams.option : 'geral';
		vm.updated = false;
		vm.notMatch = false;
		vm.passSucess = false;

		// methods
		vm.updateAccount = _updateAccount;
		vm.updatePassword = _updatePassword;

		function _updateAccount(user) {
			AccountService.putAccount({
				userId : user.id
			}, user).$promise.then(function(data) {
				vm.updated = true;
	        	$rootScope.$broadcast('profileUpdated', data);
			});
		}
		
		function _updatePassword(password, confirm) {
			if (password.newPassword !== confirm) {
				vm.notMatch = true;
				return;
			}
			
			AccountService.putPassword({
				userId : vm.user.id
			}, password).$promise.then(function(data) {
				vm.passSucess = true;
				vm.password = null;
				vm.passwordConfirm = null;
			}).catch(function (err) {
				vm.requestError = true;
	     	});
			
		}
		
	}

})();
