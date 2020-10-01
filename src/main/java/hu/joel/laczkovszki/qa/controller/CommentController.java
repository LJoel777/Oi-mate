package hu.joel.laczkovszki.qa.controller;

import hu.joel.laczkovszki.qa.infoView.CommentInfoView;
import hu.joel.laczkovszki.qa.model.Comment;
import hu.joel.laczkovszki.qa.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("answer/")
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("answersByQuestionId/{questionId}/{session}")
    public List<CommentInfoView> getAllCommentByPostId(@PathVariable("questionId") Long questionId, @PathVariable("session") Long session) {
        return commentService.getCommentInfoViewsByMyPostId(questionId, session);
    }

    @GetMapping("{id}/{session}")
    public CommentInfoView getAnswer(@PathVariable("id") Long id, @PathVariable("session") Long session) {
        return commentService.getCommentInfoViewById(id, session);
    }

    @PostMapping("add")
    public Long addAnswer(@RequestBody Comment comment) {
        commentService.addComment(comment);
        return comment.getPostId();
    }

    @PostMapping("{id}/update")
    public Long updateAnswer(@PathVariable("id") Long id, @RequestBody Comment comment) {
        Long postId = commentService.getCommentById(id).getPost().getId();
        commentService.updateCommentById(id, comment);
        return postId;
    }

    @GetMapping("{id}/remove")
    public void removeAnswer(@PathVariable("id") Long id) {
        commentService.removeCommentById(id);
    }
}
