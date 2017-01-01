(function() {
    'use strict';

    angular
        .module('social.title')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
    	
    	$stateProvider
            
    	.state('show', {
    		parent: 'title',
    		url: '',
    		params: {
    			title : null,
    			traktSlug : null,
    			type : null
    		},
    		data: {
    			authorities: [],
    			pageTitle: ''
    		},
			views : {
				'content@' : {
					templateUrl : 'app/title/show/title.show.html',
					controller: 'TitleShowController',
					controllerAs: 'vm'
				}
			},
			resolve : {
				showSummaryPrepService : showSummaryPrepService,
				showPeoplePrepService : showPeoplePrepService,
				showTranslationsPrepService : showTranslationsPrepService,
				relatedShowsPrepService : relatedShowsPrepService
			}
    	});
    	
    	showSummaryPrepService.$inject = ['$stateParams', 'TraktShowService'];
        
        /*@ngInject*/
        function showSummaryPrepService ($stateParams, TraktShowService) {
        	return TraktShowService.getSummaryShow({
        		movieId : $stateParams.traktSlug,
        		extended : 'full'
        	}).$promise.then(function (data) {
        		return data;
        	});
        }
        
        showPeoplePrepService.$inject = ['$stateParams', 'TraktShowService'];
        
        /*@ngInject*/
        function showPeoplePrepService ($stateParams, TraktShowService) {
        	return TraktShowService.getAllPeopleForAShow({
        		movieId : $stateParams.traktSlug
        	}).$promise.then(function (data) {
        		return data;
        	});
        }
        
        showTranslationsPrepService.$inject = ['$stateParams', 'TraktShowService'];
        
        /*@ngInject*/
        function showTranslationsPrepService ($stateParams, TraktShowService) {
        	return TraktShowService.getTranslationShow({
        		movieId : $stateParams.traktSlug,
        		language : 'pt'
        	}).$promise.then(function (data) {
        		return data;
        	});
        }
        
        relatedShowsPrepService.$inject = ['$stateParams', 'TraktShowService'];
        
        /*@ngInject*/
        function relatedShowsPrepService ($stateParams, TraktShowService) {
        	return TraktShowService.getRelatedShows({
        		movieId : $stateParams.traktSlug,
        		page : '1',
        		limit : '5'
        	}).$promise.then(function (data) {
        		return data;
        	});
        }
        
    }
})();
