package hu.joel.laczkovszki.qa.controller;


import hu.joel.laczkovszki.qa.infoView.PostInfoView;
import hu.joel.laczkovszki.qa.model.Post;
import hu.joel.laczkovszki.qa.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("post/")
public class PostController {
    private PostService postService;

    @Autowired
    public void setQuestionService(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("hobby-news/{id}")
    public Set<PostInfoView> getQuestionByHobby(@PathVariable("id") Long id) {
        return postService.getPostsByUserHobby(id);
    }

    @GetMapping("friend-news/{id}")
    public Set<PostInfoView> getQuestionsByFriend(@PathVariable("id") Long id) {
        return postService.getPostsByFriends(id);
    }

    @GetMapping("{id}/{session}")
    public PostInfoView getPost(@PathVariable("id") Long id, @PathVariable("session") Long session) {
        return postService.getPostById(id, session);
    }

    @PostMapping("add")
    public Long addQuestion(@RequestBody Post post) {
        postService.addPost(post);
        return post.getId();
    }

    @PostMapping("{id}/update")
    public void updateQuestion(@PathVariable("id") Long id, @RequestBody Post post) {
        postService.updatePostById(id, post);
    }

    @GetMapping("{id}/remove")
    public void removeQuestion(@PathVariable("id") Long id) {
        postService.removePostById(id);
    }

    @GetMapping("posts-by-user-id/{userId}")
    public Set<PostInfoView> getQuestions_byUserId(@PathVariable("userId") Long userId) {
        return postService.getAllPost_byUserId(userId);
    }

    @GetMapping("{postId}/vote/{userId}")
    public void voteOnPost(@PathVariable("postId") Long postId,
                           @PathVariable("userId") Long userId) {
        postService.addVote(postId, userId);
    }
}
