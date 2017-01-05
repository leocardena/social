package com.social.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QTitle is a Querydsl query type for Title
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTitle extends EntityPathBase<Title> {

    private static final long serialVersionUID = -213329534L;

    public static final QTitle title = new QTitle("title");

    public final StringPath homePage = createString("homePage");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath imdb = createString("imdb");

    public final StringPath name = createString("name");

    public final StringPath trailer = createString("trailer");

    public final NumberPath<Long> votes = createNumber("votes", Long.class);

    public QTitle(String variable) {
        super(Title.class, forVariable(variable));
    }

    public QTitle(Path<? extends Title> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTitle(PathMetadata metadata) {
        super(Title.class, metadata);
    }

}

