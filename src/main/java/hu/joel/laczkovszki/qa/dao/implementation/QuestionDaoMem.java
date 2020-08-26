package hu.joel.laczkovszki.qa.dao.implementation;

import hu.joel.laczkovszki.qa.dao.QuestionDao;
import hu.joel.laczkovszki.qa.exception.ApiRequestException;
import hu.joel.laczkovszki.qa.model.Question;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class QuestionDaoMem implements QuestionDao {
    private static List<Question> questions = new ArrayList<>();

    @Override
    public void add(Question question) {
        questions.add(question);
    }

    @Override
    public Question find(int id) {
        return questions.stream()
                .filter((question -> question.getId() == id))
                .findFirst()
                .orElseThrow(() -> new ApiRequestException("Id not found" + "(" + id + ")"));
    }

    @Override
    public void remove(int id) {
        questions.remove(questions.stream()
                .filter((question -> question.getId() == id))
                .findFirst()
                .orElseThrow(() -> new ApiRequestException("Id not found" + "(" + id + ")")));
    }

    @Override
    public void update(int id, Question updatedQuestion) {
        Optional<Question> question = Optional.ofNullable(find(id));
        if (question.isPresent()) {
            remove(id);
            updatedQuestion.setId(id);
            questions.add(updatedQuestion);
        }
    }

    @Override
    public List<Question> getAll() {
        return questions;
    }
}
