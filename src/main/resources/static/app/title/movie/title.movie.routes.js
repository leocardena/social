(function() {
    'use strict';

    angular
        .module('social.title')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {

    	$stateProvider
            
    	.state('movie', {
    		parent: 'social',
    		url: '/movie/{traktSlug}',
    		params: {
    			title : null,
    			traktSlug : null
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
			},
			resolve : {
				movieSummaryPrepService : movieSummaryPrepService,
				moviePeoplePrepService : moviePeoplePrepService,
				movieTranslationsPrepService : movieTranslationsPrepService,
				relatedMoviesPrepService : relatedMoviesPrepService
			}
    	});
    	
    	movieSummaryPrepService.$inject = ['$stateParams', 'TraktMovieService'];
        
        /*@ngInject*/
        function movieSummaryPrepService ($stateParams, TraktMovieService) {
        	return TraktMovieService.getSummaryMovie({
        		movieId : $stateParams.traktSlug,
        		extended : 'full'
        	}).$promise.then(function (data) {
        		return data;
        	});
        }
        
        moviePeoplePrepService.$inject = ['$stateParams', 'TraktMovieService'];
        
        /*@ngInject*/
        function moviePeoplePrepService ($stateParams, TraktMovieService) {
        	return TraktMovieService.getAllPeopleForAMovie({
        		movieId : $stateParams.traktSlug
        	}).$promise.then(function (data) {
        		return data;
        	});
        }
        
        movieTranslationsPrepService.$inject = ['$stateParams', 'TraktMovieService'];
        
        /*@ngInject*/
        function movieTranslationsPrepService ($stateParams, TraktMovieService) {
        	return TraktMovieService.getTranslationMovie({
        		movieId : $stateParams.traktSlug,
        		language : 'pt'
        	}).$promise.then(function (data) {
        		return data;
        	});
        }
        
        relatedMoviesPrepService.$inject = ['$stateParams', 'TraktMovieService'];
        
        /*@ngInject*/
        function relatedMoviesPrepService ($stateParams, TraktMovieService) {
        	return TraktMovieService.getRelatedMovies({
        		movieId : $stateParams.traktSlug,
        		page : '1',
        		limit : '5'
        	}).$promise.then(function (data) {
        		return data;
        	});
        }
        
    }
})();
