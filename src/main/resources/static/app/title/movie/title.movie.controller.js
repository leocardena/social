(function () {
	
	'use strict';
	
	angular
			.module('social.title')
			.controller('TitleMovieController', TitleMovieController);
	
	TitleMovieController.$inject = ['$stateParams', 'TmdbMovieService', 'movieSummaryPrepService', 'moviePeoplePrepService',
	                                'movieTranslationsPrepService', 'relatedMoviesPrepService', '$window', '$state',
	                                'TrailerModalService', 'TmdbPersonService'];
	
	/*@ngInject*/
	function TitleMovieController($stateParams, TmdbMovieService, movieSummaryPrepService, moviePeoplePrepService, 
			movieTranslationsPrepService, relatedMoviesPrepService, $window, $state, TrailerModalService, TmdbPersonService) {
		var vm = this;
		vm.movie = movieSummaryPrepService;
		vm.movie.cast = moviePeoplePrepService.cast;
		vm.movie.crew = moviePeoplePrepService.crew;
		vm.movie.relatedMovies = relatedMoviesPrepService;
		vm.movie.rating = 3;
		vm.openTrailer = _openTrailer;
		vm.imageNotAvailable = 'content/images/search/phosto-not-available.jpg';
		var startCast = 0;
		var endCast = 5; 
		var maxVisualisedCast = 5;
		vm.castArray = vm.movie.cast.slice(startCast, endCast);
		vm.loadMore = _loadMore;
		vm.exibirTitulo = _exibirTitulo;
		
		_init();
		
		function _openTrailer() {
			TrailerModalService.open(vm.movie.trailer);
		}
		
        function _exibirTitulo(traktSlug, title) {
        	$state.go('movie', {
				'title' : title, 
				'traktSlug' : traktSlug,
				'type' : 'movie'
			});
        }
		
		function _loadMore(action) {
			if (action === 'more') {
				if (endCast == vm.movie.cast.length) return;
				startCast++;
				endCast++;
				if (maxVisualisedCast < vm.movie.cast.length && maxVisualisedCast < endCast) {
					maxVisualisedCast++;
					
		    		TmdbPersonService.getPersonImage({
						profileSize : 'w185',
						personId : vm.movie.cast.slice(endCast - 1, endCast)[0].person.ids.tmdb
					}).$promise.then(function (data) {
						vm.movie.cast[endCast - 1].person.image = data.file_path;
					});
				
				}
			} else {
				if (startCast == 0) return;
				startCast--;
				endCast--;
			}
			
			vm.castArray = vm.movie.cast.slice(startCast, endCast);
		}
		
    	function _loadImages(tmdb) {
        	TmdbMovieService.getMovieImage({
        		movieId: tmdb,
        		posterSize: 'w300',
				backdropSize: 'w1280',
				language: 'pt'
        	}).$promise.then(function (data) {
        		vm.movie.images = data;
        		_insertBackground(vm.movie.images.backdrop.file_path);
        	});
    	}
    	
    	function _loadRelatedMovies() {
    		for (var i = 0; i < 5; i++) {
				_get(i, vm.movie.relatedMovies);
			}
    		
    		function _get(pos, relatedMovies) {
            	TmdbMovieService.getMovieImage({
            		movieId: relatedMovies[pos].ids.tmdb,
            		posterSize: 'w300',
    				backdropSize: 'w1280',
    				language: 'pt'
            	}).$promise.then(function (data) {
            		vm.movie.relatedMovies[pos].images = data;
            	});
    		}
    	}
    	
    	function _loadPersonImage() {
    		
    		for (var i = 0; i < 5; i++) {
				_get(i, vm.movie);
			}
    		
    		function _get(pos, movies) {
    	   		TmdbPersonService.getPersonImage({
    				profileSize : 'w185',
    				personId : movies.cast[pos].person.ids.tmdb
    			}).$promise.then(function (data) {
    				movies.cast[pos].person.image =  data.file_path;
    			}); 
    		}
 
    	}
    	
    	function _insertBackground (backgroundUrl) {
			if (backgroundUrl) {
    			$state.current.data.background = backgroundUrl;
    		} else {
    			$state.current.data.background = null;
    		}
    	}
    	
    	function _init() {
    		
    		_loadPersonImage();
    		_loadRelatedMovies();
    		
    		if (movieTranslationsPrepService.length > 0) {
    			vm.movie.overview = movieTranslationsPrepService[0].overview;
    			vm.movie.title = movieTranslationsPrepService[0].title;
    		}
    		
    		if (!$stateParams.title) {
    			 _loadImages(vm.movie.ids.tmdb);
    		} else {
    			vm.movie.images = $stateParams.title.images;
    			_insertBackground(vm.movie.images.backdrop.file_path);
    		}
    		
    		$window.document.title = vm.movie.title;
    		
    	} 
		
	}
	
})();