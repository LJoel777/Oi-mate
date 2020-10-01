package hu.joel.laczkovszki.qa.infoView;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentInfoView {
    private Long id;
    private String description;
    private String imagePath;
    private UserInfoView user;
    private PostInfoView post;
}
