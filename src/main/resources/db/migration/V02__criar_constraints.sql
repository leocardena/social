/* CONSTRAINTS */

-- -----------------------------------------------------
-- PRIMARY KEY
-- -----------------------------------------------------
ALTER TABLE User ADD CONSTRAINT PK_idUser PRIMARY KEY (idUser);
ALTER TABLE Authority ADD CONSTRAINT PK_Authority PRIMARY KEY (name);
ALTER TABLE UserAuthority ADD CONSTRAINT PK_UserAuthority PRIMARY KEY (idUser, authorityName);
--ALTER TABLE PersistentToken ADD CONSTRAINT PK_PersistentToken PRIMARY KEY(series);
ALTER TABLE Profile ADD CONSTRAINT PK_Profile PRIMARY KEY (idProfile);
ALTER TABLE Actor ADD CONSTRAINT PK_Actor PRIMARY KEY (idActor);
ALTER TABLE Movie ADD CONSTRAINT PK_Movie PRIMARY KEY (idTitle);
ALTER TABLE TvShow ADD CONSTRAINT PK_TvShow PRIMARY KEY (idTitle);
ALTER TABLE Season ADD CONSTRAINT PK_Season PRIMARY KEY (idSeason);
ALTER TABLE Episode ADD CONSTRAINT PK_Episode PRIMARY KEY (idEpisode);
ALTER TABLE Title ADD CONSTRAINT PK_Title PRIMARY KEY (idTitle);
ALTER TABLE Comment ADD CONSTRAINT PK_Comment PRIMARY KEY(idComment);
ALTER TABLE Rating ADD CONSTRAINT PK_Rating PRIMARY KEY(idRating);
ALTER TABLE List ADD CONSTRAINT PK_List PRIMARY KEY (idList);
ALTER TABLE ListTitle ADD CONSTRAINT PK_ListTitle PRIMARY KEY (idList, idTitle);
ALTER TABLE EpisodeManager ADD CONSTRAINT PK_EpisodeManager PRIMARY KEY (idEpisodeManager);
ALTER TABLE Friend ADD CONSTRAINT PK_Friend PRIMARY KEY (idProfile, idFriend);
ALTER TABLE Message ADD CONSTRAINT PK_Message PRIMARY KEY (idMessage);
ALTER TABLE Chat ADD CONSTRAINT PK_Chat PRIMARY KEY (idChat);
--ALTER TABLE ProfileRatings ADD CONSTRAINT PK_ProfileRating PRIMARY KEY (idRating, idProfile); 
ALTER TABLE ProfileComments ADD CONSTRAINT PK_ProfileComments PRIMARY KEY (idComment, idProfile);
ALTER TABLE CommentParent ADD CONSTRAINT PK_CommentParent PRIMARY KEY (idCommentParent);
ALTER TABLE RatingParent ADD CONSTRAINT PK_RatingParent PRIMARY KEY (idRatingParent);
-- -----------------------------------------------------
-- AUTO_INCREMENT
-- -----------------------------------------------------
ALTER TABLE User CHANGE COLUMN idUser idUser INT NOT NULL AUTO_INCREMENT;
ALTER TABLE Profile CHANGE COLUMN idProfile idProfile INT NOT NULL AUTO_INCREMENT;
--ALTER TABLE Movie CHANGE COLUMN idMovie idMovie INT NOT NULL AUTO_INCREMENT;
ALTER TABLE Actor CHANGE COLUMN idActor idActor INT NOT NULL AUTO_INCREMENT;
ALTER TABLE Title CHANGE COLUMN idTitle idTitle INT NOT NULL AUTO_INCREMENT;
--ALTER TABLE TvShow CHANGE COLUMN idTvShow idTvShow INT NOT NULL AUTO_INCREMENT;
ALTER TABLE Season CHANGE COLUMN idSeason idSeason INT UNIQUE NOT NULL AUTO_INCREMENT;
ALTER TABLE Episode CHANGE COLUMN idEpisode idEpisode INT UNIQUE NOT NULL AUTO_INCREMENT;
ALTER TABLE Message CHANGE COLUMN idMessage idMessage INT NOT NULL AUTO_INCREMENT;
ALTER TABLE Chat CHANGE COLUMN idChat idChat INT NOT NULL AUTO_INCREMENT;
--ALTER TABLE Friend CHANGE COLUMN idFriendShip idFriendShip INT UNIQUE NOT NULL AUTO_INCREMENT;
ALTER TABLE List CHANGE COLUMN idList idList INT NOT NULL AUTO_INCREMENT;
ALTER TABLE Comment CHANGE COLUMN idComment idComment INT NOT NULL AUTO_INCREMENT;
ALTER TABLE Rating CHANGE COLUMN idRating idRating INT NOT NULL AUTO_INCREMENT;
ALTER TABLE CommentParent CHANGE COLUMN idCommentParent idCommentParent INT NOT NULL AUTO_INCREMENT;
ALTER TABLE RatingParent CHANGE COLUMN idRatingParent idRatingParent INT NOT NULL AUTO_INCREMENT;

