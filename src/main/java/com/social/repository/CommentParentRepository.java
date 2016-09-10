package com.social.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.social.domain.CommentParent;

public interface CommentParentRepository extends JpaRepository<CommentParent, Long> {

}
