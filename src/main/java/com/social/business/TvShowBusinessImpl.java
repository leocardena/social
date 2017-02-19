package com.social.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.business.interfaces.TvShowBusiness;
import com.social.domain.CommentParent;
import com.social.domain.Episode;
import com.social.domain.RatingParent;
import com.social.domain.Season;
import com.social.domain.TvShow;
import com.social.repository.CommentParentRepository;
import com.social.repository.EpisodeRepository;
import com.social.repository.RatingParentRepository;
import com.social.repository.RatingRepository;
import com.social.repository.SeasonRepository;
import com.social.repository.TvShowRepository;
import com.social.trakt.business.interfaces.SeasonTraktAPIBusiness;
import com.social.web.rest.dto.RatingDTO;
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

	@Autowired
	private SeasonTraktAPIBusiness seasonTraktAPIBusiness;

	@Autowired
	private SeasonRepository seasonRepository;
	
	@Autowired
	private EpisodeRepository episodeRepository;

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

		tvShow = tvShowRepository.saveAndFlush(tvShow);
		
		List<com.social.trakt.model.Season> traktSeasons = seasonTraktAPIBusiness.getSummarySeason(showId, "full,episodes");
		
		final Long idTvShow = tvShow.getId();
		List<Episode> episodesToSave = new ArrayList<>();
		traktSeasons.forEach(s -> {
			Season seasonSalva = seasonRepository.saveAndFlush(new Season().createFrom(s, idTvShow));
			
			s.getEpisodes().forEach(e -> {
				episodesToSave.add(new Episode().createFrom(e, seasonSalva.getIdSeason()));
			});
			
		});
		
		episodeRepository.bulkSave(episodesToSave);
		
		return tvShow;
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

		Optional<RatingDTO> ratingQueryDTOOptional = ratingRepository
				.averageAndVotesByIdRatingParent(tvShow.getRatingParent().getId());
		
		if (ratingQueryDTOOptional.isPresent()) {
			RatingDTO ratingDTO = ratingQueryDTOOptional.get();
			tvShowDTO.setRating(ratingDTO);
		} else {
			tvShowDTO.setRating(new RatingDTO());
		}

		return tvShowDTO;
	}

}
