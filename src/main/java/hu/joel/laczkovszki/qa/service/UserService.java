package hu.joel.laczkovszki.qa.service;

import hu.joel.laczkovszki.qa.dao.CRUDInterface;
import hu.joel.laczkovszki.qa.dao.implementation.UserDaoMem;
import hu.joel.laczkovszki.qa.model.User;
import hu.joel.laczkovszki.qa.testData.TestUserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final CRUDInterface<User> userDao;

    @Autowired
    public UserService(UserDaoMem userDao) {
        this.userDao = userDao;
        UserDaoMem.setUsers(TestUserData.userList);
    }

    public List<User> getAllUsers() {
        return userDao.getAll();
    }

    public User getUser(int id) {
        return userDao.find(id);
    }
}
