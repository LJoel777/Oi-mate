package hu.joel.laczkovszki.qa.service;

import hu.joel.laczkovszki.qa.dao.UserDao;
import hu.joel.laczkovszki.qa.dao.implementation.UserDaoMem;
import hu.joel.laczkovszki.qa.model.Hobby;
import hu.joel.laczkovszki.qa.model.User;
import hu.joel.laczkovszki.qa.testData.TestUserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserDao userDao;

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

    public User findByEmail(String email){
        try {

            return userDao.findByEmail(email);
        }
        catch (NullPointerException e){
            return null;
        }
    }

    public void addUser(User user) {
        userDao.add(user);
    }

    public void addFriendToUser (int userId, Integer friendId) {
        getUser(userId).addFriend(friendId);
    }

    public void updateHobbies (Hobby hobby) {
        getUser(hobby.getId()).setFieldsOfInterest(hobby.getFieldsOfInterest());
    }
}
