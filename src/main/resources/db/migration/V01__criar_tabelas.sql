/* TABLES */
-- -----------------------------------------------------
-- Table SocialNetwork.User
-- -----------------------------------------------------
CREATE TABLE User(
idUser INT NOT NULL,
createdDate TIMESTAMP NOT NULL,
lastModifiedDate TIMESTAMP,
activated BOOLEAN NOT NULL,
activationKey VARCHAR(20),
email VARCHAR(100) UNIQUE NOT NULL,
username VARCHAR(50) UNIQUE NOT NULL,
resetDate TIMESTAMP,
resetKey VARCHAR(200),
phone VARCHAR(11),
password VARCHAR (100) NOT NULL
) ENGINE=InnoDB;
-- -----------------------------------------------------
-- Table SocialNetwork.PersistentToken
-- -----------------------------------------------------
CREATE TABLE PersistentToken(
series VARCHAR(255) NOT NULL,
idUser INT,
ipAddress VARCHAR(39),
tokenDate TIMESTAMP,
tokenValue VARCHAR(255) NOT NULL,
userAgent VARCHAR(255)
) ENGINE=InnoDB;
-- -----------------------------------------------------
-- Table SocialNetwork.UserAuthority
-- -----------------------------------------------------
CREATE TABLE UserAuthority(
idUser INT NOT NULL,
authorityName VARCHAR(50) NOT NULL
) ENGINE=InnoDB;
-- -----------------------------------------------------
-- Table SocialNetwork.Authority
-- -----------------------------------------------------
CREATE TABLE Authority(
name VARCHAR(50) NOT NULL
) ENGINE=InnoDB;

/*-- -----------------------------------------------------
-- Table SocialNetwork.PersistentAuditEvent
-- -----------------------------------------------------
CREATE TABLE PersistentAuditEvent(
idEvent INT (39) NOT NULL,
eventDate TIMESTAMP,
eventType VARCHAR(255),
principal VARCHAR(255) NOT NULL
) ENGINE=InnoDB;*/
/*-- -----------------------------------------------------
-- Table SocialNetwork.PersistentAuditEventData
-- -----------------------------------------------------
CREATE TABLE PersistentAuditEventData(
idEvent INT(39) NOT NULL,
value VARCHAR(255),
name VARCHAR(255) NOT NULL
) ENGINE=InnoDB;*/
-- -----------------------------------------------------
-- Table SocialNetwork.Profile
-- -----------------------------------------------------
CREATE TABLE Profile(
idProfile INT NOT NULL,
idCommentParent INT NOT NULL,
idUser INT UNIQUE NOT NULL,
name VARCHAR (100) NOT NULL,
genre VARCHAR (1) NOT NULL ,
avatar VARCHAR(1000) DEFAULT NULL,
birthay TIMESTAMP NOT NULL,
country VARCHAR(100) NOT NULL
) ENGINE=InnoDB;
-- -----------------------------------------------------
-- Table SocialNetwork.Movie
-- -----------------------------------------------------
CREATE TABLE Movie(
idMovie INT NOT NULL, 
idTitle INT NOT NULL,
idCommentParent INT NOT NULL,
idRatingParent INT NOT NULL
)ENGINE=InnoDB;
-- -----------------------------------------------------
-- Table SocialNetwork.Actor
-- -----------------------------------------------------
CREATE TABLE Actor(
idActor INT UNIQUE NOT NULL,
idCommentParent INT NOT NULL,
idRatingParent INT NOT NULL,
imdb INT UNIQUE NOT NULL,
name VARCHAR (100) NOT NULL,
birthay DATE NOT NULL,
country VARCHAR(100) NOT NULL
) ENGINE=InnoDB;
-- -----------------------------------------------------
-- Table SocialNetwork.Title
-- -----------------------------------------------------
CREATE TABLE Title(
idTitle INT NOT NULL,
imdb  INT UNIQUE NOT NULL,
name VARCHAR(100) UNIQUE NOT NULL,
trailer VARCHAR(1000) NOT NULL,
homePage VARCHAR(1000) NOT NULL,
votes INT NOT NULL DEFAULT 0
)ENGINE=InnoDB;

