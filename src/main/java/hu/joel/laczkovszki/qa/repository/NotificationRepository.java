package hu.joel.laczkovszki.qa.repository;

import hu.joel.laczkovszki.qa.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification,Long> {


}
