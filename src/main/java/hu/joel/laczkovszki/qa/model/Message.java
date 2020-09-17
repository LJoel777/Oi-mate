package hu.joel.laczkovszki.qa.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "messages")
public class Message {
    @Id
    @GeneratedValue
    private Long id;
    private String topic;
    private String msg;
    private String username;

}
