package com.social.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QComment is a Querydsl query type for Comment
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QComment extends EntityPathBase<Comment> {

    private static final long serialVersionUID = -888569079L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QComment comment = new QComment("comment");

    public final DateTimePath<org.joda.time.DateTime> date = createDateTime("date", org.joda.time.DateTime.class);

    public final NumberPath<Long> dislikes = createNumber("dislikes", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QCommentParent idCommentParent;

    public final NumberPath<Long> likes = createNumber("likes", Long.class);

    public final QComment parent;

    public final NumberPath<Long> replies = createNumber("replies", Long.class);

    public final StringPath text = createString("text");

    public QComment(String variable) {
        this(Comment.class, forVariable(variable), INITS);
    }

    public QComment(Path<? extends Comment> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QComment(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QComment(PathMetadata metadata, PathInits inits) {
        this(Comment.class, metadata, inits);
    }

    public QComment(Class<? extends Comment> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.idCommentParent = inits.isInitialized("idCommentParent") ? new QCommentParent(forProperty("idCommentParent")) : null;
        this.parent = inits.isInitialized("parent") ? new QComment(forProperty("parent"), inits.get("parent")) : null;
    }

}

