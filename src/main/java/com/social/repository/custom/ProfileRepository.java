package com.social.repository.custom;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.querydsl.jpa.impl.JPAQuery;
import com.social.domain.Profile;
import com.social.domain.QProfile;
import com.social.repository.custom.interfaces.ProfileRepositoryCustom;

public class ProfileRepository implements ProfileRepositoryCustom {

	@PersistenceContext
    private EntityManager em;
	
	@Override
	public List<Profile> getProfileLikeUsername(String username) {
		
		QProfile profile = QProfile.profile;
		
		return new JPAQuery<Profile>(em).select(profile)
				.from(profile)
				.where(profile.user.username.like(username))
				.fetch();
		
	}

}
