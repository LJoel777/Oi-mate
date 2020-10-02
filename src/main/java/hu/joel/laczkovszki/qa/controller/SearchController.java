package hu.joel.laczkovszki.qa.controller;

import hu.joel.laczkovszki.qa.infoView.PostInfoView;
import hu.joel.laczkovszki.qa.infoView.UserInfoView;
import hu.joel.laczkovszki.qa.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("search/")
public class SearchController {
    private final SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("friend")
    public Long searchFriendByUsername (@RequestParam(name = "username") String username) {
        return (searchService.getFriendByUsername(username) == null ? null : searchService.getFriendByUsername(username).getId());
    }

    @GetMapping("topic/{session}")
    public Set<PostInfoView> searchByTopic (@RequestParam(name = "topic") String topic, @PathVariable("session") Long session) {
        return searchService.getPostInfoViewsByTopic(topic, session);
    }
}
