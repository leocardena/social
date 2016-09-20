package com.social.rest.business;


import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysema.query.jpa.impl.JPAQuery;
import com.social.domain.Profile;
import com.social.domain.QLists;
import com.social.domain.QProfile;
import com.social.domain.QTitle;
import com.social.domain.QUser;
import com.social.domain.User;
import com.social.repository.ProfileRepository;
import com.social.rest.exception.NoListFound;

@Service
public class ListsBusiness {

	@Autowired
	private EntityManager em;
	@Autowired
	private ProfileRepository profileRepository;
	
	public Profile getAllListProfile(){

		QUser qUser = QUser.user;
		QProfile qProfile = QProfile.profile;
		QLists qLists = QLists.lists;
		QTitle qTitle = QTitle.title;
		
		JPAQuery query = new JPAQuery(em).from(qProfile);
		
		System.out.println(">>>>>>>"+query.singleResult(qProfile));
				
		return query.singleResult(qProfile);
		
	}
	
}
