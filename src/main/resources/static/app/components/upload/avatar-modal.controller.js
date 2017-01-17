(function () {
	
	'use strict';
	
	angular
			.module('social.components')
			.controller('ModalUploadAvatarController', ModalUploadAvatarController);
	
	ModalUploadAvatarController.$inject = ['Upload', 'DomainBase'];
	
	/*@ngInject*/
	function ModalUploadAvatarController(Upload, DomainBase) {
		var vm = this;
		vm.uploadAvatar = _uploadAvatar;
		
		function _uploadAvatar(file) {
			Upload.upload({
	            url: DomainBase.avatar,
	            data: {file: file}
	        }).then(function (resp) {
	           return resp.data;
	        }, function (resp) {
	           return resp.status;
	        });
		}
		
	}
	
})();