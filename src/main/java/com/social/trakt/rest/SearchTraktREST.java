package com.social.trakt.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.social.domain.ResponseAPI;
import com.social.trakt.business.SearchTraktAPIBusiness;
import com.social.trakt.model.Search;
import com.social.trakt.util.APITraktEndpoint;

@RestController
@RequestMapping(value = APITraktEndpoint.SEARCH)
public class SearchTraktREST {

	@Autowired
	private SearchTraktAPIBusiness searchTraktAPIBusiness;

	@GetMapping(value = "/{type}")
	public ResponseEntity<?> get(@PathVariable(value = "type") String type,
			@RequestParam(value = "query", required = true) String query,
			@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "limit", required = false) String limit,
			@RequestParam(value = "extended", required = false) String extended,
			@RequestParam(value = "fields", required = false) String fields) {
		ResponseAPI<List<Search>> response = searchTraktAPIBusiness.getSearch(type, page, limit, extended, query, fields);
		return ResponseEntity.ok().headers(response.getHeaders()).body(response.getBody());
	}

}
