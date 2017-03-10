package com.social.business;

import java.util.Optional;

import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.social.business.interfaces.EpisodeBusiness;
import com.social.domain.Episode;
import com.social.repository.EpisodeRepository;
import com.social.repository.RatingRepository;
import com.social.web.rest.dto.EpisodeDTO;
import com.social.web.rest.dto.RatingDTO;
import com.social.web.rest.exception.ResourceNotFoundException;

@Service
public class EpisodeBusinessImpl implements EpisodeBusiness {

	@Autowired
	private RatingRepository ratingRepository;

	@Autowired
	private EpisodeRepository episodeRepository;

	@Override
	public EpisodeDTO getEpisode(Integer seasonNumber, String showId, Integer episodeNumber) {
		Optional<Episode> episodeOptional = episodeRepository.findEpisodeByNumberSeasonAndTvShowSlug(seasonNumber, showId,
				episodeNumber);

		if (!episodeOptional.isPresent())
			throw new ResourceNotFoundException("Season nao encontrada");

		Episode episode = episodeOptional.get();
		EpisodeDTO episodeDTO = new EpisodeDTO();
		episodeDTO.setAired(episode.getAired().toString(DateTimeFormat.forPattern("dd/MM/yyyy")));
		episodeDTO.setIdEpisode(episode.getIdEpisode());
		episodeDTO.setName(episode.getName());
		episodeDTO.setNumber(episodeDTO.getNumber());
		episodeDTO.setSeason(episode.getSeason());

		RatingDTO ratingDTO = new RatingDTO();
		
		if (episode.getRatingParent() != null) {
			ratingDTO.setIdRatingParent(episode.getRatingParent().getId());
			
			Optional<RatingDTO> ratingQueryDTOOptional = ratingRepository
					.averageAndVotesByIdRatingParent(episode.getRatingParent().getId());

			if (ratingQueryDTOOptional.isPresent()) {
				RatingDTO ratingDTODb = ratingQueryDTOOptional.get();
				ratingDTO.setAverage(ratingDTODb.getAverage());
				ratingDTO.setVotes(ratingDTODb.getVotes());
			}
			
		}

		episodeDTO.setRating(ratingDTO);

		return episodeDTO;
	}

}
