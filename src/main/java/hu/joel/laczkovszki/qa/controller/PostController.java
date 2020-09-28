package hu.joel.laczkovszki.qa.controller;


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
    public List<Post> getQuestionByHobby(@PathVariable("id") Long id) {
        System.out.println("na");
        return postService.getPostsByUserHobby(id);
    }

    @GetMapping("friend-news/{id}")
    public Set<Post> getQuestionsByFriend(@PathVariable("id") Long id) {
        return postService.getPostsByFriends(id);
    }

    @GetMapping("posts")
    public List<Post> getPosts() {
        return postService.getAllPost();
    }

    @GetMapping("{id}")
    public Post getPost(@PathVariable("id") Long id) {
        return postService.getPostById(id);
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
    public List<Post> getQuestions_byUserId(@PathVariable("userId") Long userId) {
        return postService.getAllPost_byUserId(userId);
    }

    @GetMapping("{postId}/vote/{userId}/{vote}")
    public void voteOnPost(@PathVariable("postId") Long postId,
                           @PathVariable("userId") Long userId,
                           @PathVariable("vote") Integer vote) {
        postService.addVote(postId, userId, vote);
    }

    @GetMapping("{postId}/get-vote/{userId}")
    public Integer getVote(@PathVariable("postId") Long postID, @PathVariable("userId") Long userId) {
        Integer vote = postService.getVote(postID, userId);
        return vote != null ? vote : 0;
    }
}
