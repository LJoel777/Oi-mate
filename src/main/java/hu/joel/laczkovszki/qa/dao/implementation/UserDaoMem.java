package hu.joel.laczkovszki.qa.dao.implementation;

import hu.joel.laczkovszki.qa.dao.CRUDInterface;
import hu.joel.laczkovszki.qa.dao.UserDao;
import hu.joel.laczkovszki.qa.exception.ApiRequestException;
import hu.joel.laczkovszki.qa.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDaoMem implements CRUDInterface<User> , UserDao {
    private static List<User> users;

    @Autowired
    public static void setUsers(List<User> users) {
        UserDaoMem.users = users;
    }

    @Override
    public void add(User user) {
        users.add(user);
    }

    @Override
    public User find(int id) {
        return users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void remove(int id) {
        users.remove(users.stream()
                .filter((user -> user.getId() == id))
                .findFirst()
                .orElseThrow(() -> new ApiRequestException("User id not found" + "(" + id + ")")));
    }

    @Override
    public void update(int id, User user) {
        remove(id);
        user.setId(id);
        users.add(user);
        User user1 = find(id);
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public User findByEmail(String email) {
        return users.stream().filter(user -> user.getEmailAddress().equals(email)).findFirst().orElseThrow(()->new NullPointerException("No user found"));
    }
}
