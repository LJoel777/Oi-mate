package hu.joel.laczkovszki.qa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "notification")
public class Notification {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    @Enumerated(EnumType.STRING)
    NotificationType notificationType;

    @JsonIgnore
    @ManyToOne
    @NonNull
    User owner;



    @JsonIgnore
    @OneToOne
    @NonNull
    User sender;



    @JsonIgnore
    @OneToOne
    Post post;
}
