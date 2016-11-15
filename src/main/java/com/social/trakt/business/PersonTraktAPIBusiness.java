package com.social.trakt.business;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.retrofit.exception.RetrofitException;
import com.social.trakt.model.Movie;
import com.social.trakt.model.Person;
import com.social.trakt.model.Show;
import com.social.trakt.services.PersonTraktAPIService;

import retrofit2.Call;
import retrofit2.Response;

@Service
public class PersonTraktAPIBusiness {

	@Autowired
	PersonTraktAPIService peopleAPIService;

	public Person getSummaryPeople(String id, String extended) {
		Call<Person> call = peopleAPIService.getSummaryPeople(id, extended);
		Call<Person> callClone = call.clone();
		Response<Person> resp;
		try {
			resp = callClone.execute();
			if (!resp.isSuccessful())
				throw new RetrofitException("A resposta não foi bem sucedida");
			return resp.body();
		} catch (IOException e) {
			throw new RetrofitException("Erro ao executar request através da API");
		}
	}

	public List<Movie> getMoviesPeople(String id, String extended) {
		Call<List<Movie>> call = peopleAPIService.getMoviesPeople(id, extended);
		Call<List<Movie>> callClone = call.clone();
		Response<List<Movie>> resp;
		try {
			resp = callClone.execute();
			if (!resp.isSuccessful())
				throw new RetrofitException("A resposta não foi bem sucedida");
			return resp.body();
		} catch (IOException e) {
			throw new RetrofitException("Erro ao executar request através da API");
		}
	}

	public List<Show> getShowsPeople(String id, String extended) {
		Call<List<Show>> call = peopleAPIService.getShowsPeople(id, extended);
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

	public List<Person> getPeopleMovie(String id, String extended) {
		Call<List<Person>> call = peopleAPIService.getPeopleMovie(id, extended);
		Call<List<Person>> callClone = call.clone();
		Response<List<Person>> resp;
		try {
			resp = callClone.execute();
			if (!resp.isSuccessful())
				throw new RetrofitException("A resposta não foi bem sucedida");
			return resp.body();
		} catch (IOException e) {
			throw new RetrofitException("Erro ao executar request através da API");
		}
	}

	public List<Person> getPeopleShow(String id, String extended) {
		Call<List<Person>> call = peopleAPIService.getPeopleShow(id, extended);
		Call<List<Person>> callClone = call.clone();
		Response<List<Person>> resp;
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
