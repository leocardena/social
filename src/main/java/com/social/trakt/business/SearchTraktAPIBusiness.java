package com.social.trakt.business;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import com.social.domain.ResponseAPI;
import com.social.trakt.model.Search;

public interface SearchTraktAPIBusiness {
	
	@PreAuthorize("permitAll")
	public ResponseAPI<List<Search>> getSearch(String type, String page, String limit, String extended, String query,
			String fields);

}
