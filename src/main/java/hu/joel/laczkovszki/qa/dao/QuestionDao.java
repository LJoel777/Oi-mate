package hu.joel.laczkovszki.qa.dao;

import hu.joel.laczkovszki.qa.dao.CRUDInterface;
import hu.joel.laczkovszki.qa.model.Question;

import java.util.List;

public interface QuestionDao  extends CRUDInterface<Question> {
    List<Question> getAllQuestion_byUserId(int userId);
}
