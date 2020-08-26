package hu.joel.laczkovszki.qa.dao;

import hu.joel.laczkovszki.qa.model.Answer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AnswerDao {
    void add(Answer answer);

    Answer find(int id);

    void remove(int id);

    void update(int id, Answer updatedAnswer);

    List<Answer> getAnswersByQuestionId(int questionId);

    void removeAnswersByQuestionId(int questionId);
}
