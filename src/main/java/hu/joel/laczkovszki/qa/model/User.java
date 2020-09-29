package hu.joel.laczkovszki.qa.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "Costumer")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    private String psw;
    private String emailAddress;
    private String firstName;
    private String lastName;
    @Column(columnDefinition = "TEXT")
    @Builder.Default
    private String profilePicture = "data:image/jpeg;base64,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";
    @ElementCollection
    @Singular
    private List<String> fieldsOfInterests;
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @ManyToMany
    @Singular
    private Set<User> friends = new HashSet<>();
    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @Builder.Default
    private List<Comment> comments = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @Builder.Default
    private List<Post> posts = new ArrayList<>();
    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> roles = new ArrayList<>();

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

