package hu.joel.laczkovszki.qa.controller;

import hu.joel.laczkovszki.qa.model.Comment;
import hu.joel.laczkovszki.qa.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/answersByQuestionId/{questionId}")
    public List<Comment> getAllCommentByPostId(@PathVariable("questionId") Long questionId) {
        return commentService.getCommentsMyPostId(questionId);
    }

    @GetMapping("/answer/{id}")
    public Comment getAnswer(@PathVariable("id") Long id) {
        return commentService.getCommentById(id);
    }

    @PostMapping("/answer/add")
    public Long addAnswer(@RequestBody Comment comment) {
        commentService.addComment(comment);
        return comment.getPostId();
    }

    @PostMapping("/answer/{id}/update")
    public Long updateAnswer(@PathVariable("id") Long id, @RequestBody Comment comment) {
        Long postId = commentService.getCommentById(id).getPost().getId();
        commentService.updateCommentById(id, comment);
        return postId;
    }

    @GetMapping("/answer/{id}/remove")
    public void removeAnswer(@PathVariable("id") Long id) {
        commentService.removeCommentById(id);
    }
}
