package com.social.trakt.business;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.social.retrofit.exception.RetrofitException;
import com.social.trakt.business.interfaces.ShowTraktAPIBusiness;
import com.social.trakt.model.FirstAired;
import com.social.trakt.model.Show;
import com.social.trakt.services.ShowTraktAPIService;
import com.social.web.rest.response.ResponseAPI;
import com.social.web.rest.util.PaginationUtil;

import retrofit2.Call;
import retrofit2.Response;

@Service
public class ShowTraktAPIBusinessImpl implements ShowTraktAPIBusiness {

	@Autowired
	private ShowTraktAPIService showAPIService;
	
	@Override
	public ResponseAPI<List<Show>> getPopularShows(String page, String limit, String extended, String query,
			String genres) {
		Call<List<Show>> call = showAPIService.getPopularShows(page, limit, extended, query, genres);
		Call<List<Show>> callClone = call.clone();
		Response<List<Show>> resp;
		try {
			resp = callClone.execute();
			if (!resp.isSuccessful())
				throw new RetrofitException("A resposta não foi bem sucedida");
			List<Show> show = resp.body();
			HttpHeaders headers = PaginationUtil.getHeadersFromTraktResponse(resp.headers());
			ResponseAPI<List<Show>> responseAPI = new ResponseAPI<>();
			responseAPI.setHeaders(headers);
			responseAPI.setBody(show);
			return responseAPI;
		} catch (IOException e) {
			throw new RetrofitException("Erro ao executar request através da API");
		}
	}
	
	@Override
	public Show getSummaryShow(String id, String extended) {
		Call<Show> call = showAPIService.getSummaryShow(id, extended);
		Call<Show> callClone = call.clone();
		Response<Show> resp;
		try {
			resp = callClone.execute();
			if (!resp.isSuccessful())
				throw new RetrofitException("A resposta não foi bem sucedida");
			return resp.body();
		} catch (IOException e) {
			throw new RetrofitException("Erro ao executar request através da API");
		}
	}
	
	@Override
	public List<Show> getShowTranslation(String id, String language, String extended) {
		Call<List<Show>> call = showAPIService.getShowTranslation(id, language, extended);
		Call<List<Show>> callClone = call.clone();
		Response<List<Show>> resp;
		try {
			resp = callClone.execute();
			if (!resp.isSuccessful())
				throw new RetrofitException("A resposta não foi bem sucedida");
			return resp.body();
		} catch (IOException e) {
			throw new RetrofitException("Erro ao executar request através da API");
		}
	}
	
	@Override
	public ResponseAPI<List<Show>> getRelatedShows(String id, String page, String limit, String extended) {
		Call<List<Show>> call = showAPIService.getRelatedShows(id, page, limit, extended);
		Call<List<Show>> callClone = call.clone();
		Response<List<Show>> resp;
		try {
			resp = callClone.execute();
			if (!resp.isSuccessful())
				throw new RetrofitException("A resposta não foi bem sucedida");
			List<Show> show = resp.body();
			HttpHeaders headers = PaginationUtil.getHeadersFromTraktResponse(resp.headers());
			ResponseAPI<List<Show>> responseAPI = new ResponseAPI<>();
			responseAPI.setHeaders(headers);
			responseAPI.setBody(show);
			return responseAPI;
		} catch (IOException e) {
			throw new RetrofitException("Erro ao executar request através da API");
		}
	}
	
	@Override
	public List<FirstAired> getAllShows(String start_date, int days, String extended, String query, String genres) {
		Call<List<FirstAired>> call = showAPIService.getAllShows(start_date, days, extended, query, genres);
		Call<List<FirstAired>> callClone = call.clone();
		Response<List<FirstAired>> resp;
		try {
			resp = callClone.execute();
			if (!resp.isSuccessful())
				throw new RetrofitException("A resposta não foi bem sucedida");
			return resp.body();
		} catch (IOException e) {
			throw new RetrofitException("Erro ao executar request através da API");
		}
	}
	
	@Override
	public List<FirstAired> getNewAllShows(String start_date, int days, String extended, String query, String genres) {
		Call<List<FirstAired>> call = showAPIService.getNewAllShows(start_date, days, extended, query, genres);
		Call<List<FirstAired>> callClone = call.clone();
		Response<List<FirstAired>> resp;
		try {
			resp = callClone.execute();
			if (!resp.isSuccessful())
				throw new RetrofitException("A resposta não foi bem sucedida");
			return resp.body();
		} catch (IOException e) {
			throw new RetrofitException("Erro ao executar request através da API");
		}
	}

}
