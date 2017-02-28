package com.social.repository.custom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.querydsl.jpa.impl.JPAQuery;
import com.social.domain.Episode;
import com.social.domain.QEpisode;
import com.social.domain.QSeason;
import com.social.domain.QTvShow;
import com.social.repository.custom.interfaces.EpisodeBulkOperations;
import com.social.repository.custom.interfaces.EpisodeRepositoryCustom;

public class EpisodeRepositoryImpl implements EpisodeBulkOperations, EpisodeRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	private Integer batchSize = 50;

	@Override
	@Transactional
	public <T extends Episode> Collection<T> bulkSave(Collection<T> entities) {
		final List<T> savedEntities = new ArrayList<T>(entities.size());
		int i = 0;
		for (T t : entities) {
			savedEntities.add(persistOrMerge(t));
			i++;
			if (i % batchSize == 0) {
				// Flush a batch of inserts and release memory.
				em.flush();
				em.clear();
			}
		}
		return savedEntities;
	}

	private <T extends Episode> T persistOrMerge(T t) {
		if (t.getIdEpisode() == null) {
			em.persist(t);
			return t;
		} else {
			return em.merge(t);
		}
	}

	@Override
	public Optional<Episode> findEpisodeByNumberSeasonAndTvShowSlug(Integer seasonNumber, String slug,
			Integer episodeNumber) {
		
		QEpisode episode = new QEpisode("e");
		QSeason season = new QSeason("s");
		QTvShow tvShow = new QTvShow("tv");

		Episode episodeResult = new JPAQuery<Episode>(em)
				.select(episode)
				.from(tvShow)
				.join(tvShow.season, season)
				.join(season.episodes, episode)
				.where(tvShow.slug.eq(slug))
				.where(season.number.eq(seasonNumber))
				.where(episode.number.eq(episodeNumber))
				.fetchOne();

		return Optional.ofNullable(episodeResult);
	}

}
