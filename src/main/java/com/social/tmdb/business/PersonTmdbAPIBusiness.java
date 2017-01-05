package com.social.tmdb.business;

import org.springframework.security.access.prepost.PreAuthorize;
import com.social.tmdb.model.Profile;

public interface PersonTmdbAPIBusiness {
	
	@PreAuthorize("permitAll")
	public Profile getPersonImages(String personId, String profileSize);

}
