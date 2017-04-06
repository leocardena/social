package com.social.repository.custom;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQuery;
import com.social.domain.Profile;
import com.social.domain.QProfile;
import com.social.repository.custom.interfaces.ProfileRepositoryCustom;

public class ProfileRepositoryImpl implements ProfileRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Page<Profile> getProfileLikeUsername(String username, Pageable pageable) {

		QProfile profile = QProfile.profile;

		JPAQuery<Profile> jpaQuery = new JPAQuery<Profile>(em).select(profile).from(profile)
				.where(profile.user.username.like(Expressions.asString("%").concat(username).concat("%")));

		jpaQuery.offset(pageable.getOffset());
		jpaQuery.limit(pageable.getPageSize());

		List<Profile> profiles = jpaQuery.fetch();
		if (profiles == null) 
			profiles = new ArrayList<>();
		
		long count = jpaQuery.fetchCount();

		return new PageImpl<Profile>(profiles, pageable, count);
	}

}
