package hu.joel.laczkovszki.qa.service;

import hu.joel.laczkovszki.qa.infoView.CommentInfoView;
import hu.joel.laczkovszki.qa.infoView.PostInfoView;
import hu.joel.laczkovszki.qa.infoView.UserInfoView;
import hu.joel.laczkovszki.qa.model.Comment;
import hu.joel.laczkovszki.qa.model.Post;
import hu.joel.laczkovszki.qa.model.User;
import hu.joel.laczkovszki.qa.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    @Autowired
    PostService postService;

    @Autowired
    UserService userService;

    @Autowired
    NotificationService notificationService;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public void addComment(Comment comment) {
        Post post = postService.getPostById(comment.getPostId());
        User user = userService.getUserById(comment.getUserId());
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

    public CommentInfoView getCommentInfoViewById (Long id, Long session) {
        Comment comment = getCommentById(id);
        if (comment != null) {
            return convertCommentToInfoView(comment, session);
        }
        return null;
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

    public List<CommentInfoView> getCommentInfoViewsByMyPostId(Long questionId, Long session) {
        List<Comment> comments = commentRepository.getAllByPostId(questionId);
        List<CommentInfoView> commentInfoViews= new ArrayList<>();
        comments.forEach(comment -> commentInfoViews.add(convertCommentToInfoView(comment, session)));
        return commentInfoViews;
    }

    public void addNotification(Comment comment) {
        notificationService.addCommentNotification(comment);
    }

    public CommentInfoView convertCommentToInfoView (Comment comment, Long session) {
        UserInfoView user = userService.convertUser(comment.getUser());
        PostInfoView post = postService.getPostInfoViewById(comment.getPost().getId(), session);
        return CommentInfoView.builder()
                .id(comment.getId())
                .description(comment.getDescription())
                .imagePath(comment.getImagePath())
                .user(user)
                .post(post)
                .build();
    }
}
