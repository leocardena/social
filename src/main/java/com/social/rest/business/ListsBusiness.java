package com.social.rest.business;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysema.query.SearchResults;
import com.mysema.query.jpa.impl.JPAQuery;
import com.social.domain.Lists;
import com.social.domain.QLists;

@Service
public class ListsBusiness {

	@Autowired
	private EntityManager em;
	
	public List<Lists> getAllListByProfile(){

		QLists qLists = QLists.lists;
		JPAQuery query = new JPAQuery(em);
		SearchResults<Lists> listaSearch = query.from(QLists.lists)
				.where(QLists.lists.profile.id.eq((long) 1))
				.listResults(qLists);
		
		List<Lists> lista = listaSearch.getResults();
		
		System.out.println("Total de registros que veio do banco usando Search Result>>>>"+listaSearch.getTotal());
		System.out.println("Total de registros que veio do banco usando List>>>>"+lista.size());
		System.out.println("Nome da primeira Lista >>>>"+lista.get(0).getName());
		System.out.println("Nome da segunda Lista >>>>"+lista.get(1).getName());
		System.out.println("Nome da primeira Lista >>>>"+lista.get(0).getProfile().getBirthday());
		System.out.println("Nome da segunda Lista >>>>"+lista.get(1).getProfile().getName());
		
		return lista;
		
	}
	
}
