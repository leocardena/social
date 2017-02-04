package com.social.business;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.social.domain.CommentParent;
import com.social.domain.RatingParent;
import com.social.domain.TvShow;
import com.social.repository.CommentParentRepository;
import com.social.repository.RatingParentRepository;
import com.social.repository.TvShowRepository;
import com.social.web.rest.vm.TitleRatingVM;

@Service
public class TvShowBusinessImpl implements TvShowBusiness {
	
	@Autowired
	private TvShowRepository tvShowRepository;
	
	@Autowired
	private RatingParentRepository ratingParentRepository;
	
	@Autowired
	private CommentParentRepository commentParentRepository;
	
	public TvShow createTvShow(TitleRatingVM titleRating, String showId) {
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
	
	public Optional<TvShow> findBySlug(String slug) {
		return tvShowRepository.findBySlug(slug);
	}

}
