(function () {
	'use strict';
	
	angular
			.module('social.services')
			.factory('AuthService', AuthService);
	
	AuthService.$inject = ['RegisterService', 'ActivateService']
	
	function AuthService(RegisterService, ActivateService) {
        
		var services = {
				createAccount : _createAccount,
				activateAccount : _activateAccount
		}
		
		return services;
		
		function _createAccount (account, callback) {
            var cb = callback || angular.noop;

            return RegisterService.save(account,
                function () {
                    return cb(account);
                },
                function (err) {
                    //this.logout();
                    return cb(err);
                }.bind(this)).$promise;
        }
		
        function _activateAccount (key, callback) {
            var cb = callback || angular.noop;

            return ActivateService.get(key,
                function (response) {
                    return cb(response);
                },
                function (err) {
                    return cb(err);
                }.bind(this)).$promise;
        }

	}
	
})();