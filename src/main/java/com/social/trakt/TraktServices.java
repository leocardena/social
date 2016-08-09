package com.social.trakt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import com.social.trakt.services.MovieAPIService;
import retrofit2.Retrofit;

@Component
public class TraktServices {
	
	@Autowired
	private Retrofit retrofit;
	
	@Bean
	public MovieAPIService getMovieAPIService() {
		return retrofit.create(MovieAPIService.class);
	}
	
}
