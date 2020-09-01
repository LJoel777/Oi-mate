package hu.joel.laczkovszki.qa.controller;


import hu.joel.laczkovszki.qa.model.User;
import hu.joel.laczkovszki.qa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
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
    public String loginVerification (@RequestBody Map<String,String> login , HttpSession httpSession){
        String email = login.get("email");
        String psw = login.get("password");
        if (loginValidater(email, psw)) {
            httpSession.setAttribute("isValid", "valid");
            try {
                httpSession.setAttribute("user", email);
                return "redirect:/";
            }
            catch (Exception e){
                System.out.println(e);
                return "redirect:/";
            }
        }
        else{
            return "redirect:/registration";
        }
    }

    private boolean loginValidater(String email,String psw){

        return false;
    }

    @GetMapping("/user/{id}")
    public User getUser (@PathVariable("id") int id) {
        return userService.getUser(id);
    }
}
