package com.social.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEpisodeManager is a Querydsl query type for EpisodeManager
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEpisodeManager extends EntityPathBase<EpisodeManager> {

    private static final long serialVersionUID = -1718746808L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QEpisodeManager episodeManager = new QEpisodeManager("episodeManager");

    public final EnumPath<com.social.util.EpisodeStatus> epidoseStatus = createEnum("epidoseStatus", com.social.util.EpisodeStatus.class);

    public final QEpisode episode;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QProfile profile;

    public QEpisodeManager(String variable) {
        this(EpisodeManager.class, forVariable(variable), INITS);
    }

    public QEpisodeManager(Path<? extends EpisodeManager> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QEpisodeManager(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QEpisodeManager(PathMetadata metadata, PathInits inits) {
        this(EpisodeManager.class, metadata, inits);
    }

    public QEpisodeManager(Class<? extends EpisodeManager> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.episode = inits.isInitialized("episode") ? new QEpisode(forProperty("episode"), inits.get("episode")) : null;
        this.profile = inits.isInitialized("profile") ? new QProfile(forProperty("profile"), inits.get("profile")) : null;
    }

}

