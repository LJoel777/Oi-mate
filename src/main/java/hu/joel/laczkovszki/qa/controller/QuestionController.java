package hu.joel.laczkovszki.qa.controller;


import hu.joel.laczkovszki.qa.service.QuestionService;
import hu.joel.laczkovszki.qa.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class QuestionController {
    private QuestionService questionService;

    @Autowired
    public void setQuestionService(QuestionService questionService) {
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
    public void addQuestion(@RequestBody Question question) {
        questionService.addQuestion(question);
    }

    @PostMapping("/question/{id}/update")
    public void updateQuestion(@PathVariable("id") int id, @RequestBody Question question) {
        questionService.updateQuestionById(id, question);
    }

    @GetMapping("question/{id}/remove")
    public String removeQuestion(@PathVariable("id") int id) {
        questionService.removeQuestionById(id);
        return "/answersByQuestionId/{questionId}/remove";
    }
}
