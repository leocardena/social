package com.social.repository.querydsl.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.querydsl.jpa.impl.JPAQuery;
import com.social.domain.QProfile;
import com.social.domain.QRating;
import com.social.domain.Rating;
import com.social.repository.querydsl.interfaces.RatingQuerydsl;

public class RatingQuerydslImpl implements RatingQuerydsl {
	
	@PersistenceContext
    private EntityManager em;

}
