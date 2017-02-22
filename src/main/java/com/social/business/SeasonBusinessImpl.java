package com.social.business;

import java.util.Optional;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.social.business.interfaces.SeasonBusiness;
import com.social.domain.Season;
import com.social.repository.RatingRepository;
import com.social.repository.SeasonRepository;
import com.social.web.rest.dto.RatingDTO;
import com.social.web.rest.dto.SeasonDTO;
import com.social.web.rest.exception.ResourceNotFoundException;

@Service
public class SeasonBusinessImpl implements SeasonBusiness {

	@Autowired
	private SeasonRepository seasonRepository;

	@Autowired
	private RatingRepository ratingRepository;

	@Override
	public SeasonDTO getSeason(Integer seasonNumber, String showId) {
		Optional<Season> seasonOptional = seasonRepository
				.findSeasonByNumberAndTvShowSlug(seasonNumber, showId);

		if (!seasonOptional.isPresent())
			throw new ResourceNotFoundException("Season nao encontrada");

		Season season = seasonOptional.get();
		SeasonDTO seasonDTO = new SeasonDTO();
		seasonDTO.setAired(season.getAired().toString(DateTimeFormat.forPattern("dd/MM/yyyy")));
		seasonDTO.setId(season.getIdSeason());
		seasonDTO.setIdTvShow(season.getTvShow());
		seasonDTO.setName(season.getName());
		seasonDTO.setNumber(season.getNumber());
		
		RatingDTO ratingDTO = new RatingDTO();
		ratingDTO.setIdRatingParent(season.getRatingParent() != null ? season.getRatingParent().getId() : null);

		Optional<RatingDTO> ratingQueryDTOOptional = ratingRepository
				.averageAndVotesByIdRatingParent(season.getRatingParent().getId());
		
		if (ratingQueryDTOOptional.isPresent()) {
			RatingDTO ratingDTODb = ratingQueryDTOOptional.get();
			ratingDTO.setAverage(ratingDTODb.getAverage());
			ratingDTO.setVotes(ratingDTODb.getVotes());
		}
		
		seasonDTO.setRating(ratingDTO);
		
		return seasonDTO;
	}

}
