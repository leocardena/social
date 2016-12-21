package com.social.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QActor is a Querydsl query type for Actor
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QActor extends EntityPathBase<Actor> {

    private static final long serialVersionUID = -231055073L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QActor actor = new QActor("actor");

    public final QPeople _super = new QPeople(this);

    //inherited
    public final DateTimePath<org.joda.time.DateTime> birthday = _super.birthday;

    public final QCommentParent commentParent;

    //inherited
    public final StringPath country = _super.country;

    public final StringPath id = createString("id");

    public final StringPath imdb = createString("imdb");

    //inherited
    public final StringPath name = _super.name;

    public final QRatingParent ratingParent;

    public QActor(String variable) {
        this(Actor.class, forVariable(variable), INITS);
    }

    public QActor(Path<? extends Actor> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QActor(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QActor(PathMetadata metadata, PathInits inits) {
        this(Actor.class, metadata, inits);
    }

    public QActor(Class<? extends Actor> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.commentParent = inits.isInitialized("commentParent") ? new QCommentParent(forProperty("commentParent")) : null;
        this.ratingParent = inits.isInitialized("ratingParent") ? new QRatingParent(forProperty("ratingParent")) : null;
    }

}

