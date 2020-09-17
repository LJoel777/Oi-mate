package hu.joel.laczkovszki.qa.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "Costumer")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    //    @Column(name = "username", nullable = false, unique = true)
    private String username;
    private String psw;
    private String emailAddress;
    private String firstName;
    private String lastName;
    @Column(columnDefinition = "TEXT")
    @Builder.Default
    private String profilePicture = "https://lh3.googleusercontent.com/proxy/arWZPMKQS2bgEWOF-RtrBpMjPgImj4NQ1ZjQEgEq6uY2ORYkVVaKSGrG7IgKy4hiNMHh_zuVxdq2mPX8pgXaPr-4eSlSlv9LHyFFUatJu5k8hsfKl1mm5no";
    @ElementCollection
    @Singular
    private List<String> fieldsOfInterests;
    @JsonBackReference(value = "friends")
    @EqualsAndHashCode.Exclude
    @ManyToMany
    @Singular
    private Set<User> friends = new HashSet<>();
    @JsonBackReference(value = "comments")
    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @Builder.Default
    private List<Comment> comments = new ArrayList<>();
    @JsonBackReference(value = "posts")
    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @Builder.Default
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

    public void removeFriend(User user) {
        this.friends.remove(user);
    }


}

