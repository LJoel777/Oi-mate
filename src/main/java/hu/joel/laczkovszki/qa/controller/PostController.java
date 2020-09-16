package hu.joel.laczkovszki.qa.controller;


import hu.joel.laczkovszki.qa.model.Post;
import hu.joel.laczkovszki.qa.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PostController {
    private PostService postService;

    @Autowired
    public void setQuestionService(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/hobby-news/{id}")
    public List<Post> getQuestionByHobby (@PathVariable("id") Long id) {
        return postService.getPostsByUserHobby(id);
    }
//
//    @GetMapping("/friend-news/{id}")
//    public List<Post> getQuestionsByFriend (@PathVariable("id") Long id) {
//        return postService.getPostsByFriends(id);
//    }

    @GetMapping("/posts")
    public List<Post> getPosts() {
        return postService.getAllPost();
    }

    @GetMapping("/post/{id}")
    public Post getPost(@PathVariable("id") Long id) {
        return postService.getPostById(id);
    }

    @PostMapping("/post/add")
    public Long addQuestion(@RequestBody Post post) {
        postService.addPost(post);
        return post.getId();
    }

    @PostMapping("/post/{id}/update")
    public void updateQuestion(@PathVariable("id") Long id, @RequestBody Post post) {
        postService.updatePostById(id, post);
    }

    @GetMapping("post/{id}/remove")
    public void removeQuestion(@PathVariable("id") Long id) {
        postService.removePostById(id);
    }

    @GetMapping("posts-by-user-id/{userId}")
    public List<Post> getQuestions_byUserId(@PathVariable("userId") Long userId) {
        return postService.getAllPost_byUserId(userId);
    }
}
