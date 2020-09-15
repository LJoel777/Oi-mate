package hu.joel.laczkovszki.qa.repository;

import hu.joel.laczkovszki.qa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmailAddress(String email);
}
