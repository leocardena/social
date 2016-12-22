(function () {
	
	'use strict';
	
	angular
			.module('social.title')
			.controller('TitleMovieController', TitleMovieController);
	
	TitleMovieController.$inject = ['$stateParams', 'TmdbMovieService', 'movieSummaryPrepService', 'moviePeoplePrepService',
	                                'movieTranslationsPrepService', 'relatedMoviesPrepService', '$window', '$state',
	                                'TrailerModalService'];
	
	/*@ngInject*/
	function TitleMovieController($stateParams, TmdbMovieService, movieSummaryPrepService, moviePeoplePrepService, 
			movieTranslationsPrepService, relatedMoviesPrepService, $window, $state, TrailerModalService) {
		var vm = this;
		vm.movie = movieSummaryPrepService;
		vm.movie.cast = moviePeoplePrepService.cast;
		vm.movie.crew = moviePeoplePrepService.crew;
		vm.movie.relatedMovies = relatedMoviesPrepService;
		vm.movie.rating = 3;
		vm.openTrailer = _openTrailer;
		
		_init();
		
		function _openTrailer() {
			TrailerModalService.open(vm.movie.trailer);
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
    	
    	function _init() {
    		
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
    	
    	function _insertBackground (backgroundUrl) {
			if (backgroundUrl) {
    			$state.current.data.background = backgroundUrl;
    		} else {
    			$state.current.data.background = null;
    		}
    	}
		
	}
	
})();