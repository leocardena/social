package com.social.rest;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.social.rest.util.APIEndpoint;
import com.social.trakt.business.MovieAPIBusiness;
import com.social.trakt.model.Movie;

@RestController
@RequestMapping(value = APIEndpoint.MOVIE)
public class MovieREST {

	@Autowired
	private MovieAPIBusiness service;

	@GetMapping(value = "/popular")
	public ResponseEntity<?> getPopularMovies(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "limit", required = false) String limit,
			@RequestParam(value = "extended", required = false) String extended) {
		
		Map<String, Object> results = service.getPopularMovies(page, limit, extended);
		@SuppressWarnings("unchecked")
		List<Movie> movies = (List<Movie>) results.get("movies");
		HttpHeaders headers = (HttpHeaders) results.get("headers");
		
		return ResponseEntity.ok().headers(headers).body(movies);
	}

}
