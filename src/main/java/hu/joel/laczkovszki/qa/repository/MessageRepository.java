package hu.joel.laczkovszki.qa.repository;

import hu.joel.laczkovszki.qa.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Set;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findAllByTopicOrderByTimestamp(String topic);
}
