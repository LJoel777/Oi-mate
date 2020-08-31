package hu.joel.laczkovszki.qa.dao.implementation;

import hu.joel.laczkovszki.qa.dao.QuestionDao;
import hu.joel.laczkovszki.qa.exception.ApiRequestException;
import hu.joel.laczkovszki.qa.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuestionDaoMem implements QuestionDao {
    private static List<Question> questions;

    @Autowired
    public static void setQuestions(List<Question> questions) {
        QuestionDaoMem.questions = questions;
    }

    @Override
    public void add(Question question) {
        questions.add(question);
    }

    @Override
    public Question find(int id) {
        return questions.stream()
                .filter((question -> question.getId() == id))
                .findFirst()
                .orElseThrow(() -> new ApiRequestException("Question id not found" + "(" + id + ")"));
    }

    @Override
    public void remove(int id) {
        questions.remove(questions.stream()
                .filter((question -> question.getId() == id))
                .findFirst()
                .orElseThrow(() -> new ApiRequestException("Question id not found" + "(" + id + ")")));
    }

    @Override
    public void update(int id, Question updatedQuestion) {
        remove(id);
        updatedQuestion.setId(id);
        questions.add(updatedQuestion);
    }

    @Override
    public List<Question> getAll() {
        return questions;
    }
}
