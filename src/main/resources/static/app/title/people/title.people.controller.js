(function () {
	
	'use strict';
	
	angular
			.module('social.title')
			.controller('TitlePeopleController', TitlePeopleController);
	
	TitlePeopleController.$inject = ['personSummaryPrepService', 'personMoviesPrepService',
	                                 'personShowsPrepService', '$stateParams', 'TmdbPersonService'];
	
	/*@ngInject*/
	function TitlePeopleController(personSummaryPrepService, personMoviesPrepService,
			personShowsPrepService, $stateParams, TmdbPersonService) {
		
		var vm = this;
		vm.people = personSummaryPrepService;
		vm.people.actor = personMoviesPrepService.cast.concat(personShowsPrepService.cast);
		vm.people.production = personMoviesPrepService.crew.production.concat(personShowsPrepService.crew.production);
		vm.imageNotAvailable = 'content/images/search/phosto-not-available.jpg';
		vm.startActor = 0;
		vm.startProduction = 0;
		vm.finalActor = vm.people.actor.length;
		vm.finalProduction = vm.people.production.length;	
		var maxVisitedActor = vm.finalActor;
		var maxVisitedProduction = vm.finalProduction;
		
		_init();
		
		function _init() {

			_checkPeopleImages();
			_calculateAge(new Date(vm.people.birthday));
			
			function _checkPeopleImages() {
				if ($stateParams.people) {
					if ($stateParams.people.ids.slug === $stateParams.traktSlug) {
						vm.people.images = $stateParams.people.images.poster;
					} else {
						_loadPersonImages();
					}
				} else {
					_loadPersonImages();
				}
			}
			
			function _calculateAge(dateString) {
				  var today = new Date();
				  var birthDate = new Date(dateString);
				  var age = today.getFullYear() - birthDate.getFullYear();
				  var m = today.getMonth() - birthDate.getMonth();
				  if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
				      age--;
				  }
				  vm.people.age = age;
			}
			
		}
		
		function _loadPersonImages() {
			TmdbPersonService.getPersonImage( {
				profileSize: 'w300',
				personId: vm.people.ids.tmdb
			}).$promise.then(function (data) {
				vm.people.images = data;
    		});
		}
		
	}
	
})();