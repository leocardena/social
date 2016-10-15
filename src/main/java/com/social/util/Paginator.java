package com.social.util;

import com.mysema.query.types.Path;

public class Paginator<T>{

	public Path<T> verificarPages(Integer pageCurrent, Integer pageSize){
	
        if ((pageCurrent == null || pageCurrent < 0) &&
        	(pageSize == null || pageSize == 0 || pageSize > 50)) {
        	pageCurrent = 0;
        	pageSize = 10;
        }
        
        return null;	
		
	}
	
}
