package hu.joel.laczkovszki.qa.dao;

import hu.joel.laczkovszki.qa.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDao {
     List<User> getAll();
}
