package hu.joel.laczkovszki.qa.testData;

import hu.joel.laczkovszki.qa.model.User;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

public class TestUserData {
    public static List<User> userList = new ArrayList<>(){{
        List<String> hobbies = new ArrayList<>();
        hobbies.add("stream");
        hobbies.add("gaming");
        hobbies.add("programing");
        String psw = BCrypt.hashpw("almafa",BCrypt.gensalt(10));
        add(new User("werneerm",psw,"werneem@mark.com","Mark","Werner","", hobbies, null)   );
        add(new User("Joel",psw,"joel.laczkovszki@gmail.com","Joel","Laczkovszki","https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcR0IriKi0lR75APTU8DeqQqHgUG2wkGTJrO1g&usqp=CAU", hobbies, new ArrayList<>(Arrays.asList(0, 1))));
        add(new User("Bence",psw,"bece@bence.com","Bence","Kovács","https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQqMFVc0af6Vxc8UKBootbFQJPfPF-mKyM0hg&usqp=CAU", Arrays.asList("programing", "stream"), null));
        add(new User("Coryon Kane",psw,"gergo@gergo.com","Gergő","Illyés","https://scontent-vie1-1.xx.fbcdn.net/v/t1.0-9/72793449_2576453445767045_7918286579754336256_n.jpg?_nc_cat=107&_nc_sid=09cbfe&_nc_ohc=7ze_ahWdAv0AX8yW9uZ&_nc_ht=scontent-vie1-1.xx&oh=4a243f16e56a977ecc3f2deb95037112&oe=5F7597D8", Arrays.asList("programing", "gaming"), null));
    }};
}
