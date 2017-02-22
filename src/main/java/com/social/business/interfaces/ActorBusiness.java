package com.social.business.interfaces;

import java.util.Optional;

import org.springframework.security.access.prepost.PreAuthorize;

import com.social.domain.Actor;
import com.social.web.rest.dto.ActorDTO;
import com.social.web.rest.vm.ActorRatingVM;

public interface ActorBusiness {

	@PreAuthorize("hasRole('ROLE_USER')")
	Actor createActor(ActorRatingVM actorRatingVM, String slug);
	
	@PreAuthorize("hasRole('ROLE_USER')")
	Optional<Actor> findBySlug(String slug);
	
	@PreAuthorize("hasRole('ROLE_USER')")
	ActorDTO getActor(String slug);
	
}
