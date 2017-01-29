package com.social.business;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.social.domain.Movie;
import com.social.domain.Profile;
import com.social.domain.QMovie;
import com.social.domain.QProfile;
import com.social.domain.QRating;
import com.social.domain.Rating;
import com.social.domain.User;
import com.social.repository.MovieRepository;
import com.social.repository.ProfileRepository;
import com.social.repository.RatingRepository;
import com.social.repository.UserRepository;

import ch.qos.logback.core.net.SyslogOutputStream;

@Service
public class MovieBusinessImpl implements MovieBusiness {

	@Autowired
	private EntityManager entity;
	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private RatingRepository ratingRepository;
	@Autowired	
	private ProfileRepository profileRepository;
	@Autowired	
	private UserRepository userRepository;
	
	@Override
	public List<Movie> getAllMovies(){
		return movieRepository.findAll();
	}
		
	@Override
	public Movie getMovieById(String slug){

//		String username = "pepeu";
//		List<Movie> resultMovie = movieRepository.getMovieBySlugAndUser();
//		Profile profileResult = profileRepository.findOneByName("Pedro Afonso");
//		Movie resultMovie = movieRepository.findOneById(1L);
//		Optional<User> user = userRepository.findOneById(1L);
		
//		JPAQueryFactory query = new JPAQueryFactory(entity);
//		List<Profile> resultMovie = query.selectFrom(QProfile.profile)
//				.fetch();
		
		JPAQueryFactory query = new JPAQueryFactory(entity);
		List<Rating> resultRating = query.selectFrom(QRating.rating)
				.fetch();
				

		System.out.println("Total: "+resultRating.size());
//		System.out.println("Nome do filme: "+resultMovie.get(0).getName());
//		System.out.println("Total votos do filme: "+resultMovie.get(0).getVotes());
//		System.out.println("Id Rating: "+resultMovie.get(0).getRatingParent().getId());
//		System.out.println("Username: "+resultMovie.get(0).getRatingParent().getRating().getProfile().getUser().getUsername());
//		System.out.println("Nota para o filme: "+resultMovie.get(0).getRatingParent().getRating().getNote());
//		System.out.println("Nome da pessoa: "+resultMovie.get(0).getRatingParent().getRating().getProfile().getName());
				
		resultRating.forEach((rating) -> {
			System.out.println("--------------------------------------------------");
			System.out.println("ITERATOR user username: "+rating.getId());
			System.out.println("ITERATOR profile name: "+rating.getIdRatingParent().getId());
//			System.out.println("ITERATOR profile id: "+rating.getProfiles());
//			profile.getRatings().forEach((rating) -> {
//				System.out.println("	ITERATOR rating id: "+rating.getId());
//				System.out.println("	ITERATOR ratingParent id: "+rating.getIdRatingParent().getId());
//			});			
			
//			System.out.println("ITERATOR pessoa id: "+profile.getRatingParent().getRating().getProfile().getId());
//			System.out.println("ITERATOR pessoa name: "+profile.getRatingParent().getRating().getProfile().getName());
//			System.out.println("ITERATOR rating id: "+profile.getRatingParent().getRating().getId());
//			System.out.println("ITERATOR rating idRatingParent: "+profile.getRatingParent().getId());
			System.out.println("--------------------------------------------------");
		});
		
//		System.out.println("Total votos do filme: "+user.get().getUsername());
//		System.out.println("Total votos do filme: "+resultMovie.getVotes());
//		System.out.println("Nome do filme: "+resultMovie.getName());
//		System.out.println("Id Rating: "+resultMovie.getRatingParent().getId());
//		System.out.println("Username: "+resultMovie.getRatingParent().getRating().getProfile().getUser().getUsername());
//		System.out.println("Nota para o filme: "+resultMovie.getRatingParent().getRating().getNote());
//		System.out.println("Nome da pessoa: "+resultMovie.getRatingParent().getRating().getProfile().getName());
//		System.out.println("Nome do filme: "+resultMovie.getName());
//		System.out.println("-------------------------------------");
//		System.out.println("Nome do profile: "+profileResult.getName());
		
		return new Movie();
	}

	@Override
	public Movie getMovieByName(String name){
		//VERIFICAR JPAQueryFactory para JPAQuery (diference)
		JPAQueryFactory query = new JPAQueryFactory(entity);
		
		Movie result = query.selectFrom(QMovie.movie)
				.where(QMovie.movie.name.eq(name))
				.fetchFirst();
		
		return result;
	}
	
	@Override
	public List<Movie> getAllMoviesByName(String name){
		JPAQueryFactory query = new JPAQueryFactory(entity);
		
		List<Movie> results = query.select(QMovie.movie)
				.where(QMovie.movie.name.eq(name)).
				fetch();
		
		return results;
	}

	@Override
	public long getAvgRatingById(Long idRatingParent){
		return ratingRepository.avgByIdRatingParent(idRatingParent);
	}

	@Override
	public void insert(Movie movie) {
		Movie result = movieRepository.saveAndFlush(movie);
		System.out.println("Resultado insert: "+result.getId());
	}
	
	
}
