(function () {
	
	'use strict';
	
	angular
			.module('social.components')
			.controller('ModalTrailerController', ModalTrailerController);
	
	ModalTrailerController.$inject = ['trailer'];
	
	/*@ngInject*/
	function ModalTrailerController(trailer) {
		var vm = this;
		vm.trailer = trailer;
	}
	
})();