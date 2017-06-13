(function() {
    'use strict';

    angular
        .module('social.user.profile')
        .controller('MyProfileInfoController', MyProfileInfoController);

    MyProfileInfoController.$inject = ['accPrepService'];

    function MyProfileInfoController(accPrepService) {
    	var vm = this;
		vm.user = accPrepService;
    }
    
})();
