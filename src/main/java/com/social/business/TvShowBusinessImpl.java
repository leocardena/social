package com.social.business;

import java.util.Optional;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.social.domain.CommentParent;
import com.social.domain.Profile;
import com.social.domain.Rating;
import com.social.domain.RatingParent;
import com.social.domain.TvShow;
import com.social.domain.User;
import com.social.repository.CommentParentRepository;
import com.social.repository.ProfileRepository;
import com.social.repository.RatingParentRepository;
import com.social.repository.RatingRepository;
import com.social.repository.TvShowRepository;
import com.social.repository.UserRepository;
import com.social.security.util.SecurityUtils;
import com.social.web.rest.dto.UserRatingDTO;
import com.social.web.rest.exception.LoginNotFoundException;
import com.social.web.rest.response.PostResponseAPI;
import com.social.web.rest.vm.TitleRatingVM;

@Service
public class TvShowBusinessImpl implements TvShowBusiness {
	
	@Autowired
	private TvShowRepository tvShowRepository;
	
	@Autowired 
	private ProfileRepository profileRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RatingParentRepository ratingParentRepository;
	
	@Autowired
	private CommentParentRepository commentParentRepository;
	
	@Autowired
	private RatingRepository ratingRepository;
	
	@Override
	public PostResponseAPI<UserRatingDTO> postUserRating(String showId, TitleRatingVM titleRating) {
		Optional<TvShow> tvShowOptional = tvShowRepository.findBySlug(showId);
		TvShow tvShow;
		
		if (!tvShowOptional.isPresent()) {
			tvShow = createTvShow(titleRating, showId);
		} else {
			tvShow = tvShowOptional.get();
		}
		
		Rating rating = new Rating();
		rating.setDate(new DateTime());
		rating.setNote(titleRating.getRating().getNote());
		rating.setIdRatingParent(tvShow.getRatingParent());
		
		Profile profile = findProfileByLoggedUser();
		rating.setProfile(profile.getId());
	
		Rating ratingSaved = ratingRepository.save(rating);
		
		UserRatingDTO u = new UserRatingDTO();
		u.setNote(ratingSaved.getNote());
		return new PostResponseAPI<>("/api/rest/shows/" + showId + "/user-rating", u);
	}
	
	private TvShow createTvShow(TitleRatingVM titleRating, String showId) {
		//criando um novo comentParent e ratingParent para o show que sera inserido
		RatingParent ratingParent = ratingParentRepository.saveAndFlush(new RatingParent());
		CommentParent commentParent = commentParentRepository.saveAndFlush(new CommentParent());
		
		//Realizando o de/para entre a classe DTO e a classe de dominio
		TvShow tvShow = new TvShow();
		tvShow.setHomePage(titleRating.getHomePage());
		tvShow.setImdb(titleRating.getImdb());
		tvShow.setName(titleRating.getName());
		tvShow.setSlug(showId);
		tvShow.setTrailer(titleRating.getTrailer());
		tvShow.setCommentParent(commentParent);
		tvShow.setRatingParent(ratingParent);
		
		//criando o novo tvShow 
		return tvShowRepository.saveAndFlush(tvShow);
	}
	
	private Profile findProfileByLoggedUser() {
		Optional<User> userOptional = userRepository.findOneByUsername(SecurityUtils.getCurrentUserLogin());
		
		if (!userOptional.isPresent())
			throw new LoginNotFoundException("Login não encontrado");
		
		return profileRepository.findOneByUser(userOptional.get()).get();
	}

}
