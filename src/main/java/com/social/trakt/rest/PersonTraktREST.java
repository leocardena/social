package com.social.trakt.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.social.trakt.business.PersonTraktAPIBusiness;
import com.social.trakt.util.APITraktEndpoint;

@RestController
@RequestMapping(value = APITraktEndpoint.PERSON)
public class PersonTraktREST {
	
	@Autowired
	private PersonTraktAPIBusiness personBusiness;
	
	@GetMapping("/{personId}")
	public ResponseEntity<?> get(@PathVariable("personId") String personId,
			@RequestParam(value = "extended", required = false) String extended) {
		return ResponseEntity.ok(personBusiness.getSummaryPeople(personId, extended));
	}
	
	@GetMapping("/{personId}/movies")
	public ResponseEntity<?> getMovies(@PathVariable("personId") String personId,
			@RequestParam(value = "extended", required = false) String extended) {
		return ResponseEntity.ok(personBusiness.getMoviesPeople(personId, extended));
	}
	
	@GetMapping("/{personId}/shows")
	public ResponseEntity<?> getShows(@PathVariable("personId") String personId,
			@RequestParam(value = "extended", required = false) String extended) {
		return ResponseEntity.ok(personBusiness.getShowsPeople(personId, extended));
	}

}
