-- -----------------------------------------------------
-- CHECK
-- -----------------------------------------------------
ALTER TABLE Profile ADD CHECK(genre = 'M' OR genre ='F');
ALTER TABLE Message ADD CHECK(status = 'UNREAD' or status = 'READ' or status = 'DELETED');
ALTER TABLE Friend ADD CHECK(status = 'WAITING' or status = 'REFUSED' or status = 'ACCEPT');
ALTER TABLE EpisodeManager ADD CHECK(status = 'WHATCH' or status = 'UNWHATCH');
ALTER TABLE List ADD CHECK(status = 'WHACTHLIST' or status = 'WHATCHED' or status = 'CUSTOM' or status = 'WHATCHING');
-- -----------------------------------------------------
-- CONVERT/CHARSET/COLLATE
-- -----------------------------------------------------
ALTER DATABASE SocialNetwork CHARACTER SET utf8 COLLATE utf8_unicode_ci;
ALTER TABLE User CONVERT TO CHARACTER SET utf8 COLLATE utf8_unicode_ci;
ALTER TABLE Profile CONVERT TO CHARACTER SET utf8 COLLATE utf8_unicode_ci;
ALTER TABLE Actor CONVERT TO CHARACTER SET utf8 COLLATE utf8_unicode_ci;
ALTER TABLE Movie CONVERT TO CHARACTER SET utf8 COLLATE utf8_unicode_ci;
ALTER TABLE TvShow CONVERT TO CHARACTER SET utf8 COLLATE utf8_unicode_ci;
ALTER TABLE Season CONVERT TO CHARACTER SET utf8 COLLATE utf8_unicode_ci;
ALTER TABLE Episode CONVERT TO CHARACTER SET utf8 COLLATE utf8_unicode_ci;
ALTER TABLE Title CONVERT TO CHARACTER SET utf8 COLLATE utf8_unicode_ci;
ALTER TABLE Comment CONVERT TO CHARACTER SET utf8 COLLATE utf8_unicode_ci;
ALTER TABLE CommentParent CONVERT TO CHARACTER SET utf8 COLLATE utf8_unicode_ci;
ALTER TABLE Rating CONVERT TO CHARACTER SET utf8 COLLATE utf8_unicode_ci;
ALTER TABLE RatingParent CONVERT TO CHARACTER SET utf8 COLLATE utf8_unicode_ci;
ALTER TABLE List CONVERT TO CHARACTER SET utf8 COLLATE utf8_unicode_ci;
ALTER TABLE ListTitle CONVERT TO CHARACTER SET utf8 COLLATE utf8_unicode_ci;
ALTER TABLE EpisodeManager CONVERT TO CHARACTER SET utf8 COLLATE utf8_unicode_ci;
ALTER TABLE Friend CONVERT TO CHARACTER SET utf8 COLLATE utf8_unicode_ci;
ALTER TABLE Message CONVERT TO CHARACTER SET utf8 COLLATE utf8_unicode_ci;
ALTER TABLE Chat CONVERT TO CHARACTER SET utf8 COLLATE utf8_unicode_ci;
--ALTER TABLE PersistentToken CONVERT TO CHARACTER SET utf8 COLLATE utf8_unicode_ci;
--ALTER TABLE ProfileRatings CONVERT TO CHARACTER SET utf8 COLLATE utf8_unicode_ci;
ALTER TABLE ProfileComments CONVERT TO CHARACTER SET utf8 COLLATE utf8_unicode_ci;