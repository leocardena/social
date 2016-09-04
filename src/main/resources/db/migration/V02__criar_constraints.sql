/* CONSTRAINTS */
-- -----------------------------------------------------
-- PRIMARY KEY
-- -----------------------------------------------------
ALTER TABLE User ADD PRIMARY KEY (idUser);
ALTER TABLE PersistentAuditEventData ADD PRIMARY KEY(name);
ALTER TABLE PersistentAuditEvent ADD PRIMARY KEY(idEvent);
ALTER TABLE Authority ADD PRIMARY KEY (name);
ALTER TABLE UserAuthority ADD PRIMARY KEY (idUser, authorityName);
ALTER TABLE PersistentToken ADD PRIMARY KEY(series);
ALTER TABLE Profile ADD PRIMARY KEY (idProfile, idUser);
ALTER TABLE Actor ADD PRIMARY KEY (idActor);
ALTER TABLE Movie ADD PRIMARY KEY (idMovie, idTitle);
ALTER TABLE TvShow ADD PRIMARY KEY (idTvShow, idTitle);
ALTER TABLE Season ADD PRIMARY KEY (idSeason, idTvShow);
ALTER TABLE Episode ADD PRIMARY KEY (idEpisode, idSeason);
ALTER TABLE Title ADD PRIMARY KEY (idTitle);
ALTER TABLE Comments ADD PRIMARY KEY(idComments);
ALTER TABLE CommentParent ADD PRIMARY KEY(idCommentParent, idComments);
ALTER TABLE Rating ADD PRIMARY KEY(idRating);
ALTER TABLE RatingParent ADD PRIMARY KEY(idRatingParent, idRating);
ALTER TABLE List ADD PRIMARY KEY (idList, idProfile);
ALTER TABLE ListTitle ADD PRIMARY KEY (idList, idTitle);
ALTER TABLE EpisodeManager ADD PRIMARY KEY (idEpisode, idProfile);
ALTER TABLE Friend ADD PRIMARY KEY (idProfile, idFriend);
ALTER TABLE Message ADD PRIMARY KEY (idMessage);
-- -----------------------------------------------------
-- FOREIGN KEY
-- -----------------------------------------------------
ALTER TABLE PersistentAuditEventData ADD FOREIGN KEY (idEvent) REFERENCES PersistentAuditEvent(idEvent);
ALTER TABLE UserAuthority ADD FOREIGN KEY (idUser) REFERENCES User(idUser);
ALTER TABLE UserAuthority ADD FOREIGN KEY(authorityName) REFERENCES Authority(name);
ALTER TABLE PersistentToken ADD FOREIGN KEY (idUser) REFERENCES User(idUser);
ALTER TABLE Profile ADD FOREIGN KEY (idUser) REFERENCES User(idUser);
ALTER TABLE Profile ADD FOREIGN KEY (idCommentParent) REFERENCES CommentParent(idCommentParent);
ALTER TABLE Actor ADD FOREIGN KEY (idCommentParent) REFERENCES CommentParent(idCommentParent);
ALTER TABLE Actor ADD FOREIGN KEY (idRatingParent) REFERENCES RatingParent(idRatingParent);
ALTER TABLE Title ADD FOREIGN KEY (idCommentParent) REFERENCES CommentParent(idCommentParent);
ALTER TABLE CommentParent ADD FOREIGN KEY (idComments) REFERENCES Comments(idComments);
ALTER TABLE Comments ADD FOREIGN KEY (idProfile) REFERENCES Profile(idProfile);
ALTER TABLE Rating ADD FOREIGN KEY(idProfile) REFERENCES Profile(idProfile);
ALTER TABLE RatingParent ADD FOREIGN KEY (idRating) REFERENCES Rating(idRating);
ALTER TABLE Movie ADD FOREIGN KEY (idTitle) REFERENCES Title(idTitle);
ALTER TABLE Movie ADD FOREIGN KEY (idRatingParent) REFERENCES RatingParent(idRatingParent);
ALTER TABLE TvShow ADD FOREIGN KEY (idTitle) REFERENCES Title(idTitle);
ALTER TABLE TvShow ADD FOREIGN KEY (idRatingParent) REFERENCES RatingParent(idRatingParent);
ALTER TABLE Season ADD FOREIGN KEY (idTvShow) REFERENCES TvShow(idTvShow);
ALTER TABLE Season ADD FOREIGN KEY (idRatingParent) REFERENCES RatingParent(idRatingParent);
ALTER TABLE Episode ADD FOREIGN KEY(idSeason) REFERENCES Season(idSeason);
ALTER TABLE Episode ADD FOREIGN KEY (idRatingParent) REFERENCES RatingParent(idRatingParent);
ALTER TABLE List ADD FOREIGN KEY(idProfile) REFERENCES Profile(idProfile);
ALTER TABLE ListTitle ADD FOREIGN KEY (idList) REFERENCES List(idList);
ALTER TABLE ListTitle ADD FOREIGN KEY (idTitle) REFERENCES Title(idTitle);
ALTER TABLE Message ADD FOREIGN KEY (idSender) REFERENCES User(idUser);
ALTER TABLE Message ADD FOREIGN KEY (idReceiver) REFERENCES User(idUser);
ALTER TABLE Friend ADD FOREIGN KEY (idProfile) REFERENCES User(idUser);
ALTER TABLE Friend ADD FOREIGN KEY (idFriend) REFERENCES User(idUser);
ALTER TABLE EpisodeManager ADD FOREIGN KEY (idEpisode) REFERENCES Episode(idEpisode);
ALTER TABLE EpisodeManager ADD FOREIGN KEY (idProfile) REFERENCES Profile(idProfile);