package com.social.business;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.domain.Title;
import com.social.domain.TvShow;
import com.social.repository.MovieRepository;
import com.social.repository.TitleRepository;
import com.social.repository.TvShowRepository;

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
	public Object getTitleById(Long id){
		
		if (verifyTitleById(id).equalsIgnoreCase("Movie")){
			//TODO Trazer do banco para filme
		} else {
			//TODO Trazer do banco para série
		}
		
		return null;
	}

	private String verifyTitleById(Long id) {
		if(movieRepository.findOne(id) != null){
			return "Movie";
		} else {
			return "Série";
		}
	}
}