-- -----------------------------------------------------
-- Table SocialNetwork.TvShow
-- -----------------------------------------------------
CREATE TABLE TvShow( 
idTvShow INT NOT NULL,
idTitle INT NOT NULL,
idCommentParent INT NOT NULL,
idRatingParent INT NOT NULL
)ENGINE=InnoDB;
-- -----------------------------------------------------
-- Table SocialNetwork.Season
-- -----------------------------------------------------
CREATE TABLE Season(
idSeason INT UNIQUE NOT NULL, 
idTvShow INT NOT NULL,
idCommentParent INT NOT NULL,
idRatingParent INT NOT NULL,
name VARCHAR(100) NOT NULL,
aired DATE NOT NULL,
votes INT NOT NULL DEFAULT 0
)ENGINE=InnoDB;
-- -----------------------------------------------------
-- Table SocialNetwork.Episode
-- -----------------------------------------------------
CREATE TABLE Episode(
idEpisode INT UNIQUE NOT NULL, 
idSeason INT NOT NULL,
idCommentParent INT NOT NULL,
idRatingParent INT NOT NULL,
name VARCHAR(100) NOT NULL,
aired DATE NOT NULL,
votes INT NOT NULL DEFAULT 0
)ENGINE=InnoDB;
-- -----------------------------------------------------
-- Table SocialNetwork.Message
-- -----------------------------------------------------
CREATE TABLE Message(
idMessage INT NOT NULL, 
idSender INT NOT NULL,
idReceiver INT NOT NULL,
date TIMESTAMP NOT NULL DEFAULT NOW(),
text TEXT,
status VARCHAR(7) NOT NULL DEFAULT 'UNREAD'
) ENGINE=InnoDB;
-- -----------------------------------------------------
-- Table SocialNetwork.Friend
-- -----------------------------------------------------
CREATE TABLE Friend(
idFriendShip INT UNIQUE NOT NULL, 
idProfile INT  NOT NULL,
idFriend INT NOT NULL,
status VARCHAR(7) NOT NULL DEFAULT 'WAITING'
) ENGINE=InnoDB;
-- -----------------------------------------------------
-- Table SocialNetwork.EpisodeManager
-- -----------------------------------------------------
CREATE TABLE EpisodeManager(
idEpisodeManager INT UNIQUE NOT NULL,  
idEpisode INT NOT NULL,
idProfile INT NOT NULL,
episodeStatus VARCHAR(9) NOT NULL DEFAULT 'UNWHATCH'
)ENGINE=InnoDB;
-- -----------------------------------------------------
-- Table SocialNetwork.List
-- -----------------------------------------------------
CREATE TABLE List(
idList INT NOT NULL, 
idProfile INT NOT NULL,
name VARCHAR(100) NOT NULL,
date TIMESTAMP DEFAULT NOW() NOT NULL,
access VARCHAR (100) NOT NULL,
type VARCHAR(10) NOT NULL
)ENGINE=InnoDB;
-- -----------------------------------------------------
-- Table SocialNetwork.ListTitle
-- -----------------------------------------------------
CREATE TABLE ListTitle(
idList INT NOT NULL,
idTitle INT NOT NULL
)ENGINE=InnoDB;

/* Comments */
-- -----------------------------------------------------
-- Table SocialNetwork.Comment
-- -----------------------------------------------------
CREATE TABLE Comment(
idComment INT NOT NULL, 
idCommentParent INT NOT NULL,
text TEXT NOT NULL,
date TIMESTAMP DEFAULT NOW() NOT NULL,
likes INT(10) DEFAULT 0 ,
dislikes INT(10) DEFAULT 0,
replies INT DEFAULT 0,
parent INT
)ENGINE=InnoDB;
-- -----------------------------------------------------
-- Table SocialNetwork.CommentParent
-- -----------------------------------------------------
CREATE TABLE CommentParent(
idCommentParent INT NOT NULL 
)ENGINE=InnoDB;
-- -----------------------------------------------------
-- Table SocialNetwork.ProfileComments
-- -----------------------------------------------------
CREATE TABLE ProfileComments(
idComment INT NOT NULL,
idProfile INT NOT NULL
)ENGINE=InnoDB;

/* Rating */
-- -----------------------------------------------------
-- Table SocialNetwork.Rating
-- -----------------------------------------------------
CREATE TABLE Rating(
idRating INT NOT NULL,
idRatingParent INT NOT NULL,
date TIMESTAMP NOT NULL DEFAULT NOW(),
note FLOAT NOT NULL DEFAULT 0.0
)ENGINE=InnoDB;
-- -----------------------------------------------------
-- Table SocialNetwork.RatingParent
-- -----------------------------------------------------
CREATE TABLE RatingParent(
idRatingParent INT NOT NULL 
)ENGINE=InnoDB;
-- -----------------------------------------------------
-- Table SocialNetwork.ProfileRatings
-- -----------------------------------------------------
CREATE TABLE ProfileRatings(
idRating INT NOT NULL,
idProfile INT NOT NULL
)ENGINE=InnoDB;
