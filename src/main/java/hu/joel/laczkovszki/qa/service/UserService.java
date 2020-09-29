package hu.joel.laczkovszki.qa.service;

import hu.joel.laczkovszki.qa.model.User;
import hu.joel.laczkovszki.qa.infoView.UserInfoView;
import hu.joel.laczkovszki.qa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final NotificationService notificationService;

    @Autowired
    public UserService(UserRepository userRepository, NotificationService notificationService) {
        this.userRepository = userRepository;
        this.notificationService = notificationService;
    }

    public User getNormalUser(Long id) {
        return userRepository.getOne(id);
    }

    public UserInfoView getUser(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user  != null) {
            return UserInfoView.builder()
                    .id(id)
                    .username(user.getUsername())
                    .firstName(user.getFirstName())
                    .lastName(user.getLastName())
                    .emailAddress(user.getEmailAddress())
                    .fieldsOfInterests(user.getFieldsOfInterests())
                    .profilePicture(user.getProfilePicture())
                    .friends(user.getFriends().stream().map(User::getId).collect(Collectors.toSet()))
                    .build();
        }
        return null;
    }

    public UserInfoView getUserByUserName(String username) {
        User user = userRepository.findUserByUsername(username).orElse(null);
        if (user  != null) {
            return UserInfoView.builder()
                    .id(user.getId())
                    .username(user.getUsername())
                    .firstName(user.getFirstName())
                    .lastName(user.getLastName())
                    .emailAddress(user.getEmailAddress())
                    .fieldsOfInterests(user.getFieldsOfInterests())
                    .profilePicture(user.getProfilePicture())
                    .friends(user.getFriends().stream().map(User::getId).collect(Collectors.toSet()))
                    .build();
        }
        return null;
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

    public void removeFriend(Long userId, Long friendId) {
        User friend = userRepository.getOne(friendId);
        User user = userRepository.getOne(userId);
        friend.removeFriend(user);
        user.removeFriend(friend);
        userRepository.save(friend);
        userRepository.save(user);
    }

    public void updateUser(UserInfoView user, Long id) {
        User updatedUser = userRepository.getOne(id);
        updatedUser.setFieldsOfInterests(user.getFieldsOfInterests());
        updatedUser.setEmailAddress(user.getEmailAddress());
        updatedUser.setProfilePicture(user.getProfilePicture());
        updatedUser.setUsername(user.getUsername());
        userRepository.save(updatedUser);
    }

    public void sendFriendRequest(Long userId, Long friendId) {
        User owner = userRepository.findById(userId).orElse(null);
        User sender = userRepository.findById(friendId).orElse(null);

        notificationService.addFriendRequestNotification(owner,sender);
    }
}
