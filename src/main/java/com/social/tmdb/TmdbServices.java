package com.social.tmdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import com.social.tmdb.services.TmdbConfigurationService;
import retrofit2.Retrofit;

@Component
public class TmdbServices {

	@Autowired
	@Qualifier("TMDBBean")
	private Retrofit retrofit;

	@Bean
	public TmdbConfigurationService getTmdbConfigurationService() {
		return retrofit.create(TmdbConfigurationService.class);
	}

}
