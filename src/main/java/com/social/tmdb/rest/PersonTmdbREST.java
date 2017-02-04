package com.social.tmdb.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.social.tmdb.business.interfaces.PersonTmdbAPIBusiness;
import com.social.tmdb.model.Profile;
import com.social.tmdb.util.ApiTmdbEndpoint;

@RestController
@RequestMapping(value = ApiTmdbEndpoint.PERSON)
public class PersonTmdbREST {

	@Autowired
	private PersonTmdbAPIBusiness business;

	@GetMapping(value = "/{personId}/images")
	public ResponseEntity<?> getPopularMovieImages(
			@RequestParam(value = "profileSize", required = true) String profileSize,
			@PathVariable(value = "personId") String personId) {
		Profile profile = business.getPersonImages(personId, profileSize);
		return ResponseEntity.ok().body(profile);
	}

}
