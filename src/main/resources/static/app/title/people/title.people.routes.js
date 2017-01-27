(function() {
    'use strict';

    angular
        .module('social.title')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
    	
    	$stateProvider
            
    	.state('people', {
    		parent: 'social',
    		url: '/peoples/{traktSlug}',
    		params: {
    			people : null,
    			traktSlug : null
    		},
    		data: {
    			authorities: [],
    			pageTitle: ''
    		},
			views : {
				'content@' : {
					templateUrl : 'app/title/people/title.people.html',
					controller: 'TitlePeopleController',
					controllerAs: 'vm'
				}
			},
			resolve : {
				personSummaryPrepService : personSummaryPrepService,
				personMoviesPrepService : personMoviesPrepService,
				personShowsPrepService : personShowsPrepService
			}
    	});
    	
    	personSummaryPrepService.$inject = ['TraktPersonService', '$stateParams'];
    	
    	/*@ngInject*/
    	function personSummaryPrepService(TraktPersonService, $stateParams) {
    		return TraktPersonService.getSummaryPerson({
    			personId : $stateParams.traktSlug,
				extended : 'full'
    		}).$promise.then(function (data) {
    			return data;
    		});
    	}
    	
    	personMoviesPrepService.$inject = ['TraktPersonService', '$stateParams'];
    	
    	/*@ngInject*/
    	function personMoviesPrepService(TraktPersonService, $stateParams) {
    		return TraktPersonService.getPersonMovies({
    			personId : $stateParams.traktSlug
    		}).$promise.then(function (data) {
    			return data;
    		});
    	}
    	
    	personShowsPrepService.$inject = ['TraktPersonService', '$stateParams'];
    	
    	/*@ngInject*/
    	function personShowsPrepService(TraktPersonService, $stateParams) {
    		return TraktPersonService.getPersonShows({
    			personId : $stateParams.traktSlug
    		}).$promise.then(function (data) {
    			return data;
    		});
    	}
    	
        
    }
})();
