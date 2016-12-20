(function() {
    'use strict';

    angular
        .module('social.title')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        
    	$stateProvider
            
    	.state('title', {
    		parent: 'social',
    		abstract: true,
    		url: '/{type}/{traktSlug}',
    		params: {
    			title : null
    		},
    		data: {
    			authorities: [],
    			pageTitle: ''
    		},
    		views: {
    			'content@': {
    				controller: 'TitleController'
    			}
    		}
    	});
    	
    }
    
})();
