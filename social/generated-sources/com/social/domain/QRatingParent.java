package com.social.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRatingParent is a Querydsl query type for RatingParent
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRatingParent extends EntityPathBase<RatingParent> {

    private static final long serialVersionUID = -178257347L;

    public static final QRatingParent ratingParent = new QRatingParent("ratingParent");

    public final StringPath id = createString("id");

    public QRatingParent(String variable) {
        super(RatingParent.class, forVariable(variable));
    }

    public QRatingParent(Path<? extends RatingParent> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRatingParent(PathMetadata metadata) {
        super(RatingParent.class, metadata);
    }

}

