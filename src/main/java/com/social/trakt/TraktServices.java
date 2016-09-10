package com.social.trakt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.social.trakt.services.EpisodeAPIService;
import com.social.trakt.services.GenreAPIService;
import com.social.trakt.services.MovieAPIService;
import com.social.trakt.services.PeopleAPIService;
import com.social.trakt.services.SeasonAPIService;
import com.social.trakt.services.ShowAPIService;

import retrofit2.Retrofit;

@Component
public class TraktServices {

	@Autowired
	private Retrofit retrofit;

	@Bean
	public EpisodeAPIService getEpisodeAPIService() {
		return retrofit.create(EpisodeAPIService.class);
	}

	@Bean
	public GenreAPIService getGenrePIService() {
		return retrofit.create(GenreAPIService.class);
	}

	@Bean
	public MovieAPIService getMovieAPIService() {
		return retrofit.create(MovieAPIService.class);
	}

	@Bean
	public PeopleAPIService getPeopleAPIService() {
		return retrofit.create(PeopleAPIService.class);
	}

	@Bean
	public SeasonAPIService getSeasonAPIService() {
		return retrofit.create(SeasonAPIService.class);
	}

	@Bean
	public ShowAPIService getShowAPIService() {
		return retrofit.create(ShowAPIService.class);
	}
}
