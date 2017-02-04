package com.social.trakt.business.interfaces;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;

import com.social.trakt.model.Search;
import com.social.web.rest.response.ResponseAPI;

public interface SearchTraktAPIBusiness {
	
	@PreAuthorize("permitAll")
	public ResponseAPI<List<Search>> getSearch(String type, String page, String limit, String extended, String query,
			String fields);

}
