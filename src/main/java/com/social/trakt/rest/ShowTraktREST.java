package com.social.trakt.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.social.domain.ResponseAPI;
import com.social.trakt.business.ShowTraktAPIBusiness;
import com.social.trakt.model.Show;
import com.social.trakt.util.APITraktEndpoint;

@RestController
@RequestMapping(value = APITraktEndpoint.SHOW)
public class ShowTraktREST {

	@Autowired
	private ShowTraktAPIBusiness business;

	@GetMapping(value = "/popular")
	public ResponseEntity<?> getPopularShows(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "limit", required = false) String limit,
			@RequestParam(value = "extended", required = false) String extended,
			@RequestParam(value = "query", required = false) String query,
			@RequestParam(value = "genres", required = false) String genres) {

		ResponseAPI<List<Show>> response = business.getPopularShows(page, limit, extended, query, genres);
		return ResponseEntity.ok().headers(response.getHeaders()).body(response.getBody());
	}

}
