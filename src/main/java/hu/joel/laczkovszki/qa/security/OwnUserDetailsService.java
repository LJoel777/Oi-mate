package hu.joel.laczkovszki.qa.security;

import hu.joel.laczkovszki.qa.model.MyUserDetails;
import hu.joel.laczkovszki.qa.model.User;
import hu.joel.laczkovszki.qa.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class OwnUserDetailsService implements UserDetailsService {

    private UserRepository users;

    public OwnUserDetailsService(UserRepository users) {
        this.users = users;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = users.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username: " + username + " not found"));

        return MyUserDetails.builder()
                .username(username)
                .password(user.getPsw())
                .fieldsOfInterests(user.getFieldsOfInterests())
                .roles((user.getRoles().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList())))
                .build();
    }
}