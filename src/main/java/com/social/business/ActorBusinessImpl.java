package com.social.business;

import java.util.Optional;

import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.cloudtrail.model.ResourceNotFoundException;
import com.social.business.interfaces.ActorBusiness;
import com.social.domain.Actor;
import com.social.domain.CommentParent;
import com.social.domain.RatingParent;
import com.social.repository.ActorRepository;
import com.social.repository.CommentParentRepository;
import com.social.repository.RatingParentRepository;
import com.social.repository.RatingRepository;
import com.social.web.rest.dto.ActorDTO;
import com.social.web.rest.dto.RatingDTO;
import com.social.web.rest.vm.ActorRatingVM;

@Service
public class ActorBusinessImpl implements ActorBusiness {

	@Autowired
	private ActorRepository actorRepository;
	@Autowired
	private RatingParentRepository ratingParentRepository;
	@Autowired
	private CommentParentRepository commentParentRepository;
	@Autowired
	private RatingRepository ratingRepository;
	
	@Override
	public Actor createActor(ActorRatingVM actorRatingVM, String slug) {
		
		RatingParent ratingParent = ratingParentRepository.saveAndFlush(new RatingParent());
		CommentParent commentParent = commentParentRepository.saveAndFlush(new CommentParent());
		
		Actor actor = new Actor();
		actor.setCountry(actorRatingVM.getCountry());
		actor.setImdb(actorRatingVM.getImdb());
		actor.setName(actorRatingVM.getName());
		actor.setSlug(slug);
		actor.setCommentParent(commentParent);
		actor.setRatingParent(ratingParent);
		
		return actorRepository.saveAndFlush(actor);
	}

	@Override
	public Optional<Actor> findBySlug(String slug) {
		return actorRepository.findBySlug(slug);
	}

	@Override
	public ActorDTO getActor(String slug) {
		
		Optional<Actor> actorOptional = findBySlug(slug);
		
		if(!actorOptional.isPresent())
			throw new ResourceNotFoundException("Actor não encontrado!");
		
		Actor actor = actorOptional.get();
		ActorDTO actorDTO = new ActorDTO();
		actorDTO.setId(actor.getId());
		actorDTO.setBirthday(actor.getBirthday().toString(DateTimeFormat.forPattern("dd/MM/yyyy")));
		actorDTO.setCountry(actor.getCountry());
		actorDTO.setImdb(actor.getImdb());
		actorDTO.setName(actor.getName());
		actorDTO.setSlug(slug);
		
		RatingDTO ratingDTO = new RatingDTO();
		ratingDTO.setIdRatingParent(actor.getRatingParent().getId() != null ? actor.getRatingParent().getId() : null);
		
		Optional<RatingDTO> ratingDTOOptional = ratingRepository
				.averageAndVotesByIdRatingParent(ratingDTO.getIdRatingParent());
		
		if(ratingDTOOptional.isPresent()){
			RatingDTO ratingDTOAux = ratingDTOOptional.get();
			ratingDTO.setAverage(ratingDTOAux.getAverage());
			ratingDTO.setVotes(ratingDTOAux.getVotes());
		}
		
		actorDTO.setRating(ratingDTO);
		
		return actorDTO;
	}

}
