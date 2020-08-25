package hu.joel.laczkovszki.qa.controller;

import hu.joel.laczkovszki.qa.service.questionService;
import hu.joel.laczkovszki.qa.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class QAndAController {
    private questionService questionService;

    @Autowired
    public void setQuestionService(questionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/questions")
    public List<Question> getQuestions() {
        return questionService.getAllQuestion();
    }

    @GetMapping("/question/{id}")
    public Question getQuestion(@PathVariable("id") int id) {
        return questionService.getQuestionById(id);
    }

    @PostMapping("/question/add")
    public Question addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }

    @PostMapping("/question/{id}/update")
    public Question updateQuestion(@PathVariable("id") int id, @RequestBody Question question) {
        return questionService.updateQuestionById(id, question);
    }

    @GetMapping("question/{id}/remove")
    public void removeQuestion(@PathVariable("id") int id) {
        questionService.removeQuestionById(id);
    }
}
