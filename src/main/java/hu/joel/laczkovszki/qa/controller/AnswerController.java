package hu.joel.laczkovszki.qa.controller;

import hu.joel.laczkovszki.qa.model.Answer;
import hu.joel.laczkovszki.qa.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AnswerController {
    private AnswerService answerService;

    @Autowired
    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping("/answersByQuestionId/{questionId}")
    public List<Answer> getAnswersByQuestionId(@PathVariable("questionId") int questionId) {
        return answerService.getAnswersByQuestionId(questionId);
    }

    @GetMapping("/answer/{id}")
    public Answer getAnswer(@PathVariable("id") int id) {
        return answerService.getAnswerById(id);
    }

    @PostMapping("/answer/add")
    public int addAnswer(@RequestBody Answer answer) {
        answerService.addAnswer(answer);
        return answer.getQuestionId();
    }

    @PostMapping("/answer/{id}/update")
    public void updateAnswer(@PathVariable("id") int id, @RequestBody Answer answer) {
        answerService.updateAnswerById(id, answer);
    }

    @GetMapping("/answer/{id}/remove")
    public void removeAnswer(@PathVariable("id") int id) {
        answerService.removeAnswerById(id);
    }

    @GetMapping("/answersByQuestionId/{questionId}/remove")
    public void removeAnswersByQuestionId(@PathVariable("questionId") int questionId) {
        answerService.removeAnswersByQuestionId(questionId);
    }
}
