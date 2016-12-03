package com.social.tmdb.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.social.tmdb.business.MovieTmdbAPIBusiness;
import com.social.tmdb.model.Movie;
import com.social.tmdb.util.ApiTmdbEndpoint;

@RestController
@RequestMapping(value = ApiTmdbEndpoint.MOVIE)
public class MovieTmdbREST {

	@Autowired
	private MovieTmdbAPIBusiness business;

	@GetMapping(value = "/popular/random")
	public ResponseEntity<?> getPopularMovies(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "language", required = false) String language,
			@RequestParam(value = "size", required = true) String size) {
		Movie movie = business.getPopularRandomMovie(size);
		return ResponseEntity.ok().body(movie);
	}

	@GetMapping(value = "/{movieId}/images")
	public ResponseEntity<?> getMovieImages(@RequestParam(value = "language", required = false) String language,
			@RequestParam(value = "posterSize", required = true) String posterSize,
			@RequestParam(value = "backdropSize", required = true) String backdropSize,
			@PathVariable(value = "movieId") String movieId) {
		Map<String, Object> map = business.getMovieImages(movieId, backdropSize, posterSize, language);
		return ResponseEntity.ok().body(map);
	}

}
