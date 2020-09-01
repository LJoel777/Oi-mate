package hu.joel.laczkovszki.qa.controller;


import hu.joel.laczkovszki.qa.model.User;
import hu.joel.laczkovszki.qa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @GetMapping("/users")
    public List<User> showAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/login")
    public void loginVerification(@RequestBody Map<String,String> login){
        System.out.println(login.get("email"));
        System.out.println(login.get("password"));
    }

    @GetMapping("/user/{id}")
    public User getUser (@PathVariable("id") int id) {
        return userService.getUser(id);
    }
}
