package hu.joel.laczkovszki.qa;

import hu.joel.laczkovszki.qa.model.Comment;
import hu.joel.laczkovszki.qa.model.Post;
import hu.joel.laczkovszki.qa.model.User;
import hu.joel.laczkovszki.qa.repository.CommentRepository;
import hu.joel.laczkovszki.qa.repository.PostRepository;
import hu.joel.laczkovszki.qa.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class QaApplication {
    @Autowired
    UserRepository userRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostRepository postRepository;

    public static void main(String[] args) {
        SpringApplication.run(QaApplication.class, args);
    }

    @Bean
    public CommandLineRunner init() {
        return args -> {
            String psw = BCrypt.hashpw("almafa",BCrypt.gensalt(10));
            User werneerm = User.builder()
                    .userName("werneerm")
                    .psw(psw)
                    .firstName("Mark")
                    .lastName("Werner")
                    .emailAddress("werneem@mark.com")
                    .fieldsOfInterest("stream")
                    .fieldsOfInterest("gaming")
                    .posts(new ArrayList<>())
                    .comments(new ArrayList<>())
                    .build();
            User joel = User.builder()
                    .userName("Szaknoel10")
                    .friend(werneerm)
                    .psw(psw)
                    .emailAddress("joel.laczkovszki@gmail.com")
                    .firstName("Joel")
                    .lastName("Laczkovszki")
                    .fieldsOfInterest("gaming")
                    .fieldsOfInterest("programing")
                    .posts(new ArrayList<>())
                    .comments(new ArrayList<>())
                    .profilePicture("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcR0IriKi0lR75APTU8DeqQqHgUG2wkGTJrO1g&usqp=CAU")
                    .build();
            User gergo = User.builder()
                    .userName("Coryon Kane")
                    .psw(psw)
                    .friend(joel)
                    .friend(werneerm)
                    .fieldsOfInterest("gaming")
                    .fieldsOfInterest("stream")
                    .fieldsOfInterest("programing")
                    .lastName("Illyes")
                    .firstName("Gergo")
                    .posts(new ArrayList<>())
                    .comments(new ArrayList<>())
                    .emailAddress("gergo@gergo.com")
                    .profilePicture("https://scontent-vie1-1.xx.fbcdn.net/v/t1.0-9/72793449_2576453445767045_7918286579754336256_n.jpg?_nc_cat=107&_nc_sid=09cbfe&_nc_ohc=7ze_ahWdAv0AX8yW9uZ&_nc_ht=scontent-vie1-1.xx&oh=4a243f16e56a977ecc3f2deb95037112&oe=5F7597D8")
                    .build();

            Post post1 = Post.builder()
                    .description("Experience enjoyable JavaScript development with WebStorm. With smart code completion, safe refactoring, and first-class support for Node.js, Angular and React. Download free trial!")
                    .category("programing")
                    .user(joel)
                    .comments(new ArrayList<>())
                    .build();
            Post post2 = Post.builder()
                    .description("They are waiting to kill you...")
                    .imagePath("https://preview.redd.it/8lb7q231wxk51.jpg?width=640&crop=smart&auto=webp&s=bd8ec36e7fc38db4f2271b92a9f7a21724b58a89")
                    .category("programing")
                    .comments(new ArrayList<>())
                    .user(gergo)
                    .build();
            Post post3 = Post.builder()
                    .description("My programming expirience in a nutshell")
                    .imagePath("https://preview.redd.it/vl4cykj0hyk51.png?width=640&crop=smart&auto=webp&s=00b6e473dd89913120d7d8ef688efb853f1ec528")
                    .category("programing")
                    .user(joel)
                    .comments(new ArrayList<>())
                    .build();
            Post post4 = Post.builder()
                    .description("Guilty")
                    .imagePath("https://preview.redd.it/o9bfkmrgzyk51.jpg?width=640&crop=smart&auto=webp&s=53569fbaeea6c43c9d429d7cfe1149d6df90c79e")
                    .category("programing")
                    .user(werneerm)
                    .comments(new ArrayList<>())
                    .build();
            Post post5 = Post.builder()
                    .description("Back in the day when five fps didn’t even matter")
                    .category("gaming")
                    .imagePath("https://preview.redd.it/zgjklki3dyk51.jpg?width=640&crop=smart&auto=webp&s=140ff481bf7cd844543b7282b6b3a258553734dc")
                    .user(gergo)
                    .comments(new ArrayList<>())
                    .build();
            Post post6 = Post.builder()
                    .description("RTX mode on")
                    .imagePath("https://i.redd.it/1c6ocbnp0yk51.jpg")
                    .category("gaming")
                    .user(werneerm)
                    .comments(new ArrayList<>())
                    .build();
            Post post7 = Post.builder()
                    .description("Halo infinite giveaway")
                    .imagePath("https://i.redd.it/taziir6viyk51.jpg")
                    .category("stream")
                    .comments(new ArrayList<>())
                    .user(joel)
                    .build();

            Comment comment1 = Comment.builder()
                    .description("the end user is the only one with an axe to grind")
                    .post(post1)
                    .user(joel)
                    .build();

            Comment comment2 = Comment.builder()
                    .description("What is the dev aiming at?")
                    .post(post2)
                    .user(gergo)
                    .build();

            Comment comment3 = Comment.builder()
                    .description("I CAN RELATE SO MUCH OMG \uD83D\uDE02")
                    .post(post3)
                    .imagePath( "https://i.redd.it/ujj5psexrsk51.jpg")
                    .user(werneerm)
                    .build();

            Comment comment4 = Comment.builder()
                    .description("My life \uD83D\uDE02 and the job offers keep coming")
                    .post(post2)
                    .user(joel)
                    .build();

            Comment comment5 = Comment.builder()
                    .description("yes, very original. My experience is very unique. /s")
                    .post(post2)
                    .user(gergo)
                    .build();

            Comment comment6 = Comment.builder()
                    .description("more like 7 red lines strictly perpendicular, some with green ink, some with transparent")
                    .post(post1)
                    .user(werneerm)
                    .build();

            Comment comment7 = Comment.builder()
                    .description("You are the expert")
                    .imagePath("data:image/jpeg;base64,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")
                    .post(post6)
                    .user(gergo)
                    .build();

            userRepository.save(werneerm);
            userRepository.save(joel);
            userRepository.save(gergo);
            postRepository.save(post1);
            postRepository.save(post2);
            postRepository.save(post3);
            postRepository.save(post4);
            postRepository.save(post5);
            postRepository.save(post6);
            postRepository.save(post7);
            commentRepository.save(comment1);
            commentRepository.save(comment2);
            commentRepository.save(comment3);
            commentRepository.save(comment4);
            commentRepository.save(comment5);
            commentRepository.save(comment6);
            commentRepository.save(comment7);
        };
    }

}
