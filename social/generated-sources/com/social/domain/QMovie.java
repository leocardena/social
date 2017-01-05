package com.social.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMovie is a Querydsl query type for Movie
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMovie extends EntityPathBase<Movie> {

    private static final long serialVersionUID = -219613606L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMovie movie = new QMovie("movie");

    public final QTitle _super = new QTitle(this);

    public final QCommentParent commentParent;

    //inherited
    public final StringPath homePage = _super.homePage;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final StringPath imdb = _super.imdb;

    //inherited
    public final StringPath name = _super.name;

    public final QRatingParent ratingParent;

    //inherited
    public final StringPath trailer = _super.trailer;

    //inherited
    public final NumberPath<Long> votes = _super.votes;

    public QMovie(String variable) {
        this(Movie.class, forVariable(variable), INITS);
    }

    public QMovie(Path<? extends Movie> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMovie(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMovie(PathMetadata metadata, PathInits inits) {
        this(Movie.class, metadata, inits);
    }

    public QMovie(Class<? extends Movie> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.commentParent = inits.isInitialized("commentParent") ? new QCommentParent(forProperty("commentParent")) : null;
        this.ratingParent = inits.isInitialized("ratingParent") ? new QRatingParent(forProperty("ratingParent")) : null;
    }

}

