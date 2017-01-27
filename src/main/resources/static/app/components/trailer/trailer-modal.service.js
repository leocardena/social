(function() {
    'use strict';

    angular
        .module('social.components')
        .factory('TrailerModalService', TrailerModalService);

    TrailerModalService.$inject = ['$uibModal'];

    function TrailerModalService ($uibModal) {
        var service = {
            open: _open
        };

        var modalInstance = null;
        var resetModal = function () {
            modalInstance = null;
        };

        return service;

		function _open(trailer) {
		    var modalInstance = $uibModal.open({
		        animation: true,
		        ariaLabelledBy: 'modal-title',
		        ariaDescribedBy: 'modal-body',
		        templateUrl: 'app/components/trailer/trailler-modal.html',
		        controller: 'ModalTrailerController',
		        controllerAs: 'vm',
		        resolve: {
		          trailer: function () {
		            return trailer;
		          }
		        }
		      });
		    
	          modalInstance.result.then(
	                    resetModal,
	                    resetModal
	          );
		}
		
    }
})();
