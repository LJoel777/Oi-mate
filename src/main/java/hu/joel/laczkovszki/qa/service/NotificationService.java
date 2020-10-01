package hu.joel.laczkovszki.qa.service;

import hu.joel.laczkovszki.qa.infoView.NotificationInfoView;
import hu.joel.laczkovszki.qa.model.*;
import hu.joel.laczkovszki.qa.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        User sender = userService.getUserById(comment.getUserId());
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

    public List<NotificationInfoView> getAllNotificationByUserId(Long userId) {
        User user = userService.getUserById(userId);
        if (user!= null) {
            List<Notification> notifications= user.getNotifications();
            List<NotificationInfoView> notificationInfoViews = new ArrayList<>();
            notifications.forEach(not -> {
                notificationInfoViews.add(NotificationInfoView.builder()
                        .notificationType(not.getNotificationType())
                        .ownerId(not.getOwner().getId())
                        .senderId(not.getSender().getId())
                        .postId(not.getPost().getId())
                        .id(not.getId())
                        .build());
            });
            return notificationInfoViews;
        }
        return new ArrayList<>();
    }

    public void deleteNotification(Long notId) {
        notificationRepository.deleteById(notId);

    }
}
