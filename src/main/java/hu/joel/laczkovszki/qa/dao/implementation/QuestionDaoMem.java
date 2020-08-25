package hu.joel.laczkovszki.qa.dao.implementation;

import hu.joel.laczkovszki.qa.dao.QuestionDao;
import hu.joel.laczkovszki.qa.model.Error;
import hu.joel.laczkovszki.qa.model.Question;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class QuestionDaoMem implements QuestionDao {
    private static List<Question> questions = new ArrayList<>();

    @Override
    public Optional<Question> add(Question question) {
        questions.add(question);
        return find(question.getId());
    }

    @Override
    public Optional<Question> find(int id) {
        return questions.stream()
                .filter((question -> question.getId() == id))
                .findFirst();
    }

    @Override
    public void remove(int id) {
        questions.remove(questions.stream()
                .filter((question -> question.getId() == id))
                .findFirst());
    }

    @Override
    public Optional<Question> update(int id, Question updatedQuestion) {
        Optional<Question> question = find(id);
        if (question.isPresent()) {
            remove(id);
            updatedQuestion.setId(id);
            questions.add(updatedQuestion);
        }
        return find(id);
    }

    @Override
    public List<Question> getAll() {
        return questions;
    }
}
