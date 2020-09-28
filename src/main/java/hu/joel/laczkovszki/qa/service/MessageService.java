package hu.joel.laczkovszki.qa.service;

import hu.joel.laczkovszki.qa.model.Message;
import hu.joel.laczkovszki.qa.model.MessageView;
import hu.joel.laczkovszki.qa.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class MessageService {
    private MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void addMessage(Message message) {
        messageRepository.save(message);
    }

    public Set<MessageView> getMessagesByTopic(String topic) {
        Set<Message> messages = messageRepository.findAllByTopic(topic);
        Set<MessageView> messageViews = new HashSet<>();
        for (Message message: messages) {
            messageViews.add(new MessageView(message.getMsg(), message.getUsername()));
        }
        return messageViews;
    }
}
