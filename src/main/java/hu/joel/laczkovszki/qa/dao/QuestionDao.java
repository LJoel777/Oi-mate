package hu.joel.laczkovszki.qa.dao;

import hu.joel.laczkovszki.qa.model.Question;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface QuestionDao {
    void add(Question question);

    Question find(int id);

    void remove(int id);

    void update(int id, Question question);

    List<Question> getAll();
}
