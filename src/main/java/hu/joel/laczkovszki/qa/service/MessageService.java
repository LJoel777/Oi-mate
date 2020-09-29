package hu.joel.laczkovszki.qa.service;

import hu.joel.laczkovszki.qa.model.Message;
import hu.joel.laczkovszki.qa.model.MessageView;
import hu.joel.laczkovszki.qa.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void addMessage(Message message) {
        messageRepository.save(message);
    }

    public List<MessageView> getMessagesByTopic(String topic) {
        List<Message> messages = messageRepository.findAllByTopicOrderByTimestamp(topic);
        List<MessageView> messageViews = new ArrayList<>();
        for (Message message: messages) {
            messageViews.add(new MessageView(message.getMsg(), message.getUsername()));
        }
        return messageViews;
    }
}