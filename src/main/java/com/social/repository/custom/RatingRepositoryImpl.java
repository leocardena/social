package com.social.repository.custom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.social.repository.custom.interfaces.RatingRepositoryCustom;

public class RatingRepositoryImpl implements RatingRepositoryCustom {
	
	@PersistenceContext
    private EntityManager em;

}
