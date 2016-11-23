package com.social.web.rest.util;

import org.springframework.http.HttpHeaders;
import okhttp3.Headers;

public class PaginationUtil {
	
	
	public static HttpHeaders getHeadersFromTraktResponse(Headers headers) {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("X-Pagination-Item-Count", headers.get("X-Pagination-Item-Count"));
		responseHeaders.add("X-Pagination-Limit", headers.get("X-Pagination-Limit"));
		responseHeaders.add("X-Pagination-Page", headers.get("X-Pagination-Page"));
		responseHeaders.add("X-Pagination-Page-Count", headers.get("X-Pagination-Page-Count"));	
		
		return responseHeaders; 
	}
	
	public static HttpHeaders getHeadersFromTMDBResponse(Integer page, Integer totalResults, Integer totalPages) {
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("X-Pagination-Item-Count", totalResults.toString());
		responseHeaders.add("X-Pagination-Page", page.toString());
		responseHeaders.add("X-Pagination-Page-Count", totalPages.toString());	
		
		return responseHeaders;
	}
	
}
