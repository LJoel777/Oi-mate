package hu.joel.laczkovszki.qa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    private String description;
    @Column(columnDefinition = "TEXT")
    private String imagePath;
    @Transient
    private Long postId;
    @Transient
    private Long userId;
    @ManyToOne
    private Post post;
    @ManyToOne
    private User user;
    @ElementCollection
    private Map<User, Integer> votes = new HashMap<>();

    public void addVote(User user, Integer vote){
        if (!votes.containsKey(user)) {
            votes.put(user, vote);
        }
    }

    public Integer didUserVoted(User user) {
        return votes.getOrDefault(user, null);
    }
}


