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
    	})
    	
    	.state('movie', {
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
					templateUrl : 'app/title/movie/title.movie.html',
					controller: 'TitleMovieController',
					controllerAs: 'vm'
				}
			}
    	});
    	
    	
        
        titlePrepService.$inject = ['$stateParams'];
        
        /*@ngInject*/
        function titlePrepService ($stateParams) {
        	
        	/* Call request with $stateParams.traktSlug
        		in the end of request if ($stateParams.title == null) call images service
        	*/
        	
        }
        
    }
})();
