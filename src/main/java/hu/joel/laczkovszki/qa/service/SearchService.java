package hu.joel.laczkovszki.qa.service;

import hu.joel.laczkovszki.qa.infoView.PostInfoView;
import hu.joel.laczkovszki.qa.infoView.UserInfoView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SearchService {
    @Autowired
    UserService userService;

    @Autowired
    PostService postService;

    public UserInfoView getFriendByUsername(String username) {
        return userService.getUserInfoViewByUserName(username);
    }

    public Set<PostInfoView> getPostInfoViewsByTopic(String topic, Long session) {
        return postService.getPostInfoViewsByTopic(topic, session);
    }
}
