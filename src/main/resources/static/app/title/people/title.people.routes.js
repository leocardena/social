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
    		url: '/{traktSlug}',
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
				showTranslationsPrepService : showTranslationsPrepService,
				showSummaryPrepService : showSummaryPrepService
			}
    	});
        
    }
})();
