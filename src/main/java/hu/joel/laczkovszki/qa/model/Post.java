package hu.joel.laczkovszki.qa.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Post {
    @Id
    @GeneratedValue
    private Long id;
    @Transient
    private Long userId;
    private String description;
    @Builder.Default
    private String imagePath = "";
    @ElementCollection
    @Singular
    private List<String> categories = new ArrayList<>();
    @JsonBackReference(value = "comments")
    @OneToMany(mappedBy = "post",cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @Builder.Default
    private List<Comment> comments = new ArrayList<>();
    @ManyToOne
    private User user;
    @ElementCollection
    private Map<User, Integer> votes = new HashMap<>();

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public boolean checkCategory(String hobby) {
        return categories.contains(hobby);
    }

    public void addVote(User user, Integer vote){
        if (!votes.containsKey(user)) {
            votes.put(user, vote);
        }
    }

    public Integer didUserVoted(User user) {
        return votes.getOrDefault(user, null);
    }
}
