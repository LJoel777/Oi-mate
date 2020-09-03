package hu.joel.laczkovszki.qa.controller;


import hu.joel.laczkovszki.qa.model.User;
import hu.joel.laczkovszki.qa.service.UserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class RegisterController {

    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registration")
    public void registration(@RequestBody User user){
        System.out.println(user.getFieldsOfInterest());
        user.setPsw(BCrypt.hashpw(user.getPsw(),BCrypt.gensalt(10)));
        userService.addUser(user);
    }




}
