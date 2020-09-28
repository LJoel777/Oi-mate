package hu.joel.laczkovszki.qa.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
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
    @OneToMany(mappedBy = "post",cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @Builder.Default
    @JsonIgnore
    private List<Comment> comments = new ArrayList<>();
    @ManyToOne
    private User user;
    @ElementCollection
    @JsonIgnore
    @CollectionTable(name = "votes")
    private Map<User, Integer> votes = new HashMap<>();

    public void addComment(Comment comment) {
        comments.add(comment);
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
