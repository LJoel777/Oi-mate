package hu.joel.laczkovszki.qa.service;

import hu.joel.laczkovszki.qa.model.*;
import hu.joel.laczkovszki.qa.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private final NotificationRepository notificationRepository;

    @Autowired
    PostService postService;
    @Autowired
    UserService userService;

    @Autowired
    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void addCommentNotification(Comment comment) {
        Post post = postService.getPostById(comment.getPostId());
        User owner = post.getUser();
        User sender = userService.getNormalUser(comment.getUserId());
        Notification notification = Notification.builder()
                .notificationType(NotificationType.COMMENT)
                .owner(owner)
                .sender(sender)
                .post(post)
                .build();
        notificationRepository.save(notification);
    }

    public void addPostVoteNotification(User user, Post post) {
        Notification notification = Notification.builder()
                .notificationType(NotificationType.VOTE)
                .owner(post.getUser())
                .sender(user)
                .post(post)
                .build();
        notificationRepository.save(notification);
    }

    public void addFriendRequestNotification(User sender, User owner) {
        Notification notification = Notification.builder()
                .notificationType(NotificationType.FRIENDREQUEST)
                .owner(owner)
                .sender(sender)
                .post(null)
                .build();
        notificationRepository.save(notification);
    }
}