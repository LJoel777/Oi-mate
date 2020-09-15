package hu.joel.laczkovszki.qa.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "Costumer")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String userName;
    private String psw;
    private String emailAddress;
    private String firstName;
    private String lastName;
    @Column(columnDefinition = "TEXT")
    private String profilePicture = "https://lh3.googleusercontent.com/proxy/niIZHY2kuO9P5JoBNhtR4Z5861ZIRKhGdvUj3wcRSaC4JzpNqctYJ_wgV0gaoUMJFUOPlLA4knXf40CJrH-bbCgO3hu8ApxILofKgT3kfOdXsdSOJk6wqGk";
    @ElementCollection
    @Singular
    private List<String> fieldsOfInterests;
    @JsonBackReference(value = "friends")
    @ManyToMany
    @Singular
    private List<User> friends = new ArrayList<>();
    @JsonBackReference(value = "comments")
    @OneToMany(mappedBy = "user",cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Comment> comments = new ArrayList<>();
    @JsonBackReference(value = "posts")
    @OneToMany(mappedBy = "user",cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Post> posts = new ArrayList<>();

    public void addPost(Post post) {
        posts.add(post);
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void addFriend(User user) {
        if (user != this && !friends.contains(user))
            this.friends.add(user);
    }

}
