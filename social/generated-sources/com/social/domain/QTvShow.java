package com.social.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTvShow is a Querydsl query type for TvShow
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTvShow extends EntityPathBase<TvShow> {

    private static final long serialVersionUID = 1987738293L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTvShow tvShow = new QTvShow("tvShow");

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

    public final ListPath<Season, QSeason> season = this.<Season, QSeason>createList("season", Season.class, QSeason.class, PathInits.DIRECT2);

    //inherited
    public final StringPath trailer = _super.trailer;

    //inherited
    public final NumberPath<Long> votes = _super.votes;

    public QTvShow(String variable) {
        this(TvShow.class, forVariable(variable), INITS);
    }

    public QTvShow(Path<? extends TvShow> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QTvShow(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QTvShow(PathMetadata metadata, PathInits inits) {
        this(TvShow.class, metadata, inits);
    }

    public QTvShow(Class<? extends TvShow> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.commentParent = inits.isInitialized("commentParent") ? new QCommentParent(forProperty("commentParent")) : null;
        this.ratingParent = inits.isInitialized("ratingParent") ? new QRatingParent(forProperty("ratingParent")) : null;
    }

}

