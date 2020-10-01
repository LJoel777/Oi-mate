package hu.joel.laczkovszki.qa.controller;

import hu.joel.laczkovszki.qa.infoView.NotificationInfoView;
import hu.joel.laczkovszki.qa.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("notification/")
public class NotificationController {
    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("get-all/{userId}")
    public List<NotificationInfoView> getAllByUserId(@PathVariable("userId") Long userId) {
        return notificationService.getAllNotificationByUserId(userId);
    }

    @DeleteMapping("delete/{notId}")
    public void deleteNotification (@PathVariable("notId") Long notId) {
        notificationService.deleteNotification(notId);
    }
}
