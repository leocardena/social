package com.social.business;

import java.util.Optional;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.applicationdiscovery.model.ResourceNotFoundException;
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

@Service
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
		
		if(actorOptional.isPresent()){
			actor = actorOptional.get();
		}else{ 
			actor = actorBusiness.createActor(actorRatingVM, slug);
		}
		
		Profile profile = accountBusiness.findProfileByLoggedUser();
		
		Rating rating = new Rating();
		rating.setDate(new DateTime());
		rating.setNote(actorRatingVM.getRating().getNote());
		rating.setProfile(profile.getId());
		rating.setIdRatingParent(actor.getRatingParent());
		
		Rating ratingStoraged = ratingRepository.save(rating);
		
		UserRatingDTO u = new UserRatingDTO(ratingStoraged.getNote());
		return new PostResponseAPI<>("/api/rest/actor/" + slug + "/user-ratings/" + ratingStoraged.getIdRating(), u);
	}

	@Override
	public UserRatingDTO putRatingForActor(Long idRating, RatingVM ratingVM, String slug) {

		Optional<Actor> actorOptional = actorBusiness.findBySlug(slug);
		
		if(!actorOptional.isPresent())
			throw new ResourceNotFoundException("Actor não encontrado!");
		
		Optional<Rating> ratingOptional = ratingRepository.findRatingByIdRating(idRating);
		
		if(!ratingOptional.isPresent())
			throw new ResourceNotFoundException("Rating não encontrado!");
		
		Rating rating = ratingOptional.get();
		
		rating.setDate(new DateTime());
		rating.setNote(ratingVM.getNote());

		Rating ratingUpdated = ratingRepository.save(rating);

		return new UserRatingDTO(ratingUpdated.getNote(), ratingUpdated.getIdRating());
		
	}

	@Override
	public void deleteRatingForActor(Long idRating, String slug) {

		Optional<Actor> actorOptional = actorBusiness.findBySlug(slug);
		
		if(!actorOptional.isPresent())
			throw new ResourceNotFoundException("Ator não encontrado!");
		
		Optional<Rating> ratingOptional = ratingRepository.findRatingByIdRating(idRating);
		
		if(!ratingOptional.isPresent())
			throw new ResourceNotFoundException("Rating não encontrado!");
		
		ratingRepository.delete(ratingOptional.get());
		
	}

	@Override
	public UserRatingDTO getUserRatingForActor(String slug, Long idRatingParent) {

		Profile profile = accountBusiness.findProfileByLoggedUser();
		
		Optional<Rating> ratingOptinal = ratingRepository.findUserRating(profile.getId(), idRatingParent, slug);

		if (!ratingOptinal.isPresent())
			throw new ResourceNotFoundException("Rating nao encontrado");

		Rating rating = ratingOptinal.get();

		return new UserRatingDTO(rating.getNote(), rating.getIdRating());
		
	}

}
