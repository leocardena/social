package com.social.trakt.business;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.social.retrofit.exception.RetrofitException;
import com.social.trakt.business.interfaces.SearchTraktAPIBusiness;
import com.social.trakt.model.Search;
import com.social.trakt.services.SearchTraktAPIService;
import com.social.web.rest.response.ResponseAPI;
import com.social.web.rest.util.PaginationUtil;
import retrofit2.Call;
import retrofit2.Response;

@Service
public class SearchTraktAPIBusinessImpl implements SearchTraktAPIBusiness {

	@Autowired
	private SearchTraktAPIService searchAPIService;
	
	@Override
	public ResponseAPI<List<Search>> getSearch(String type, String page, String limit, 
			String extended, String query, String fields) {
		Call<List<Search>> call = searchAPIService.getSearch(type, page, limit, extended, query, fields);
		Call<List<Search>> callClone = call.clone();
		Response<List<Search>> resp;
		try {
			resp = callClone.execute();
			if (!resp.isSuccessful())
				throw new RetrofitException("A resposta não foi bem sucedida");
			List<Search> searchs = resp.body();
			HttpHeaders headers = PaginationUtil.getHeadersFromTraktResponse(resp.headers());
			ResponseAPI<List<Search>> responseAPI = new ResponseAPI<>();
			responseAPI.setHeaders(headers);
			responseAPI.setBody(searchs);
			return responseAPI;
		} catch (IOException e) {
			throw new RetrofitException("Erro ao executar request através da API");
		}
	}

}
