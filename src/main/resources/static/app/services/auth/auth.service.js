(function () {
	'use strict';
	
	angular
			.module('social.services')
			.factory('AuthService', AuthService);
	
	AuthService.$inject = ['RegisterService']
	
	function AuthService(RegisterService) {
        
		var services = {
				createAccount : _createAccount
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

	}
	
})();