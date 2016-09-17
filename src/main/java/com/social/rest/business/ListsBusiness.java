package com.social.rest.business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public List<User> getAllListProfile(){
		List<User> list = new ArrayList<>();
			
		QUser qUser = QUser.user;
		QProfile qProfile = QProfile.profile;
		QLists qLists = QLists.lists;
		QTitle qTitle = QTitle.title;
		
		if (list.isEmpty())
			throw new NoListFound("Voçê não tem series adicionadas a lista.");
		
		return list;
		
	}
	
}
