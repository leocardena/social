package com.social.rest.business;


import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysema.query.jpa.impl.JPAQuery;
import com.social.domain.Lists;
import com.social.domain.QLists;
import com.social.domain.QTitle;
import com.social.domain.Title;
import com.social.repository.ProfileRepository;
import com.social.repository.UserRepository;

@Service
public class ListsBusiness {

	@Autowired
	private EntityManager em;
	@Autowired
	private ProfileRepository profileRepository;
	@Autowired
	private UserRepository userRepository;
	
	public Lists getAllListProfile(){

		QLists qLists = QLists.lists;
		JPAQuery query = new JPAQuery(em).from(qLists);
		Lists t = query.singleResult(qLists);
		
		System.out.println(">>>>>>>"+t.getTitle().size());
		System.out.println(">>>>>>>"+t.getTitle().get(0).getName());
		System.out.println(">>>>>>>"+t.getTitle().get(1).getName());
		
		return query.singleResult(qLists);
		
	}
	
}
