package com.crud.first.comment;

import com.crud.first.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
  public List<Comment> findByPostId(Long postId);
}
