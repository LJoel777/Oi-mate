package hu.joel.laczkovszki.qa.infoView;

import hu.joel.laczkovszki.qa.model.NotificationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NotificationInfoView {
    private Long id;
    private NotificationType notificationType;
    private Long ownerId;
    private Long senderId;
    private Long postId;
}
