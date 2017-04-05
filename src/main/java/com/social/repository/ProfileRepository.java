package com.social.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.social.domain.Profile;
import com.social.domain.User;
import com.social.repository.custom.interfaces.ProfileRepositoryCustom;

public interface ProfileRepository extends JpaRepository<Profile, Long>, ProfileRepositoryCustom {
	
	Optional<Profile> findOneByUser(User user);
	
	Profile findOneByName(String name);
	
	Optional<Profile> findOneById(Long idProfile);
	
	@Query("select p from Profile p inner join p.user u where u.username = :username")
	Optional<Profile> findOneByUsername(@Param("username") String username);
	
}
