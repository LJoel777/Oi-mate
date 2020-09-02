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
        add(new User("joel",psw,"test@test.com","Joel","Laczkovszki","https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcR0IriKi0lR75APTU8DeqQqHgUG2wkGTJrO1g&usqp=CAU", hobbies, null));
        add(new User("bence",psw,"bece@bence.com","Bence","Benve","", hobbies, null));
    }};
}
