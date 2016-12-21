package com.social.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSeason is a Querydsl query type for Season
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSeason extends EntityPathBase<Season> {

    private static final long serialVersionUID = 1943836921L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSeason season = new QSeason("season");

    public final DateTimePath<org.joda.time.DateTime> aired = createDateTime("aired", org.joda.time.DateTime.class);

    public final QCommentParent commentParent;

    public final ListPath<Episode, QEpisode> epidodes = this.<Episode, QEpisode>createList("epidodes", Episode.class, QEpisode.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final QRatingParent ratingParent;

    public final QTvShow tvShow;

    public final NumberPath<Long> votes = createNumber("votes", Long.class);

    public QSeason(String variable) {
        this(Season.class, forVariable(variable), INITS);
    }

    public QSeason(Path<? extends Season> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QSeason(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QSeason(PathMetadata metadata, PathInits inits) {
        this(Season.class, metadata, inits);
    }

    public QSeason(Class<? extends Season> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.commentParent = inits.isInitialized("commentParent") ? new QCommentParent(forProperty("commentParent")) : null;
        this.ratingParent = inits.isInitialized("ratingParent") ? new QRatingParent(forProperty("ratingParent")) : null;
        this.tvShow = inits.isInitialized("tvShow") ? new QTvShow(forProperty("tvShow"), inits.get("tvShow")) : null;
    }

}

