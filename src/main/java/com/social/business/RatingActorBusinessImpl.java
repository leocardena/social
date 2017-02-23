package com.social.business;

import java.util.Optional;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.services.appstream.model.ResourceNotAvailableException;
import com.amazonaws.services.shield.model.ResourceNotFoundException;
import com.social.business.interfaces.AccountBusiness;
import com.social.business.interfaces.ActorBusiness;
import com.social.business.interfaces.RatingActorBusiness;
import com.social.domain.Actor;
import com.social.domain.Profile;
import com.social.domain.Rating;
import com.social.repository.RatingRepository;
import com.social.web.rest.dto.UserRatingDTO;
import com.social.web.rest.response.PostResponseAPI;
import com.social.web.rest.vm.ActorRatingVM;
import com.social.web.rest.vm.RatingVM;

public class RatingActorBusinessImpl implements RatingActorBusiness {

	@Autowired
	private ActorBusiness actorBusiness;
	
	@Autowired
	private AccountBusiness accountBusiness;
	
	@Autowired
	private RatingRepository ratingRepository;
	
	@Override
	public PostResponseAPI<UserRatingDTO> postRatingForActor(String slug, ActorRatingVM actorRatingVM) {

		Optional<Actor> actorOptional = actorBusiness.findBySlug(slug);
		Actor actor;
		
		if(actorOptional.isPresent())
			actor = actorBusiness.createActor(actorRatingVM, slug);
		else 
			actor = actorOptional.get();
			
		Profile profile = accountBusiness.findProfileByLoggedUser();
		
		Rating rating = new Rating();
		rating.setDate(new DateTime());
		rating.setNote(actorRatingVM.getRatingVM().getNote());
		rating.setProfile(profile.getId());
		rating.setIdRatingParent(actor.getRatingParent());
		
		Rating ratingStoraged = ratingRepository.save(rating);
		
		UserRatingDTO u = new UserRatingDTO(ratingStoraged.getNote());
		return new PostResponseAPI<>("/api/rest/actor/" + slug + "/user-ratings/" + ratingStoraged.getIdRating(), u);
	}

	@Override
	public UserRatingDTO putRatingForActor(Long idRating, RatingVM ratingVM, String slug) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRatingForActor(Long idRating, String slug) {
		// TODO Auto-generated method stub

	}

	@Override
	public UserRatingDTO getUserRatingForActor(String slug, Long idRatingParent) {
		// TODO Auto-generated method stub
		return null;
	}

}
