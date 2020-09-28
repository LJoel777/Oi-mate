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

    /*
    Refactored:
    1. Services now only access their own repository, other repositories is accessed through other services -- diminshed code duplication.
    2. All urls contains session id temporally where needed.
    3. Votes in Post class now is a List.
    4. Voting again removes the vote from the vote List.

    Needs refactor:
    1. Question.js to check if session == question.userId.

    Other:
    1. Is it possible that the main page that supposed to be posts about hobby was not filtered at all? Url on frontend led to /post/hobby-news, which led to /post?
     */
}
