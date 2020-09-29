package hu.joel.laczkovszki.qa.controller;

import hu.joel.laczkovszki.qa.model.Comment;
import hu.joel.laczkovszki.qa.service.CommentService;
import hu.joel.laczkovszki.qa.service.NotificationService;
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

    @GetMapping("answersByQuestionId/{questionId}")
    public List<Comment> getAllCommentByPostId(@PathVariable("questionId") Long questionId) {
        return commentService.getCommentsMyPostId(questionId);
    }

    @GetMapping("{id}")
    public Comment getAnswer(@PathVariable("id") Long id) {
        return commentService.getCommentById(id);
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

    @GetMapping("{id}/vote/{userId}/{vote}")
    public void addVote (@PathVariable("id") Long commentId,
                         @PathVariable("userId") Long userId,
                         @PathVariable("vote") Integer vote){
        commentService.addVote(commentId, userId, vote);
    }

    @GetMapping("{id}/get-vote/{userId}")
    public Integer getVote(@PathVariable("id") Long commentID, @PathVariable("userId") Long userId) {
        Integer vote = commentService.getVote(commentID, userId);
        return vote != null ? vote : 0;
    }
}
