package hu.joel.laczkovszki.qa.repository;

import hu.joel.laczkovszki.qa.model.Post;
import hu.joel.laczkovszki.qa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Query(value = "SELECT p FROM Post p WHERE p.user.id = :id")
    List<Post> findAllByUserId(@Param("id") Long id);

    List<Post> findAllByCategoriesIn(List<String> categories);

    List<Post> findAllByUserIsIn(List<User> users);
}
