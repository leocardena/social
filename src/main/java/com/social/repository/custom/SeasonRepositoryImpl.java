package com.social.repository.custom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import com.querydsl.jpa.impl.JPAQuery;
import com.social.domain.QSeason;
import com.social.domain.QTvShow;
import com.social.domain.Season;
import com.social.repository.custom.interfaces.SeasonBulkOperations;
import com.social.repository.custom.interfaces.SeasonRepositoryCustom;

public class SeasonRepositoryImpl implements SeasonBulkOperations, SeasonRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	private Integer batchSize = 5;

	@Override
	@Transactional
	public <T extends Season> Collection<T> bulkSave(Collection<T> entities) {
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

	private <T extends Season> T persistOrMerge(T t) {
		if (t.getIdSeason() == null) {
			em.persist(t);
			return t;
		} else {
			return em.merge(t);
		}
	}

	@Override
	public Optional<Season> findSeasonByNumberAndTvShowSlug(Integer seasonNumber, String slug) {

		QSeason season = QSeason.season;
		QTvShow tvShow = QTvShow.tvShow;

		Season seasonResult = new JPAQuery<Season>(em)
				.from(season, tvShow)
				.where(tvShow.slug.eq(slug)
						.and(season.number.eq(seasonNumber)))
				.fetchOne();

		return Optional.ofNullable(seasonResult);
	}

}
