package hu.joel.laczkovszki.qa.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

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
    private String imagePath;
    @ElementCollection
    @Singular
    private List<String> categories;
    @JsonBackReference(value = "comments")
    @OneToMany(mappedBy = "post",cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Comment> comments;
    @ManyToOne
    private User user;

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public boolean checkCategory(String hobby) {
        return categories.contains(hobby);
    }
}
