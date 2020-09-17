package hu.joel.laczkovszki.qa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Session {
    private String username;
    private boolean isValid;
    private Long id;
    private List<String> hobbies;
}