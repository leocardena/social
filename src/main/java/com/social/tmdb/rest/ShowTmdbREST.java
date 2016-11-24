package com.social.tmdb.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.social.tmdb.business.ShowTmdbAPIBusiness;
import com.social.tmdb.model.Show;
import com.social.tmdb.util.ApiTmdbEndpoint;

@RestController
@RequestMapping(value = ApiTmdbEndpoint.SHOW)
public class ShowTmdbREST {

	@Autowired
	private ShowTmdbAPIBusiness business;

	@GetMapping(value = "/popular/random")
	public ResponseEntity<?> getPopularMovies(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "language", required = false) String language,
			@RequestParam(value = "size", required = true) String size) {
		Show show = business.getPopularRandomShow(size);
		return ResponseEntity.ok().body(show);
	}

}
