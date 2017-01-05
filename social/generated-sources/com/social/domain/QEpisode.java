package com.social.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEpisode is a Querydsl query type for Episode
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEpisode extends EntityPathBase<Episode> {

    private static final long serialVersionUID = 911561381L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QEpisode episode = new QEpisode("episode");

    public final DateTimePath<org.joda.time.DateTime> aired = createDateTime("aired", org.joda.time.DateTime.class);

    public final QCommentParent commentParent;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final QRatingParent ratingParent;

    public final QSeason season;

    public final NumberPath<Long> votes = createNumber("votes", Long.class);

    public QEpisode(String variable) {
        this(Episode.class, forVariable(variable), INITS);
    }

    public QEpisode(Path<? extends Episode> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QEpisode(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QEpisode(PathMetadata metadata, PathInits inits) {
        this(Episode.class, metadata, inits);
    }

    public QEpisode(Class<? extends Episode> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.commentParent = inits.isInitialized("commentParent") ? new QCommentParent(forProperty("commentParent")) : null;
        this.ratingParent = inits.isInitialized("ratingParent") ? new QRatingParent(forProperty("ratingParent")) : null;
        this.season = inits.isInitialized("season") ? new QSeason(forProperty("season"), inits.get("season")) : null;
    }

}

