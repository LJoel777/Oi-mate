package hu.joel.laczkovszki.qa.controller;

import hu.joel.laczkovszki.qa.infoView.UserInfoView;
import hu.joel.laczkovszki.qa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("user/")
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("{id}")
    public UserInfoView getUser(@PathVariable("id") Long id) {
        return userService.getUserInfoView(id);
    }

    @GetMapping("{friendId}/add-friend/{userId}")
    public Set<Long> addFriendToUser(@PathVariable("friendId") Long friendId, @PathVariable("userId") Long userId) {
        userService.sendFriendRequest(userId, friendId);
        return userService.getUserInfoView(friendId).getFriends();
    }

    @GetMapping("{friendId}/remove-friend/{userId}")
    public Set<Long> removeFriend(@PathVariable("friendId") Long friendId, @PathVariable("userId") Long userId) {
        userService.removeFriend(userId, friendId);
        return userService.getUserInfoView(friendId).getFriends();
    }


    @PostMapping("update-user/{id}")
    public UserInfoView updateHobbies(@PathVariable("id") Long id, @RequestBody UserInfoView user) {
        userService.updateUser(user, id);
        return userService.getUserInfoView(id);
    }
}
