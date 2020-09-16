package hu.joel.laczkovszki.qa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    @Builder.Default
    private String imagePath = "";
    @Transient
    private Long postId;
    @Transient
    private Long userId;
    @ManyToOne
    private Post post;
    @ManyToOne
    private User user;
}


