package com.social.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPeople is a Querydsl query type for People
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QPeople extends EntityPathBase<People> {

    private static final long serialVersionUID = 1858363557L;

    public static final QPeople people = new QPeople("people");

    public final DateTimePath<org.joda.time.DateTime> birthday = createDateTime("birthday", org.joda.time.DateTime.class);

    public final StringPath country = createString("country");

    public final StringPath name = createString("name");

    public QPeople(String variable) {
        super(People.class, forVariable(variable));
    }

    public QPeople(Path<? extends People> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPeople(PathMetadata metadata) {
        super(People.class, metadata);
    }

}

