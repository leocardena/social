package com.social.rest.business;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.domain.Lists;

@Service
public class ListsBusiness {

	@Autowired
	private EntityManager em;
	
	public List<Lists> getAllListByProfile(){

		//QLists qLists = QLists.lists;
		
		return null;
		
	}
	
}
