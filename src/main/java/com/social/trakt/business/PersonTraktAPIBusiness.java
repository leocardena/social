package com.social.trakt.business;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import com.social.trakt.model.Movie;
import com.social.trakt.model.Person;
import com.social.trakt.model.Show;

public interface PersonTraktAPIBusiness {
	
	@PreAuthorize("permitAll")
	public Person getSummaryPeople(String id, String extended);
	
	@PreAuthorize("permitAll")
	public List<Movie> getMoviesPeople(String id, String extended);
	
	@PreAuthorize("permitAll")
	public List<Show> getShowsPeople(String id, String extended);
	
	@PreAuthorize("permitAll")
	public List<Person> getPeopleMovie(String id, String extended);
	
	@PreAuthorize("permitAll")
	public List<Person> getPeopleShow(String id, String extended);

}
