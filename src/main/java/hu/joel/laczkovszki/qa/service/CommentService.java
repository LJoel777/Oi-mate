package hu.joel.laczkovszki.qa.service;

import hu.joel.laczkovszki.qa.model.Comment;
import hu.joel.laczkovszki.qa.model.Post;
import hu.joel.laczkovszki.qa.model.User;
import hu.joel.laczkovszki.qa.repository.CommentRepository;
import hu.joel.laczkovszki.qa.repository.PostRepository;
import hu.joel.laczkovszki.qa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final NotificationService notificationService;

    @Autowired
    public CommentService(CommentRepository commentRepository, PostRepository postRepository, UserRepository userRepository, NotificationService notificationService) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.notificationService = notificationService;
    }

    public void addComment(Comment comment) {
        Post post = postRepository.findById(comment.getPostId()).orElse(null);
        User user = userRepository.findById(comment.getUserId()).orElse(null);
        if (post != null && user != null) {
            addNotification(comment);
            comment.setUser(user);
            comment.setPost(post);
            post.addComment(comment);
            user.addComment(comment);
            commentRepository.save(comment);
        }
    }

    public Comment getCommentById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    public void removeCommentById(Long id) {
        commentRepository.deleteById(id);
    }

    public void updateCommentById(Long id, Comment comment) {
        Comment updatedComment = commentRepository.getOne(id);
        updatedComment.setDescription(comment.getDescription());
        updatedComment.setImagePath(comment.getImagePath());
        commentRepository.saveAndFlush(updatedComment);
    }

    public List<Comment> getCommentsMyPostId(Long questionId) {
        return commentRepository.getAllByPostId(questionId);
    }

    public void addVote(Long commentId, Long userId, Integer vote) {
        Comment comment = commentRepository.findById(commentId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);
        if (comment != null && user != null && (vote == 1 || vote == -1)) {
            comment.addVote(user, vote);
            commentRepository.save(comment);
        }
    }

    public Integer getVote(Long commentId, Long userId) {
        Comment comment = commentRepository.findById(commentId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);
        return (comment != null && user != null) ? comment.didUserVoted(user) : null;
    }

    public void addNotification(Comment comment) {
        notificationService.addCommentNotification(comment);

    }
}
