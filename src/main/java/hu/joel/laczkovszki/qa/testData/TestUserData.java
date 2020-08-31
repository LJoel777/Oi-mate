package hu.joel.laczkovszki.qa.testData;

import hu.joel.laczkovszki.qa.model.User;

import java.util.ArrayList;
import java.util.List;

public class TestUserData {
    public static List<User> userList = new ArrayList<>(){{
        add(new User("werneerm","almafa","asd@asd.com","Mark","Werner",""));
    }};
}
