package hu.joel.laczkovszki.qa.service;

import hu.joel.laczkovszki.qa.dao.UserDao;
import hu.joel.laczkovszki.qa.dao.implementation.UserDaoMem;
import hu.joel.laczkovszki.qa.model.User;
import hu.joel.laczkovszki.qa.testData.TestUserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
        UserDaoMem.setUsers(TestUserData.userList);
    }

    public List<User> getAllUsers() {
        return userDao.getAll();
    }
}
