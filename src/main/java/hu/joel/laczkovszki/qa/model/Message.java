package hu.joel.laczkovszki.qa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

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
    private Date timestamp;

}
