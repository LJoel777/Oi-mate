package hu.joel.laczkovszki.qa.infoView;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInfoView {
    private Long id;
    private String username;
    private String emailAddress;
    private String firstName;
    private String lastName;
    private String profilePicture;
    private List<String> fieldsOfInterests;
    private Set<Long> friends;
}
