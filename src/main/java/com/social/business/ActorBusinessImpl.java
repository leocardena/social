package com.social.business;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.business.interfaces.ActorBusiness;
import com.social.domain.Actor;
import com.social.domain.CommentParent;
import com.social.domain.RatingParent;
import com.social.repository.ActorRepository;
import com.social.repository.CommentParentRepository;
import com.social.repository.RatingParentRepository;
import com.social.web.rest.dto.ActorDTO;
import com.social.web.rest.vm.ActorRatingVM;

@Service
public class ActorBusinessImpl implements ActorBusiness {

	@Autowired
	private ActorRepository actorRepository;
	@Autowired
	private RatingParentRepository ratingParentRepository;
	@Autowired
	private CommentParentRepository commentParentRepository;
	
	@Override
	public Actor createActor(ActorRatingVM actorRatingVM, String slug) {
		
		RatingParent ratingParent = ratingParentRepository.saveAndFlush(new RatingParent());
		CommentParent commentParent = commentParentRepository.saveAndFlush(new CommentParent());
		
		Actor actor = new Actor();
		actor.setBirthday(actorRatingVM.getBirthday());
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
		return null;
	}

}
