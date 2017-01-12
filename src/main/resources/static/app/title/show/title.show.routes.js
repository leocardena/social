(function() {
    'use strict';

    angular
        .module('social.title')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
    	
    	$stateProvider
            
    	.state('show', {
    		parent: 'social',
    		url: '/shows/{traktSlug}',
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
					templateUrl : 'app/title/show/title.show.html',
					controller: 'TitleShowController',
					controllerAs: 'vm'
				}
			},
			resolve : {
				showTranslationsPrepService : showTranslationsPrepService,
				showSummaryPrepService : showSummaryPrepService,
				showPeoplePrepService : showPeoplePrepService,
				relatedShowsPrepService : relatedShowsPrepService,
				seasonsShowPrepService : seasonsShowPrepService
			}
    	})
    	
    	.state('season', {
    		parent: 'show',
    		url: '/seasons/{seasonNumber}',
    		params: {
    			season : null,
    			show  : null,
    			seasonNumber : null
    		},
    		data : {
    			authorities: [],
    			pageTitle: ''
    		}, 
    		views : {
				'content@' : {
					templateUrl : 'app/title/show/title.show.season.html',
					controller: 'TitleShowSeasonController',
					controllerAs: 'vm'
				}
			},
			resolve : {
				seasonPrepService : seasonPrepService
			} 
    	})
    	
    	.state('episode', {
    		parent: 'social',
    		url: '/shows/{traktSlug}/seasons/{seasonNumber}/episodes/{episodeNumber}',
    		params: {
    			episodeNumber : null,
    			seasonNumber : null,
    			traktSlug : null,
    			episodeImages : null,
    			showImages : null
    		},
    		data : {
    			authorities: [],
    			pageTitle: ''
    		}, 
    		views : {
    			'content@' : {
    				templateUrl : 'app/title/show/title.show.episode.html',
    				controller: 'TitleShowEpisodeController',
    				controllerAs: 'vm'
    			}
    		},
    		resolve : {
    			showTranslationsPrepService : showTranslationsPrepService,
    			episodePrepService : episodePrepService,
    			episodeTranslationsPrepService : episodeTranslationsPrepService,
    			minimalInfoShowSummaryPrepService : minimalInfoShowSummaryPrepService
    		}
    	});
    	
        showTranslationsPrepService.$inject = ['$stateParams', 'TraktShowService'];
        
        /*@ngInject*/
        function showTranslationsPrepService ($stateParams, TraktShowService) {
        	return TraktShowService.getTranslationShow({
        		showId : $stateParams.traktSlug,
        		language : 'pt'
        	}).$promise.then(function (data) {
        		return data;
        	});
        }
    	
    	showSummaryPrepService.$inject = ['$stateParams', 'TraktShowService'];
        
        /*@ngInject*/
        function showSummaryPrepService ($stateParams, TraktShowService) {
        	return TraktShowService.getSummaryShow({
        		showId : $stateParams.traktSlug,
        		extended : 'full'
        	}).$promise.then(function (data) {
        		return data;
        	});
        }
        
        showPeoplePrepService.$inject = ['$stateParams', 'TraktShowService'];
        
        /*@ngInject*/
        function showPeoplePrepService ($stateParams, TraktShowService) {
        	return TraktShowService.getAllPeopleForAShow({
        		showId : $stateParams.traktSlug
        	}).$promise.then(function (data) {
        		return data;
        	});
        }
        
        relatedShowsPrepService.$inject = ['$stateParams', 'TraktShowService'];
        
        /*@ngInject*/
        function relatedShowsPrepService ($stateParams, TraktShowService) {
        	return TraktShowService.getRelatedShows({
        		showId : $stateParams.traktSlug,
        		page : '1',
        		limit : '5'
        	}).$promise.then(function (data) {
        		return data;
        	});
        }
        
        seasonsShowPrepService.$inject = ['$stateParams', 'TraktShowService'];
        
        /*@ngInject*/
        function seasonsShowPrepService ($stateParams, TraktShowService) {
        	return TraktShowService.getAllSeasonsShow({
        		showId : $stateParams.traktSlug
        	}).$promise.then(function (data) {
        		return data;
        	});
        }
        
        seasonPrepService.$inject = ['$stateParams', 'TraktShowService'];
        
        /*@ngInject*/
        function seasonPrepService ($stateParams, TraktShowService) {
        	return TraktShowService.getASingleSeason({
        		showId : $stateParams.traktSlug,
        		seasonNumber : $stateParams.seasonNumber,
        		translations : 'pt',
        		extended : 'full'
        	}).$promise.then(function (data) {
        		return data;
        	});
        }
        
        episodePrepService.$inject = ['$stateParams', 'TraktShowService'];
        
        /*@ngInject*/
        function episodePrepService ($stateParams, TraktShowService) {
        	return TraktShowService.getASingleEpisode({
        		showId : $stateParams.traktSlug,
        		seasonNumber : $stateParams.seasonNumber,
        		episodeNumber : $stateParams.episodeNumber,
        		extended : 'full'
        	}).$promise.then(function (data) {
        		return data;
        	});
        }
        
        episodeTranslationsPrepService.$inject = ['$stateParams', 'TraktShowService'];
        
        /*@ngInject*/
        function episodeTranslationsPrepService ($stateParams, TraktShowService) {
        	return TraktShowService.getTranslationsEpisode({
        		showId : $stateParams.traktSlug,
        		seasonNumber : $stateParams.seasonNumber,
        		episodeNumber : $stateParams.episodeNumber,
        		extended : 'full',
        		language : 'pt'
        	}).$promise.then(function (data) {
        		return data;
        	});
        }
        
        minimalInfoShowSummaryPrepService.$inject = ['$stateParams', 'TraktShowService'];
        
        /*@ngInject*/
        function minimalInfoShowSummaryPrepService ($stateParams, TraktShowService) {
        	return TraktShowService.getSummaryShow({
        		showId : $stateParams.traktSlug
        	}).$promise.then(function (data) {
        		return data;
        	});
        }
        
    }
})();
