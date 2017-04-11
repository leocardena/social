package com.social.repository.custom;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import com.querydsl.jpa.impl.JPAQuery;
import com.social.domain.Friend;
import com.social.domain.Profile;
import com.social.domain.QFriend;
import com.social.repository.custom.interfaces.FriendRepositoryCustom;
import com.social.util.FriendStatus;

public class FriendRepositoryImpl implements FriendRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Page<Friend> findAllFriends(FriendStatus status, Long profileId, Pageable pageable) {
		QFriend friend = QFriend.friend;
		
		JPAQuery<Friend> jpaQuery = new JPAQuery<Profile>(em).select(friend)
				.from(friend)
				.where(friend.id.profile.eq(profileId).or(friend.id.friend.eq(profileId)))
				.where(friend.status.eq(status));
		
		jpaQuery.offset(pageable.getOffset());
		jpaQuery.limit(pageable.getPageSize());
		List<Friend> friends = jpaQuery.fetch();
		
		if (friends == null) 
			friends = new ArrayList<>();
		
		long count = jpaQuery.fetchCount();

		return new PageImpl<Friend>(friends, pageable, count);
	}

}
