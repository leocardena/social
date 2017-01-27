package com.social.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.social.domain.TvShow;

public interface TvShowRepository 
	extends JpaRepository<TvShow, Long>{

	TvShow findOneByName(String name);

	@Query("SELECT entity FROM TvShow entity WHERE entity.id = :id")
	public TvShow findOne(@Param(value="id") Long id);

	
	@Query(value = "SELECT * FROM TVSHOW t "
			+ "INNER JOIN SEASON s "
			+ "ON t.idTvShow = s.idTvShow "
			+ "INNER JOIN EPISODE e "
			+ "ON s.idSeason = e.idSeason", nativeQuery = true)
	List<TvShow> encontrarAlgum();
}
