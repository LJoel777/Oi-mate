package hu.joel.laczkovszki.qa.repository;

import hu.joel.laczkovszki.qa.model.Post;
import hu.joel.laczkovszki.qa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Query(value = "SELECT p FROM Post p WHERE p.user.id = :id")
    Set<Post> findAllByUserId(@Param("id") Long id);

    Set<Post> findAllByCategoriesIn(List<String> categories);

    Set<Post> findAllByUserIsIn(Set<User> users);
}
