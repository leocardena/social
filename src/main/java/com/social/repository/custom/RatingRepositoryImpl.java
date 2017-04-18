package com.social.repository.custom;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.social.domain.Actor;
import com.social.domain.Episode;
import com.social.domain.Movie;
import com.social.domain.QActor;
import com.social.domain.QEpisode;
import com.social.domain.QMovie;
import com.social.domain.QRating;
import com.social.domain.QRatingParent;
import com.social.domain.QSeason;
import com.social.domain.QTvShow;
import com.social.domain.Rating;
import com.social.domain.Season;
import com.social.domain.TvShow;
import com.social.repository.custom.interfaces.RatingRepositoryCustom;
import com.social.web.rest.dto.ActorDTO;
import com.social.web.rest.dto.EpisodeDTO;
import com.social.web.rest.dto.MovieDTO;
import com.social.web.rest.dto.RatingDTO;
import com.social.web.rest.dto.RatingTargetDTO;
import com.social.web.rest.dto.SeasonDTO;
import com.social.web.rest.dto.TvShowDTO;
import com.social.web.rest.dto.UserRatingDTO;

public class RatingRepositoryImpl implements RatingRepositoryCustom {
	
	@PersistenceContext
    private EntityManager em;

	@Override
	public Optional<Rating> findRatingByRatingParentAndProfile(Long idProfile, Long idRatingParent) {
		QRating rating = QRating.rating;
		
		Rating ratingResult = new JPAQuery<Rating>(em)
					.from(rating)
					.where(rating.profile.eq(idProfile).and(rating.idRatingParent.id.eq(idRatingParent)))
					.fetchOne();
		
		return Optional.ofNullable(ratingResult);
	}
	
	public Optional<Rating> findUserRating(Long profileId, Long idRatingParent, String slug) {
		
		QRating rating = new QRating("r");
		QRatingParent ratingParent = new QRatingParent("rp");
		
		Rating ratingResult = new JPAQuery<Rating>(em)
				.select(rating)
				.from(rating)
				.join(rating.idRatingParent, ratingParent)
				.where(rating.profile.eq(profileId))
				.where(ratingParent.id.eq(idRatingParent))
				.fetchOne();
		
		return Optional.ofNullable(ratingResult);
	}

	@Override
	public Optional<RatingDTO> averageAndVotesByIdRatingParent(Long idRatingParent) {
		QRating rating = QRating.rating;
		
		return new JPAQueryFactory(em)
			.select(rating.note.avg(), rating.idRating.count())
			.from(rating)
			.where(rating.idRatingParent.id.eq(idRatingParent))
			.groupBy(rating.idRatingParent)
			.fetch()
			.stream()
			.map(r -> new RatingDTO(r.get(rating.note.avg()).doubleValue(),
					r.get(rating.idRating.count()).longValue()))
			.findFirst();
	}

	@Override
	public Long compatibilityBetweenFriends(Long profileId, Long friendId) {
		QRating rating = QRating.rating;
		
		List<Long> listResult = new JPAQueryFactory(em)
					.select(rating.idRatingParent.count())
					.from(rating)
					.where(rating.profile.eq(profileId).or(rating.profile.eq(friendId)).and(rating.note.gt(4)))
					.groupBy(rating.idRatingParent)
					.having(rating.idRatingParent.count().between(2, 2))
					.fetch();
		
		return listResult.stream().count();
	}

