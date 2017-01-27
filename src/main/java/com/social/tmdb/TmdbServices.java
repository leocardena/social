package com.social.tmdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import com.social.tmdb.services.ConfigurationTmdbAPIService;
import com.social.tmdb.services.MovieTmdbAPIService;
import com.social.tmdb.services.PersonTmdbAPIService;
import com.social.tmdb.services.ShowTmdbAPIService;
import retrofit2.Retrofit;

/**
 * Classe com estereótipo componente que será injetada nas classes da camada
 * business. 
 * Utilizada para disponilizar todos os serviços da API do TMDB
 * 
 * @author Leonardo Cardena
 *
 */
@Component
public class TmdbServices {

	@Autowired
	@Qualifier("TMDBBean")
	private Retrofit retrofit;

	@Bean
	public ConfigurationTmdbAPIService getTmdbConfigurationService() {
		return retrofit.create(ConfigurationTmdbAPIService.class);
	}
	
	@Bean
	public MovieTmdbAPIService getMovieTmdbAPIService() {
		return retrofit.create(MovieTmdbAPIService.class);
	}
	
	@Bean
	public ShowTmdbAPIService getShowTmdbAPIService() {
		return retrofit.create(ShowTmdbAPIService.class);
	}
	
	@Bean
	public PersonTmdbAPIService getPersonTmdbAPIService() {
		return retrofit.create(PersonTmdbAPIService.class);
	}

}
