package hu.joel.laczkovszki.qa.repository;

import hu.joel.laczkovszki.qa.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(value = "SELECT c FROM Comment c WHERE c.post.id = :id")
    List<Comment> getAllByPostId(@Param("id") Long id);
}
