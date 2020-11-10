package hu.joel.laczkovszki.qa.dao;

import hu.joel.laczkovszki.qa.model.Answer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AnswerDao extends CRUDInterface<Answer>{
    List<Answer> getAnswersByQuestionId(int questionId);

    void removeAnswersByQuestionId(int questionId);
}
