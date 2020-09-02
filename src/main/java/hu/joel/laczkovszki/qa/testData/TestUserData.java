package hu.joel.laczkovszki.qa.testData;

import hu.joel.laczkovszki.qa.model.User;

import java.util.ArrayList;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

public class TestUserData {
    public static List<User> userList = new ArrayList<>(){{
        List<String> hobbies = new ArrayList<>();
        hobbies.add("stream");
        hobbies.add("gaming");
        String psw = BCrypt.hashpw("almafa",BCrypt.gensalt(10));
        add(new User("werneerm",psw,"asd@asd.com","Mark","Werner","", hobbies, null));
    }};
}
