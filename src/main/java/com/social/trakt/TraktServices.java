package com.social.trakt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import com.social.trakt.services.EpisodeTraktAPIService;
import com.social.trakt.services.GenreTraktAPIService;
import com.social.trakt.services.MovieTraktAPIService;
import com.social.trakt.services.PersonTraktAPIService;
import com.social.trakt.services.SearchTraktAPIService;
import com.social.trakt.services.SeasonTraktAPIService;
import com.social.trakt.services.ShowTraktAPIService;
import retrofit2.Retrofit;

/**
 * Classe com estereótipo componente que será injetada nas classes da camada
 * business.
 * Utilizada para disponilizar todos os serviços da API do Trakt.tv
 * 
 * @author Leonardo Cardena
 *
 */
@Component
public class TraktServices {

	@Autowired
	@Qualifier("TraktTVBean")
	private Retrofit retrofit;

	@Bean
	public EpisodeTraktAPIService getEpisodeAPIService() {
		return retrofit.create(EpisodeTraktAPIService.class);
	}

	@Bean
	public GenreTraktAPIService getGenrePIService() {
		return retrofit.create(GenreTraktAPIService.class);
	}

	@Bean
	public MovieTraktAPIService getMovieAPIService() {
		return retrofit.create(MovieTraktAPIService.class);
	}

	@Bean
	public PersonTraktAPIService getPeopleAPIService() {
		return retrofit.create(PersonTraktAPIService.class);
	}

	@Bean
	public SeasonTraktAPIService getSeasonAPIService() {
		return retrofit.create(SeasonTraktAPIService.class);
	}

	@Bean
	public ShowTraktAPIService getShowAPIService() {
		return retrofit.create(ShowTraktAPIService.class);
	}

	@Bean
	public SearchTraktAPIService getSearchAPIService() {
		return retrofit.create(SearchTraktAPIService.class);
	}

}