-- -----------------------------------------------------
-- FOREIGN KEY
-- -----------------------------------------------------
ALTER TABLE UserAuthority ADD CONSTRAINT FK_UserAuthority_User FOREIGN KEY (idUser) REFERENCES User(idUser);
ALTER TABLE UserAuthority ADD CONSTRAINT FK_UserAuthority_Authority FOREIGN KEY(authorityName) REFERENCES Authority(name);
--ALTER TABLE PersistentToken ADD CONSTRAINT FK_PersistentToken_User FOREIGN KEY (idUser) REFERENCES User(idUser);
ALTER TABLE Profile ADD CONSTRAINT FK_Profile_User FOREIGN KEY (idUser) REFERENCES User(idUser);
ALTER TABLE Movie ADD CONSTRAINT FK_Movie_Title FOREIGN KEY (idTitle) REFERENCES Title(idTitle);
ALTER TABLE TvShow ADD CONSTRAINT FK_TvShow_Title FOREIGN KEY (idTitle) REFERENCES Title(idTitle);
ALTER TABLE Season ADD CONSTRAINT FK_Season_TvShow FOREIGN KEY (idTvShow) REFERENCES TvShow(idtitle);
ALTER TABLE Episode ADD CONSTRAINT FK_Episode_Season FOREIGN KEY(idSeason) REFERENCES Season(idSeason);
ALTER TABLE List ADD CONSTRAINT FK_List_Profile FOREIGN KEY(idProfile) REFERENCES Profile(idProfile);
ALTER TABLE ListTitle ADD CONSTRAINT FK_ListTitle_List FOREIGN KEY (idList) REFERENCES List(idList);
ALTER TABLE ListTitle ADD CONSTRAINT FK_ListTitle_Title FOREIGN KEY (idTitle) REFERENCES Title(idTitle);
ALTER TABLE Message ADD CONSTRAINT FK_Message_Profile FOREIGN KEY (idProfile) REFERENCES Profile(idProfile);
ALTER TABLE Message ADD CONSTRAINT FK_Message_Chat FOREIGN KEY (idChat) REFERENCES Chat(idChat);
ALTER TABLE Friend ADD CONSTRAINT FK_Friend_Profile FOREIGN KEY (idProfile) REFERENCES Profile(idProfile);
ALTER TABLE Friend ADD CONSTRAINT FK_Friend_ProfileFriend FOREIGN KEY (idFriend) REFERENCES Profile(idProfile);
ALTER TABLE EpisodeManager ADD CONSTRAINT FK_EpisodeManager_Episode FOREIGN KEY (idEpisode) REFERENCES Episode(idEpisode);
ALTER TABLE EpisodeManager ADD CONSTRAINT FK_EpisodeManager_Profile FOREIGN KEY (idProfile) REFERENCES Profile(idProfile);
ALTER TABLE Comment ADD CONSTRAINT FK_Parent FOREIGN KEY (parent) REFERENCES Comment(idComment);
ALTER TABLE Comment ADD CONSTRAINT FK_Comment_CommentParent FOREIGN KEY (idCommentParent) REFERENCES CommentParent(idCommentParent);
--ALTER TABLE Profile ADD CONSTRAINT FK_Profile_CommentParent FOREIGN KEY (idCommentParent) REFERENCES CommentParent(idCommentParent);
ALTER TABLE Movie ADD CONSTRAINT FK_Movie_CommentParent FOREIGN KEY (idCommentParent) REFERENCES CommentParent(idCommentParent);
ALTER TABLE Movie ADD CONSTRAINT FK_Movie_RatingParent FOREIGN KEY (idRatingParent) REFERENCES RatingParent(idRatingParent);
ALTER TABLE Actor ADD CONSTRAINT FK_Actor_CommentParent FOREIGN KEY (idCommentParent) REFERENCES CommentParent(idCommentParent);
ALTER TABLE Actor ADD CONSTRAINT FK_Actor_RatingParent FOREIGN KEY (idRatingParent) REFERENCES RatingParent(idRatingParent);
ALTER TABLE TvShow ADD CONSTRAINT FK_TvShow_CommentParent FOREIGN KEY (idCommentParent) REFERENCES CommentParent(idCommentParent);
ALTER TABLE TvShow ADD CONSTRAINT FK_TvShow_RatingParent FOREIGN KEY (idRatingParent) REFERENCES RatingParent(idRatingParent);
ALTER TABLE Season ADD CONSTRAINT FK_Season_CommentParent FOREIGN KEY (idCommentParent) REFERENCES CommentParent(idCommentParent);
ALTER TABLE Season ADD CONSTRAINT FK_Season_RatingParent FOREIGN KEY (idRatingParent) REFERENCES RatingParent(idRatingParent);
ALTER TABLE Episode ADD CONSTRAINT FK_Episode_CommentParent FOREIGN KEY (idCommentParent) REFERENCES CommentParent(idCommentParent);
ALTER TABLE Episode ADD CONSTRAINT FK_Episode_RatingParent FOREIGN KEY (idRatingParent) REFERENCES RatingParent(idRatingParent);
ALTER TABLE ProfileComments ADD CONSTRAINT FK_ProfileComments_Comment FOREIGN KEY (idComment) REFERENCES Comment(idComment);
ALTER TABLE ProfileComments ADD CONSTRAINT FK_ProfileComments_Profile FOREIGN KEY (idProfile) REFERENCES Profile(idProfile);
ALTER TABLE Rating ADD CONSTRAINT FK_Rating_RatingParent FOREIGN KEY (idRatingParent) REFERENCES RatingParent(idRatingParent);
ALTER TABLE Rating ADD CONSTRAINT FK_Rating_Profile FOREIGN KEY (idProfile) REFERENCES Profile(idProfile);
ALTER TABLE Rating ADD CONSTRAINT UC_Rating UNIQUE (idProfile, idRatingParent);
ALTER TABLE Chat ADD CONSTRAINT FK_Chat_ProfileOne FOREIGN KEY (idProfileOne) REFERENCES Profile(idProfile);
ALTER TABLE Chat ADD CONSTRAINT FK_Chat_ProfileTwo FOREIGN KEY (idProfileTwo) REFERENCES Profile(idProfile);
--ALTER TABLE ProfileRatings ADD CONSTRAINT FK_ProfileRatings_Comment FOREIGN KEY (idRating) REFERENCES Rating(idRating);
--ALTER TABLE ProfileRatings ADD CONSTRAINT FK_ProfileRatings_Profile FOREIGN KEY (idProfile) REFERENCES Profile(idProfile);