	@Override
	public List<RatingTargetDTO<?>> findRatingsByIdProfile(Long idProfile) {
		QRating rating = QRating.rating;
		QMovie movie = QMovie.movie;
		QTvShow tvShow = QTvShow.tvShow;
		QSeason season = QSeason.season;
		QEpisode episode = QEpisode.episode;
		QActor actor = QActor.actor;
		
		 List<Rating> ratings = new JPAQueryFactory(em)
			.select(rating)
			.from(rating)
			.where(rating.profile.eq(idProfile))
			.orderBy(rating.date.desc())
			.fetch();
		 
		 List<RatingTargetDTO<?>> result = new ArrayList<>();
		 DateTimeFormatter dtf = DateTimeFormat.forPattern("dd/MM/yyyy");
		 
		 ratings.forEach(r -> {
			 switch (r.getTargetType()) {
				case "MOVIE":
					Movie movieResult = new JPAQueryFactory(em)
						.select(movie)
						.from(movie)
						.where(movie.ratingParent.eq(r.getIdRatingParent()))
						.fetchOne();
					
					UserRatingDTO userMovieRating = new UserRatingDTO();
					userMovieRating.setId(r.getIdRating());
					userMovieRating.setNote(r.getNote());
					userMovieRating.setDate((dtf.print(r.getDate())));
					
					MovieDTO movieDTO = new MovieDTO();
					movieDTO.setId(movieResult.getId());
					movieDTO.setImdb(movieResult.getImdb());
					movieDTO.setSlug(movieResult.getSlug());
					movieDTO.setName(movieResult.getName());
					
					result.add(new RatingTargetDTO<MovieDTO>(userMovieRating, movieDTO, r.getTargetType()));
					break;
				case "ACTOR":
					Actor actorResult = new JPAQueryFactory(em)
						.select(actor)
						.from(actor)
						.where(actor.ratingParent.eq(r.getIdRatingParent()))
						.fetchOne();
					
					UserRatingDTO userActorRating = new UserRatingDTO();
					userActorRating.setId(r.getIdRating());
					userActorRating.setNote(r.getNote());
					userActorRating.setDate((dtf.print(r.getDate())));
					
					ActorDTO actorDTO = new ActorDTO();
					actorDTO.setId(actorResult.getId());
					actorDTO.setImdb(actorResult.getImdb());
					actorDTO.setName(actorResult.getName());
					actorDTO.setSlug(actorResult.getSlug());
					
					result.add(new RatingTargetDTO<ActorDTO>(userActorRating, actorDTO, r.getTargetType()));
					break;
				case "TVSHOW":
					TvShow tvShowResult = new JPAQueryFactory(em)
						.select(tvShow)
						.from(tvShow)
						.where(tvShow.ratingParent.eq(r.getIdRatingParent()))
						.fetchOne();
				
					UserRatingDTO userTvShowRating = new UserRatingDTO();
					userTvShowRating.setId(r.getIdRating());
					userTvShowRating.setNote(r.getNote());
					userTvShowRating.setDate((dtf.print(r.getDate())));
					
					TvShowDTO tvShowDTO = new TvShowDTO();
					tvShowDTO.setId(tvShowResult.getId());
					tvShowDTO.setImdb(tvShowResult.getImdb());
					tvShowDTO.setName(tvShowResult.getName());
					tvShowDTO.setSlug(tvShowDTO.getSlug());
					
					result.add(new RatingTargetDTO<TvShowDTO>(userTvShowRating, tvShowDTO, r.getTargetType()));
					break;
				case "SEASON":
					Season seasonResult = new JPAQueryFactory(em)
						.select(season)
						.from(season)
						.where(season.ratingParent.eq(r.getIdRatingParent()))
						.fetchOne();
			
					UserRatingDTO userSeasonRating = new UserRatingDTO();
					userSeasonRating.setId(r.getIdRating());
					userSeasonRating.setNote(r.getNote());
					userSeasonRating.setDate((dtf.print(r.getDate())));
					
					SeasonDTO seasonDTO = new SeasonDTO();
					seasonDTO.setNumber(seasonResult.getNumber());
					seasonDTO.setName(seasonResult.getName());
					seasonDTO.setId(seasonResult.getIdSeason());
					seasonDTO.setIdTvShow(seasonResult.getTvShow());
					
					result.add(new RatingTargetDTO<SeasonDTO>(userSeasonRating, seasonDTO, r.getTargetType()));
					break;
				case "EPISODE":
					Episode episodeResult = new JPAQueryFactory(em)
						.select(episode)
						.from(episode)
						.where(episode.ratingParent.eq(r.getIdRatingParent()))
						.fetchOne();
		
					UserRatingDTO userEpisodeRating = new UserRatingDTO();
					userEpisodeRating.setId(r.getIdRating());
					userEpisodeRating.setNote(r.getNote());
					userEpisodeRating.setDate((dtf.print(r.getDate())));
					
					EpisodeDTO episodeDTO = new EpisodeDTO();
					episodeDTO.setIdEpisode(episodeResult.getIdEpisode());
					episodeDTO.setName(episodeResult.getName());
					episodeDTO.setNumber(Long.valueOf(episodeResult.getNumber()));
					episodeDTO.setSeason(episodeResult.getSeason());
					
					result.add(new RatingTargetDTO<EpisodeDTO>(userEpisodeRating, episodeDTO, r.getTargetType()));
					break;
				default:
					break;
				}
		 });
		 
		return result;
	}
	
}
