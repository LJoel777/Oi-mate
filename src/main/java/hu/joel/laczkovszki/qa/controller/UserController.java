package hu.joel.laczkovszki.qa.controller;


import hu.joel.laczkovszki.qa.model.Session;
import hu.joel.laczkovszki.qa.model.User;
import hu.joel.laczkovszki.qa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.mindrot.jbcrypt.BCrypt;
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
    public Session loginVerification (@RequestBody Map<String,String> login ){
        String email = login.get("email");
        String psw = login.get("password");
        return loginValidater(email, psw);
    }

    private Session loginValidater(String email,String psw){
        User user = userService.findByEmail(email);
        System.out.println(userService.getAllUsers());
        int userID = user.getId();
        try {
          String  originalPsw = user.getPsw();
            System.out.println("ELKÜLDI");
            return new Session(BCrypt.checkpw(psw,originalPsw),userID);
        }
        catch (NullPointerException e){
            System.out.println("catch");
            return new Session(false,0);
        }
    }

    @GetMapping("/user/{id}")
    public User getUser (@PathVariable("id") int id) {
        return userService.getUser(id);
    }
}
