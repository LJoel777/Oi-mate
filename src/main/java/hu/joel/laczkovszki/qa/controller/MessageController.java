package hu.joel.laczkovszki.qa.controller;

import hu.joel.laczkovszki.qa.model.Message;
import hu.joel.laczkovszki.qa.model.MessageView;
import hu.joel.laczkovszki.qa.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("message/")
public class MessageController {
    private MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("send-message")
    public void addMessage(@RequestBody Message message) {
        message.setTimestamp(new Date());
        messageService.addMessage(message);
    }

    @GetMapping("get-messages/{topic}")
    public List<MessageView> getMessagesByTopic(@PathVariable("topic") String topic) {
        System.out.println(messageService.getMessagesByTopic(topic));
        return messageService.getMessagesByTopic(topic);
    }
}
