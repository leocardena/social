package com.social.business;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.domain.Episode;
import com.social.domain.Lists;
import com.social.domain.Movie;
import com.social.domain.Profile;
import com.social.domain.Season;
import com.social.domain.TvShow;
import com.social.repository.MovieRepository;
import com.social.repository.TitleRepository;
import com.social.repository.TvShowRepository;

@Service
public class TvShowBusiness {

	@Autowired
	private EntityManager em;
	@Autowired
	private TitleRepository titleRepository;
	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private TvShowRepository tvShowRepository;
	
	public void getAllTvShowById(String name){
//		List<TvShow> listaTvShow = tvShowRepository.findAll();
//		TvShow tvShowName = tvShowRepository.findOneByName(name);
//		TvShow tvShowId = tvShowRepository.findOne(Long.valueOf(1));
//		List<TvShow> lista = tvShowRepository.encontrarAlgum();
		
//		System.out.println("size findAll() >>>> "+listaTvShow.size());
//		System.out.println("name findAll() >>>> "+listaTvShow.get(0).getName());
//		System.out.println("imdb findOneByName() >>>> "+tvShowName.getImdb());
//		System.out.println("size season findOneByName() >>>> "+tvShowName.getSeason().size());
//		System.out.println("name findOne() >>>> "+tvShowId.getName());
//		System.out.println("name findOne() >>>> "+tvShowId.getSeason().size());
//		
//		System.out.println("size INNER JOIN >>>> "+lista.size());
//		System.out.println("name INNER JOIN >>>> "+lista.get(0).getName());
//		System.out.println("name INNER JOIN >>>> "+lista.get(1).getName());
//		System.out.println("size season INNER JOIN >>>> "+lista.get(0).getSeason().size());
		
		/***********************************************************/
		/*COM O @QUERY NÃO ESTA TRAZENDO NEM A RELAÇÃO COM A SEASON*/
		/***********************************************************/
//		tvShowName.setId((long)1);
//		JPAQuery query = new JPAQuery(em);
//		SearchResults<TvShow> searchResultTvShow = query.from(QTvShow.tvShow)
//				.where(QTvShow.tvShow.id.eq(tvShowName.getId()))
//				.listResults(QTvShow.tvShow);
		
//		SearchResults<Season> searchResultSeason = query.from(QSeason.season)
//				.where(QSeason.season.tvShow.id.eq(tvShowName.getId()))
//				.listResults(QSeason.season);
		
//		SearchResults<Episode> searchResultsEpisodes = query.from(QEpisode.episode)
//				.where(QEpisode.episode.id.eq((long)1))
//				.listResults(QEpisode.episode);
		
//		SearchResults<Profile> searchResultsProfile = query.from(QProfile.profile)
//				.where(QProfile.profile.id.eq((long)1))
//				.listResults(QProfile.profile);
		
//		SearchResults<Lists> searchResultsLists = query.from(QLists.lists)
//				.where(QLists.lists.id.eq((long)1))
//				.listResults(QLists.lists);
		
//		SearchResults<Movie> searchResultsMovie = query.from(QMovie.movie)
//				.where(QMovie.movie.name.contains("rs"))
//				.listResults(QMovie.movie);
		
//		List<TvShow> listaDinamicaTvShow = searchResultTvShow.getResults();
//		List<Season> listaDinamicaSeason = searchResultSeason.getResults();
//		List<Episode> listaDinamicaEpisode = searchResultsEpisodes.getResults();
//		List<Profile> listaDinamicaProfile = searchResultsProfile.getResults();
//		List<Lists> listaDinamicaLists = searchResultsLists.getResults();
//		List<Movie> listaDinamicaMovie = searchResultsMovie.getResults();
		
//		System.out.println("TVSHOW size JPAQuery >>>> "+listaDinamicaTvShow.size());
//		System.out.println("TVSHOW name JPAQuery >>>> "+listaDinamicaTvShow.get(0).getName());
//		System.out.println("TVSHOW size season JPAQuery >>>> "+listaDinamicaTvShow.get(0).getSeason().size());
		
//		System.out.println("SEASON size JPAQuery >>>> "+listaDinamicaSeason.size());
//		System.out.println("SEASON name JPAQuery >>>> "+listaDinamicaSeason.get(0).getName());
//		System.out.println("SEASON size episode JPAQuery >>>> "+listaDinamicaSeason.get(0).getEpidodes().size());
		
//		System.out.println("EPISODE size JPAQuery >>>> "+listaDinamicaEpisode.size());
//		System.out.println("EPISODE name JPAQuery >>>> "+listaDinamicaEpisode.get(0).getName());
//		System.out.println("EPISODE size season JPAQuery >>>> "+listaDinamicaEpisode.get(0).getSeason());
		
//		System.out.println("PROFILE size JPAQuery >>>> "+listaDinamicaProfile.size());
//		System.out.println("PROFILE name JPAQuery >>>> "+listaDinamicaProfile.get(0).getName());
//		System.out.println("PROFILE email user JPAQuery >>>> "+listaDinamicaProfile.get(0).getUser().getEmail());
		
//		System.out.println("LISTS size JPAQuery >>>> "+listaDinamicaLists.size());
//		System.out.println("LISTS name JPAQuery >>>> "+listaDinamicaLists.get(0).getName());
//		System.out.println("LISTS size season JPAQuery >>>> "+listaDinamicaLists.get(0).getProfile().getName());
		
//		System.out.println("MOVIE size JPAQuery >>>> "+listaDinamicaMovie.size());
//		System.out.println("MOVIE name JPAQuery >>>> "+listaDinamicaMovie.get(0).getName());
//		System.out.println("MOVIE id JPAQuery   >>>> "+listaDinamicaMovie.get(0).getId());
//		System.out.println("MOVIE id Comment Parent JPAQuery >>>> "+listaDinamicaMovie.get(0).getCommentParent().getId());
//		System.out.println("MOVIE id Rating Parent JPAQuery >>>> "+listaDinamicaMovie.get(0).getRatingParent().getId());
		
//		return null;
	}
	
}
