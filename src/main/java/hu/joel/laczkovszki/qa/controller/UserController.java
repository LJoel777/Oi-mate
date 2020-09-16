package hu.joel.laczkovszki.qa.controller;


import hu.joel.laczkovszki.qa.model.Session;
import hu.joel.laczkovszki.qa.model.User;
import hu.joel.laczkovszki.qa.model.UserInfoView;
import hu.joel.laczkovszki.qa.service.UserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public Session loginVerification(@RequestBody Map<String, String> login) {
        String email = login.get("email");
        String psw = login.get("password");
        return loginValidator(email, psw);
    }

    private Session loginValidator(String email, String psw) {
        User user = userService.findByEmail(email);
        Long userID = user.getId();
        try {
            String originalPsw = user.getPsw();
            return new Session(BCrypt.checkpw(psw, originalPsw), userID);
        } catch (NullPointerException e) {
            return new Session(false, 0L);
        }
    }

    @GetMapping("/user/{id}")
    public UserInfoView getUser(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }

    @GetMapping("/user/{friendId}/add-friend/{userId}")
    public void addFriendToUser(@PathVariable("friendId") Long friendId, @PathVariable("userId") Long userId) {
        userService.addFriendToUser(userId, friendId);
    }

    @PostMapping("/update-user/{id}")
    public void updateHobbies(@PathVariable("id") Long id, @RequestBody User user) {
        userService.updateUser(user, id);
    }
}
