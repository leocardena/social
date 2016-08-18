package com.social.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.social.domain.Authority;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
