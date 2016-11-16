
DROP TRIGGER IF EXISTS TGR_TVSHOW_ANTES_INSERT; 
DROP TRIGGER IF EXISTS TGR_SEASON_ANTES_INSERT;
DROP TRIGGER IF EXISTS TGR_EPISODE_ANTES_INSERT;
DROP TRIGGER IF EXISTS TGR_MOVIE_ANTES_INSERT;
DROP TRIGGER IF EXISTS TGR_ACTOR_ANTES_INSERT;


/*
	 Trigger para criar um idRatingParent e idCommentParent para o cada Titulo quando este for colocado
	 como uma Série (Table TVSHOW) 
 */ 
DELIMITER ##
CREATE TRIGGER TGR_TVSHOW_ANTES_INSERT BEFORE INSERT ON TVSHOW
	FOR EACH ROW
	BEGIN
        SET @idCommentParent = (SELECT idCommentParent FROM COMMENTPARENT ORDER BY idCommentParent DESC LIMIT 1) + 1;
		SET @idRatingParent = (SELECT idRatingParent FROM RATINGPARENT ORDER BY idRatingParent DESC LIMIT 1) +  1;
        
        IF (@idRatingParent IS NULL AND @idCommentParent IS NULL) THEN
			INSERT INTO COMMENTPARENT VALUES (1);
			INSERT INTO RATINGPARENT VALUES (1);
            SET NEW.idCommentParent = 1;			
			SET NEW.idRatingParent = 1;
		ELSEIF (@idCommentParent IS NOT NULL AND @idRatingParent IS NOT NULL) THEN
				INSERT INTO COMMENTPARENT VALUES (@idCommentParent);
				INSERT INTO RATINGPARENT VALUES (@idRatingParent);
				SET NEW.idCommentParent = @idCommentParent;			
				SET NEW.idRatingParent = @idRatingParent;
			ELSEIF (@idCommentParent IS NULL) THEN
					INSERT INTO COMMENTPARENT VALUES (1);
					INSERT INTO RATINGPARENT VALUES (@idRatingParent);
					SET NEW.idCommentParent = 1;			
					SET NEW.idRatingParent = @idRatingParent;
				ELSEIF (@idRatingParent IS NULL) THEN
						INSERT INTO COMMENTPARENT VALUES (@idCommentParent);
						INSERT INTO RATINGPARENT VALUES (1);
						SET NEW.idCommentParent = @idCommentParent;			
						SET NEW.idRatingParent = 1;
				END IF;
	END##

/*
	 Trigger para criar um idRatingParent e idCommentParent para o cada Titulo quando este for colocado
	 como uma Filme (Table MOVIE) 
 */ 
DELIMITER ##
CREATE TRIGGER TGR_MOVIE_ANTES_INSERT BEFORE INSERT ON MOVIE
	FOR EACH ROW
	BEGIN
        SET @idCommentParent = (SELECT idCommentParent FROM COMMENTPARENT ORDER BY idCommentParent DESC LIMIT 1) + 1;
		SET @idRatingParent = (SELECT idRatingParent FROM RATINGPARENT ORDER BY idRatingParent DESC LIMIT 1) +  1;
        
        IF (@idRatingParent IS NULL AND @idCommentParent IS NULL) THEN
			INSERT INTO COMMENTPARENT VALUES (1);
			INSERT INTO RATINGPARENT VALUES (1);
            SET NEW.idCommentParent = 1;			
			SET NEW.idRatingParent = 1;
		ELSEIF (@idCommentParent IS NOT NULL AND @idRatingParent IS NOT NULL) THEN
				INSERT INTO COMMENTPARENT VALUES (@idCommentParent);
				INSERT INTO RATINGPARENT VALUES (@idRatingParent);
				SET NEW.idCommentParent = @idCommentParent;			
				SET NEW.idRatingParent = @idRatingParent;
			ELSEIF (@idCommentParent IS NULL) THEN
					INSERT INTO COMMENTPARENT VALUES (1);
					INSERT INTO RATINGPARENT VALUES (@idRatingParent);
					SET NEW.idCommentParent = 1;			
					SET NEW.idRatingParent = @idRatingParent;
				ELSEIF (@idRatingParent IS NULL) THEN
						INSERT INTO COMMENTPARENT VALUES (@idCommentParent);
						INSERT INTO RATINGPARENT VALUES (1);
						SET NEW.idCommentParent = @idCommentParent;			
						SET NEW.idRatingParent = 1;
				END IF;
	END##

/*
	 Trigger para criar um idRatingParent e idCommentParent para cada Ator 
 */ 
