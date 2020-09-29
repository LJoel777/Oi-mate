package hu.joel.laczkovszki.qa.controller;

import hu.joel.laczkovszki.qa.model.User;
import hu.joel.laczkovszki.qa.model.UserCredentials;
import hu.joel.laczkovszki.qa.model.UserInfoView;
import hu.joel.laczkovszki.qa.security.JwtTokenServices;
import hu.joel.laczkovszki.qa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {
    private final AuthenticationManager authenticationManager;
    private UserService userService;
    private final JwtTokenServices jwtTokenServices;

    public LoginController(AuthenticationManager authenticationManager, JwtTokenServices jwtTokenServices, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenServices = jwtTokenServices;
        this.userService = userService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserCredentials data) {
        try {
            String username = data.getUsername();
            UserInfoView user = userService.getUserByUserName(username);
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, data.getPassword()));
            List<String> roles = authentication.getAuthorities()
                    .stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());
            String token = jwtTokenServices.createToken(username, roles);
            Map<Object, Object> model = new HashMap<>();
            model.put("user", user);
            model.put("roles", roles);
            model.put("token", token);
            return ResponseEntity.ok(model);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password supplied");
        }
    }
}
