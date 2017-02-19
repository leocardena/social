package com.social.repository.custom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import com.social.domain.Episode;
import com.social.repository.custom.interfaces.EpisodeBulkOperations;

public class EpisodeRepositoryImpl implements EpisodeBulkOperations {

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

}
