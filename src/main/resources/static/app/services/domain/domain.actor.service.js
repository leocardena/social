(function() {
	'use strict';

	angular.module('social.services.domain').factory('DomainActorService',
			DomainActorService);

	DomainActorService.$inject = [ 'DomainBase', '$resource' ];

	/* @ngInject */
	function DomainActorService(DomainBase, $resource) {
		var service = $resource(DomainBase.actor, {}, {
			'getActor' : {
				method : 'GET',
				url : DomainBase.actor + '/:actorId',
				params : {
					actorId : '@actorId'
				},
				isArray : false
			},
			'postUserRating' : {
				method : 'POST',
				url : DomainBase.actor + '/:actorId/user-ratings',
				params : {
					actorId : '@actorId'
				}
			},
			'putUserRating' : {
				method : 'PUT',
				url : DomainBase.actor + '/:actorId/user-ratings/:userRatingId',
				params : {
					actorId : '@actorId',
					userRatingId : '@userRatingId'
				}
			},
			'getUserRating' : {
				method : 'GET',
				url : DomainBase.actor + '/:actorId/user-ratings',
				params : {
					actorId : '@actorId',
					idRatingParent : '@idRatingParent'
				},
				isArray : false
			},
			'deleteUserRating' : {
				method : 'DELETE',
				url : DomainBase.actor + '/:actorId/user-ratings/:userRatingId',
				params : {
					actorId : '@actorId',
					userRatingId : '@userRatingId'
				},
				isArray : false
			}
		});

		return service;
	}

})();