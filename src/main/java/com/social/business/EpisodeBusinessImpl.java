package com.social.business;

import org.springframework.stereotype.Service;
import com.social.business.interfaces.EpisodeBusiness;
import com.social.web.rest.dto.EpisodeDTO;

@Service
public class EpisodeBusinessImpl implements EpisodeBusiness {

	@Override
	public EpisodeDTO getEpisode(Integer seasonNumber, String showId, Integer episodeNumber) {
		// TODO Auto-generated method stub
		return null;
	}

}
