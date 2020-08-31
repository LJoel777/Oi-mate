package hu.joel.laczkovszki.qa.dao.implementation;

import hu.joel.laczkovszki.qa.dao.UserDao;
import hu.joel.laczkovszki.qa.model.Question;
import hu.joel.laczkovszki.qa.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDaoMem implements UserDao {
    private static List<User> users;

    @Autowired
    public static void setUsers(List<User> users) {
        UserDaoMem.users = users;
    }

    @Override
    public List<User> getAll() {
        return users;
    }
}
