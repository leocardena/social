package com.social.business;

import static org.mockito.Matchers.matches;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.domain.Episode;
import com.social.domain.Season;
import com.social.domain.TvShow;
import com.social.repository.TvShowRepository;

@Service
public class TitleBusiness {

	@Autowired
	private TvShowRepository tvShowRepository;

	public void insertTest(){
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
