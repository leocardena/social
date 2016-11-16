package com.social.business;

import static org.mockito.Matchers.matches;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysema.query.SearchResults;
import com.mysema.query.jpa.impl.JPAQuery;
import com.social.domain.Episode;
import com.social.domain.Movie;
import com.social.domain.QMovie;
import com.social.domain.QTvShow;
import com.social.domain.Season;
import com.social.domain.Title;
import com.social.domain.TvShow;
import com.social.repository.MovieRepository;
import com.social.repository.TitleRepository;
import com.social.repository.TvShowRepository;

import ch.qos.logback.core.net.SyslogOutputStream;

@Service
public class TitleBusiness {

	@Autowired
	private EntityManager em;
	@Autowired
	private TitleRepository titleRepository;
	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private TvShowRepository tvShowRepository;
	
	/**
	 * Método para retornar uma Série ou um Filme para tela inicial do Titulo
	 * @return TvShow ou Movie
	 */
	public SearchResults<Object> getTitleById(Long id){
		
		JPAQuery query = new JPAQuery(em);
		System.out.println("ID>>"+id);
		if (verifyTitleById(id).equals("Movie")){
			System.out.println("if");
			SearchResults<Movie> searchResult = query.from(QMovie.movie)
							.where(QMovie.movie.id.eq(id))
							.listResults(QMovie.movie);
		} else {
			SearchResults<TvShow> searchResult = query.from(QTvShow.tvShow)
					.where(QTvShow.tvShow.id.eq(id))
					.listResults(QTvShow.tvShow);
			/*VERIFICAR O MAPEAMENTO DO RATING NA SEASON*/
			System.out.println(searchResult.getResults().get(0).getSeason().get(0).getEpidodes().get(0).getName());
		}
		System.out.println("nenhum if");
		return null;
	}

	private String verifyTitleById(Long id) {
		if(movieRepository.findOne(id) != null){
			return "Movie";
		} else {
			return "Série";
		}
	}
	
	public void insertTest(){
		
		/**
		 * VERIFICAR A ASSOCIACAO DA SEASON COM TVSHOW VER SE SO AQUI ELE SALVA NO BANCO EM TODAS AS TABLES
		 */
		TvShow tvShow = new TvShow();
		Season season = new Season();
		List<Season> listaSeasons = new ArrayList<Season>();
		Episode episode = new Episode();
		List<Episode> listaEpisodios = new ArrayList<Episode>();
		
		episode.setName("Segundo Episodio teste");
		episode.setVotes(2);
		episode.setSeason(season);
		episode.setCommentParent(null);
		episode.setRatingParent(null);
		listaEpisodios.add(episode);
		episode.setName("Primeiro Episodio teste");
		episode.setVotes(10);
		episode.setSeason(season);
		episode.setCommentParent(null);
		episode.setRatingParent(null);
		listaEpisodios.add(episode);
		
		season.setName("Primeira temporada Teste");
		season.setTvShow(null);
		season.setCommentParent(null);
		season.setRatingParent(null);
		season.setEpidodes(listaEpisodios);		
		listaSeasons.add(season);
				
		tvShow.setImdb("1234567890");
		tvShow.setSeason(listaSeasons);
		tvShow.setTrailer(" ");
		tvShow.setVotes(0);
		tvShow.setHomePage(" ");
		tvShow.setName("TesteInserção");
		tvShow.setCommentParent(null);
		tvShow.setRatingParent(null);
		
		tvShowRepository.save(tvShow);
	}
}
