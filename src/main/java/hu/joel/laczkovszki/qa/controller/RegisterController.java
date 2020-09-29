package hu.joel.laczkovszki.qa.controller;


import hu.joel.laczkovszki.qa.model.User;
import hu.joel.laczkovszki.qa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class RegisterController {

    private PasswordEncoder passwordEncoder;
    private UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        this.userService = userService;
    }

    @PostMapping(value = "/registration")
    public void registration(@RequestBody User user) {
        user.setPsw(passwordEncoder.encode(user.getPsw()));
        userService.addUser(user);
    }
}