DELIMITER ##
CREATE TRIGGER TGR_ACTOR_ANTES_INSERT BEFORE INSERT ON ACTOR
	FOR EACH ROW
	BEGIN
        SET @idCommentParent = (SELECT idCommentParent FROM COMMENTPARENT ORDER BY idCommentParent DESC LIMIT 1) + 1;
		SET @idRatingParent = (SELECT idRatingParent FROM RATINGPARENT ORDER BY idRatingParent DESC LIMIT 1) +  1;
        
        IF (@idRatingParent IS NULL AND @idCommentParent IS NULL) THEN
			INSERT INTO COMMENTPARENT VALUES (1);
			INSERT INTO RATINGPARENT VALUES (1);
            SET NEW.idCommentParent = 1;			
			SET NEW.idRatingParent = 1;
		ELSEIF (@idCommentParent IS NOT NULL AND @idRatingParent IS NOT NULL) THEN
				INSERT INTO COMMENTPARENT VALUES (@idCommentParent);
				INSERT INTO RATINGPARENT VALUES (@idRatingParent);
				SET NEW.idCommentParent = @idCommentParent;			
				SET NEW.idRatingParent = @idRatingParent;
			ELSEIF (@idCommentParent IS NULL) THEN
					INSERT INTO COMMENTPARENT VALUES (1);
					INSERT INTO RATINGPARENT VALUES (@idRatingParent);
					SET NEW.idCommentParent = 1;			
					SET NEW.idRatingParent = @idRatingParent;
				ELSEIF (@idRatingParent IS NULL) THEN
						INSERT INTO COMMENTPARENT VALUES (@idCommentParent);
						INSERT INTO RATINGPARENT VALUES (1);
						SET NEW.idCommentParent = @idCommentParent;			
						SET NEW.idRatingParent = 1;
				END IF;
	END##
	
/*
	 Trigger para criar um idRatingParent e idCommentParent para o cada Temporada quando este for colocado
	 como uma temporada (SEASON) para um Seriado
 */ 
DELIMITER ##
CREATE trigger TGR_SEASON_ANTES_INSERT BEFORE INSERT ON SEASON
	FOR EACH ROW
	BEGIN
        SET @idCommentParent = (SELECT idCommentParent FROM COMMENTPARENT ORDER BY idCommentParent DESC LIMIT 1) + 1;
		SET @idRatingParent = (SELECT idRatingParent FROM RATINGPARENT ORDER BY idRatingParent DESC LIMIT 1) +  1;
        
        IF (@idRatingParent IS NULL AND @idCommentParent IS NULL) THEN
			INSERT INTO COMMENTPARENT VALUES (1);
			INSERT INTO RATINGPARENT VALUES (1);
            SET NEW.idCommentParent = 1;			
			SET NEW.idRatingParent = 1;
		ELSEIF (@idCommentParent IS NOT NULL AND @idRatingParent IS NOT NULL) THEN
				INSERT INTO COMMENTPARENT VALUES (@idCommentParent);
				INSERT INTO RATINGPARENT VALUES (@idRatingParent);
				SET NEW.idCommentParent = @idCommentParent;			
				SET NEW.idRatingParent = @idRatingParent;
			ELSEIF (@idCommentParent IS NULL) THEN
					INSERT INTO COMMENTPARENT VALUES (1);
					INSERT INTO RATINGPARENT VALUES (@idRatingParent);
					SET NEW.idCommentParent = 1;			
					SET NEW.idRatingParent = @idRatingParent;
				ELSEIF (@idRatingParent IS NULL) THEN
						INSERT INTO COMMENTPARENT VALUES (@idCommentParent);
						INSERT INTO RATINGPARENT VALUES (1);
						SET NEW.idCommentParent = @idCommentParent;			
						SET NEW.idRatingParent = 1;
				END IF;
	END##


/*
	 Trigger para criar um idRatingParent e idCommentParent para o cada Episodio quando este for colocado
	 como episodio (EPISODE) para uma temporada
 */ 
DELIMITER ##
CREATE trigger TGR_EPISODE_ANTES_INSERT BEFORE INSERT ON EPISODE
	FOR EACH ROW
	BEGIN
        SET @idCommentParent = (SELECT idCommentParent FROM COMMENTPARENT ORDER BY idCommentParent DESC LIMIT 1) + 1;
		SET @idRatingParent = (SELECT idRatingParent FROM RATINGPARENT ORDER BY idRatingParent DESC LIMIT 1) +  1;
        
        IF (@idRatingParent IS NULL AND @idCommentParent IS NULL) THEN
			INSERT INTO COMMENTPARENT VALUES (1);
			INSERT INTO RATINGPARENT VALUES (1);
            SET NEW.idCommentParent = 1;			
			SET NEW.idRatingParent = 1;
		ELSEIF (@idCommentParent IS NOT NULL AND @idRatingParent IS NOT NULL) THEN
				INSERT INTO COMMENTPARENT VALUES (@idCommentParent);
				INSERT INTO RATINGPARENT VALUES (@idRatingParent);
				SET NEW.idCommentParent = @idCommentParent;			
				SET NEW.idRatingParent = @idRatingParent;
			ELSEIF (@idCommentParent IS NULL) THEN
					INSERT INTO COMMENTPARENT VALUES (1);
					INSERT INTO RATINGPARENT VALUES (@idRatingParent);
					SET NEW.idCommentParent = 1;			
					SET NEW.idRatingParent = @idRatingParent;
				ELSEIF (@idRatingParent IS NULL) THEN
						INSERT INTO COMMENTPARENT VALUES (@idCommentParent);
						INSERT INTO RATINGPARENT VALUES (1);
						SET NEW.idCommentParent = @idCommentParent;			
						SET NEW.idRatingParent = 1;
				END IF;
	END##