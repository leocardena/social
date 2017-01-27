(function () {
	
	'use strict';
	
	angular
			.module('social.components')
			.controller('ModalUploadAvatarController', ModalUploadAvatarController);
	
	ModalUploadAvatarController.$inject = ['Upload', 'DomainBase', '$rootScope', 'DomainAvatarService',
	                                       '$uibModalInstance', 'actualAvatar'];
	
	/*@ngInject*/
	function ModalUploadAvatarController(Upload, DomainBase, $rootScope, DomainAvatarService, $uibModalInstance,
			actualAvatar) {
		var vm = this;
		vm.actualAvatar = actualAvatar;
		vm.defaultAvatar = "content/images/avatar/avatar-300x300.png";
		vm.uploadAvatar = _uploadAvatar;
		vm.cancel = _cancel;
		
		function _cancel() {
			$uibModalInstance.dismiss('cancel');
		}
		
		function _uploadAvatar(file) {
			if (!file) return;
			
			if (vm.deleteAvatar) {
				_delete();
			} else {
				_upload(file);
			}
			$uibModalInstance.dismiss();
		}
		
		function _upload(file) {
			Upload.upload({
	            url: DomainBase.avatar,
	            data: {file: file}
	        }).then(function (resp) {
	        	$rootScope.$broadcast('avatarChanged', resp.data.url);
	            return resp.data;
	        }, function (resp) {
	            return resp.status;
	        });
		}
		
		function _delete() {
			DomainAvatarService.deleteAvatar();
			$rootScope.$broadcast('avatarChanged', null);
		}
		
	}
	
})();