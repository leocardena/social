package com.social.business;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysema.query.SearchResults;
import com.mysema.query.jpa.impl.JPAQuery;
import com.social.domain.QTvShow;
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
	
	public SearchResults<TvShow> getAllTvShowById(String name){
		List<TvShow> listaTvShow = tvShowRepository.findAll();
		TvShow tvShow = tvShowRepository.findOneByName(name);
		List<TvShow> lista = tvShowRepository.encontrarAlgum();
		
		System.out.println("size findAll() >>>> "+listaTvShow.size());
		System.out.println("name findAll() >>>> "+listaTvShow.get(0).getName());
		System.out.println("imdb findOneByName() >>>> "+tvShow.getImdb());
		System.out.println("size season findOneByName() >>>> "+tvShow.getSeason().size());
		
		System.out.println("size encontrarAlgum() >>>> "+lista.size());
		System.out.println("name encontrarAlgum() >>>> "+lista.get(0).getName());
		System.out.println("size season encontrarAlgum() >>>> "+lista.get(0).getSeason().size());
		
		/***********************************************************/
		/*COM O @QUERY NÃO ESTA TRAZENDO NEM A RELAÇÃO COM A SEASON*/
		/***********************************************************/
		tvShow.setId((long)1);
		JPAQuery query = new JPAQuery(em);
		SearchResults<TvShow> searchResult = query.from(QTvShow.tvShow)
				.where(QTvShow.tvShow.id.eq((long) 1))
				.listResults(QTvShow.tvShow);
		
		List<TvShow> listaDinamica = searchResult.getResults();
		
		System.out.println("size JPAQuery >>>> "+listaDinamica.size());
		System.out.println("name JPAQuery >>>> "+listaDinamica.get(0).getName());
		System.out.println("size season JPAQuery >>>> "+listaDinamica.get(0).getSeason().size());
		
		return null;
	}
	
}
