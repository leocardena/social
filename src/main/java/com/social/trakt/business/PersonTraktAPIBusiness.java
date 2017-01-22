package com.social.trakt.business;

import org.springframework.security.access.prepost.PreAuthorize;
import com.social.trakt.model.Movie;
import com.social.trakt.model.MoviesPerson;
import com.social.trakt.model.Person;
import com.social.trakt.model.Show;
import com.social.trakt.model.ShowsPerson;

public interface PersonTraktAPIBusiness {
	
	@PreAuthorize("permitAll")
	public Person getSummaryPeople(String id, String extended);
	
	@PreAuthorize("permitAll")
	public MoviesPerson getMoviesPeople(String id, String extended);
	
	@PreAuthorize("permitAll")
	public ShowsPerson getShowsPeople(String id, String extended);
	
	@PreAuthorize("permitAll")
	public Movie getAllPeopleForAMovie(String id, String extended);
	
	@PreAuthorize("permitAll")
	public Show getAllPeopleForAShow(String id, String extended);

}
