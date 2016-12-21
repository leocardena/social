package com.social.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCommentParent is a Querydsl query type for CommentParent
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCommentParent extends EntityPathBase<CommentParent> {

    private static final long serialVersionUID = -624734957L;

    public static final QCommentParent commentParent = new QCommentParent("commentParent");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QCommentParent(String variable) {
        super(CommentParent.class, forVariable(variable));
    }

    public QCommentParent(Path<? extends CommentParent> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCommentParent(PathMetadata metadata) {
        super(CommentParent.class, metadata);
    }

}

