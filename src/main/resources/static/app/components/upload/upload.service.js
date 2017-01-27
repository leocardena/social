(function() {

	'use strict';

	angular
		   .module('social.components')
		   .service('UploadService', UploadService);

	UploadService.$inject = ['$uibModal'];

	/* @ngInject */
	function UploadService($uibModal) {

		var service = {
			openModal : _openModal
		};

		var modalInstance = null;
		var resetModal = function() {
			modalInstance = null;
		};

		return service;

		function _openModal(avatar) {
			var modalInstance = $uibModal.open({
				animation : true,
				ariaLabelledBy : 'modal-title',
				ariaDescribedBy : 'modal-body',
				templateUrl : 'app/components/upload/upload-avatar-modal.html',
				controller : 'ModalUploadAvatarController',
				controllerAs : 'vm',
				resolve: {
			        actualAvatar: function () {
			            return avatar;
			        }
			    }
			});

			modalInstance.result.then(resetModal, resetModal);
		}

	}

})();