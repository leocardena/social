package com.social.tmdb.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.social.tmdb.business.MovieTmdbAPIBusiness;
import com.social.tmdb.util.ApiTmdbEndpoint;

@RestController
@RequestMapping(value = ApiTmdbEndpoint.MOVIE)
public class MovieTmdbREST {

	@Autowired
	private MovieTmdbAPIBusiness business;

	@GetMapping(value = "/popular")
	public ResponseEntity<?> getPopularMovies(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "language", required = false) String language,
			@RequestParam(value = "size", required = true) String size) {
		String response = business.getPopularRandomMovie(size);
		return ResponseEntity.ok().body(response);
	}

}
