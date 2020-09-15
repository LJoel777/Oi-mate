package hu.joel.laczkovszki.qa.service;

import hu.joel.laczkovszki.qa.model.Hobby;
import hu.joel.laczkovszki.qa.model.User;
import hu.joel.laczkovszki.qa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User findByEmail(String email){
        try {

            return userRepository.findByEmailAddress(email);
        }
        catch (NullPointerException e){
            return null;
        }
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void addFriendToUser(Long userId, Long friendId) {
        User friend = userRepository.getOne(friendId);
        User user = userRepository.getOne(userId);
        friend.addFriend(user);
        user.addFriend(friend);
        userRepository.save(user);
        userRepository.save(friend);
    }

    public void updateHobbies(Hobby hobby) {
        User user = userRepository.getOne(hobby.getId());
        user.setFieldsOfInterests(hobby.getFieldsOfInterest());
        userRepository.save(user);
    }
}
