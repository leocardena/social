package com.social.rest.business;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysema.query.SearchResults;
import com.mysema.query.jpa.impl.JPAQuery;
import com.social.domain.Lists;
import com.social.domain.QLists;
import com.social.repository.ListsRepository;

@Service
public class ListsBusiness {

	@Autowired
	private EntityManager em;
	@Autowired
	private ListsRepository listsRepository;
	
	public List<Lists> getAllListByProfile(){

		JPAQuery query = new JPAQuery(em);
		
		SearchResults<Lists> searchList = query.from(QLists.lists)
				.where(QLists.lists.id.eq((long) 2))
				.listResults(QLists.lists);
		
		List<Lists> lista = searchList.getResults();

		System.out.println(lista.get(0).getId());
		System.out.println(lista.get(0).getName());
		
		return searchList.getResults();
		
	}
	
	public Page<Lists> getAllList(Integer pageCurrent, Integer pageSize){
		
		PageRequest pageRequest = new PageRequest(pageCurrent, pageSize);
		Page<Lists> page = listsRepository.findAll(pageRequest);
		
		List<Lists> lista = page.getContent();
		System.out.println(">>>>Total de paginas: "+page.getTotalPages());
		lista.forEach(listas->{
			System.out.println(">>>TAMANHO na pagina: "+lista.size());
			System.out.println(">>>ID: "+listas.getId());
			System.out.println(">>>Nome: "+listas.getName());
		});
				
		return page;
		
	}
	
	public void updateListsByProfile(){
		//TODO
	}
	
}
