package hu.joel.laczkovszki.qa.infoView;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostInfoView {
    private Long postId;
    private Long userId;
    private String description;
    private String imagePath;
    private List<String> categories;
    private UserInfoView userInfoView;
    private Integer voteNumber;
    private boolean isUserVoted;
}
