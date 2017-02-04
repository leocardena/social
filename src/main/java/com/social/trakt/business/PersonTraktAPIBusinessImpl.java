package com.social.trakt.business;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.social.retrofit.exception.RetrofitException;
import com.social.trakt.business.interfaces.PersonTraktAPIBusiness;
import com.social.trakt.model.Movie;
import com.social.trakt.model.MoviesPerson;
import com.social.trakt.model.Person;
import com.social.trakt.model.PersonCrew;
import com.social.trakt.model.Show;
import com.social.trakt.model.ShowsPerson;
import com.social.trakt.services.PersonTraktAPIService;
import retrofit2.Call;
import retrofit2.Response;

@Service
public class PersonTraktAPIBusinessImpl implements PersonTraktAPIBusiness {

	@Autowired
	PersonTraktAPIService peopleAPIService;
	
	@Override
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
	
	@Override
	public MoviesPerson getMoviesPeople(String id, String extended) {
		Call<MoviesPerson> call = peopleAPIService.getMoviesPeople(id, extended);
		Call<MoviesPerson> callClone = call.clone();
		Response<MoviesPerson> resp;
		try {
			resp = callClone.execute();
			if (!resp.isSuccessful())
				throw new RetrofitException("A resposta não foi bem sucedida");
			
			MoviesPerson moviesPerson = resp.body();
			if (moviesPerson.getCrew() == null) 
				moviesPerson.setCrew(new PersonCrew(new ArrayList<>()));
			
			return moviesPerson;
		} catch (IOException e) {
			throw new RetrofitException("Erro ao executar request através da API");
		}
	}
	
	@Override
	public ShowsPerson getShowsPeople(String id, String extended) {
		Call<ShowsPerson> call = peopleAPIService.getShowsPeople(id, extended);
		Call<ShowsPerson> callClone = call.clone();
		Response<ShowsPerson> resp;
		try {
			resp = callClone.execute();
			if (!resp.isSuccessful())
				throw new RetrofitException("A resposta não foi bem sucedida");
			
			ShowsPerson showsPerson = resp.body();
			
			if (showsPerson.getCrew() == null)
				showsPerson.setCrew(new PersonCrew(new ArrayList<>()));
			
			return showsPerson;
		} catch (IOException e) {
			throw new RetrofitException("Erro ao executar request através da API");
		}
	}
	
	@Override
	public Movie getAllPeopleForAMovie(String id, String extended) {
		Call<Movie> call = peopleAPIService.getAllPeopleForAMovie(id, extended);
		Call<Movie> callClone = call.clone();
		Response<Movie> resp;
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
	public Show getAllPeopleForAShow(String id, String extended) {
		Call<Show> call = peopleAPIService.getAllPeopleForAShow(id, extended);
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

}