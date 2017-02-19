package com.social.business.interfaces;

import java.util.Optional;

import org.springframework.security.access.prepost.PreAuthorize;

import com.social.domain.Movie;
import com.social.web.rest.dto.MovieDTO;
import com.social.web.rest.vm.TitleRatingVM;

public interface MovieBusiness {
		
	@PreAuthorize("hasRole('ROLE_USER')")
	Movie createMovie(TitleRatingVM titleRating, String slug);
	
	@PreAuthorize("hasRole('ROLE_USER')")
	Optional<Movie> findBySlug(String slug);
	
	@PreAuthorize("hasRole('ROLE_USER')")
	MovieDTO getMovie(String id);
}