(function() {
    'use strict';

    angular
        .module('social.user.home')
        .controller('HomePublicController', HomePublicController);

    HomePublicController.$inject = ['TraktShowService', 'TraktMovieService', 'TmdbShowService', 
                                    'TmdbMovieService'];

    function HomePublicController (TraktShowService, TraktMovieService, TmdbShowService, 
    		TmdbMovieService) {
        var vm = this;
        
        function _getTranslationShow(showId, language) {
        	return TraktMovieService.getTranslationShow({
        		showId: showId,
        		language : language
        	});
        }
        
        function _getTranslationMovie(movieId, language) {
        	return TraktMovieService.getTranslationMovie({
        		movieId : movieId,
        		language : language
        	});
        }
        
    	function _getMovieImage(movieId, posterSize, backdropSize) {
    		return TmdbMovieService.getMovieImage({
    			movieId: movieId,
    			posterSize: posterSize,
    			backdropSize: backdropSize,
    			language: 'pt'
   			});
    	}
    	
    	function _getShowImage(showId, posterSize, backdropSize) {
   			return TmdbShowService.getShowImage({
   				showId: showId,
   				posterSize: posterSize,
   				backdropSize: backdropSize,
   				language: 'pt'
 			});
    	}
        
    }
    
})();
