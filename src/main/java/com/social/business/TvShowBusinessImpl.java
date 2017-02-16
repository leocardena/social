package com.social.business;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.social.business.interfaces.TvShowBusiness;
import com.social.domain.CommentParent;
import com.social.domain.RatingParent;
import com.social.domain.TvShow;
import com.social.repository.CommentParentRepository;
import com.social.repository.RatingParentRepository;
import com.social.repository.RatingRepository;
import com.social.repository.TvShowRepository;
import com.social.repository.dto.RatingQueryDTO;
import com.social.web.rest.dto.TvShowDTO;
import com.social.web.rest.exception.ResourceNotFoundException;
import com.social.web.rest.vm.TitleRatingVM;

@Service
public class TvShowBusinessImpl implements TvShowBusiness {

	@Autowired
	private TvShowRepository tvShowRepository;

	@Autowired
	private RatingParentRepository ratingParentRepository;

	@Autowired
	private CommentParentRepository commentParentRepository;

	@Autowired
	private RatingRepository ratingRepository;

	@Override
	public TvShow createTvShow(TitleRatingVM titleRating, String showId) {
		// criando um novo comentParent e ratingParent para o show que sera
		// inserido
		RatingParent ratingParent = ratingParentRepository.saveAndFlush(new RatingParent());
		CommentParent commentParent = commentParentRepository.saveAndFlush(new CommentParent());

		// Realizando o de/para entre a classe DTO e a classe de dominio
		TvShow tvShow = new TvShow();
		tvShow.setHomePage(titleRating.getHomePage());
		tvShow.setImdb(titleRating.getImdb());
		tvShow.setName(titleRating.getName());
		tvShow.setSlug(showId);
		tvShow.setTrailer(titleRating.getTrailer());
		tvShow.setCommentParent(commentParent);
		tvShow.setRatingParent(ratingParent);

		// criando o novo tvShow
		return tvShowRepository.saveAndFlush(tvShow);
	}

	@Override
	public Optional<TvShow> findBySlug(String slug) {
		return tvShowRepository.findBySlug(slug);
	}

	@Override
	public TvShowDTO getTvShow(String id) {
		Optional<TvShow> tvShowOptional = findBySlug(id);

		if (!tvShowOptional.isPresent())
			throw new ResourceNotFoundException("Show nao encontrado");

		TvShow tvShow = tvShowOptional.get();

		TvShowDTO tvShowDTO = new TvShowDTO();
		tvShowDTO.setId(tvShow.getId());
		tvShowDTO.setHomePage(tvShow.getHomePage());
		tvShowDTO.setImdb(tvShow.getImdb());
		tvShowDTO.setName(tvShow.getName());
		tvShowDTO.setSlug(tvShow.getSlug());
		tvShowDTO.setTrailer(tvShow.getTrailer());

		Optional<RatingQueryDTO> ratingQueryDTOOptional = ratingRepository
				.averageByIdRatingParent(tvShow.getRatingParent().getId());
		
		if (ratingQueryDTOOptional.isPresent()) {
			RatingQueryDTO ratingQueryDTO = ratingQueryDTOOptional.get();
			tvShowDTO.setNoteAverage(ratingQueryDTO.getAverage());
			tvShowDTO.setVotes(ratingQueryDTO.getVotes());
		}

		return tvShowDTO;
	}

}
