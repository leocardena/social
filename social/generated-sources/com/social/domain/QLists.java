package com.social.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLists is a Querydsl query type for Lists
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLists extends EntityPathBase<Lists> {

    private static final long serialVersionUID = -220718401L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLists lists = new QLists("lists");

    public final EnumPath<com.social.util.Access> access = createEnum("access", com.social.util.Access.class);

    public final DateTimePath<org.joda.time.DateTime> date = createDateTime("date", org.joda.time.DateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<com.social.util.ListType> listType = createEnum("listType", com.social.util.ListType.class);

    public final StringPath name = createString("name");

    public final QProfile profile;

    public final ListPath<Title, QTitle> title = this.<Title, QTitle>createList("title", Title.class, QTitle.class, PathInits.DIRECT2);

    public QLists(String variable) {
        this(Lists.class, forVariable(variable), INITS);
    }

    public QLists(Path<? extends Lists> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QLists(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QLists(PathMetadata metadata, PathInits inits) {
        this(Lists.class, metadata, inits);
    }

    public QLists(Class<? extends Lists> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.profile = inits.isInitialized("profile") ? new QProfile(forProperty("profile"), inits.get("profile")) : null;
    }

}

