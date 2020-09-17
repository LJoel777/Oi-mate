package hu.joel.laczkovszki.qa.controller;

import hu.joel.laczkovszki.qa.model.Message;
import hu.joel.laczkovszki.qa.model.MessageView;
import hu.joel.laczkovszki.qa.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class MessageController {
    private MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/send-message")
    public void addMessage(@RequestBody Message message) {
        messageService.addMessage(message);
    }

    @GetMapping("/get-messages/{topic}")
    public Set<MessageView> getMessagesByTopic(@PathVariable("topic") String topic) {
        System.out.println(messageService.getMessagesByTopic(topic));
        return messageService.getMessagesByTopic(topic);
    }
}
