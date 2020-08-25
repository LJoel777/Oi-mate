package hu.joel.laczkovszki.qa.service;

import hu.joel.laczkovszki.qa.dao.QuestionDao;
import hu.joel.laczkovszki.qa.dao.implementation.QuestionDaoMem;
import hu.joel.laczkovszki.qa.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class questionService {
    private QuestionDao questionDao;

    @Autowired
    public questionService(QuestionDaoMem questionDao) {
        this.questionDao = questionDao;
    }

    public Question addQuestion(Question question) {
        return questionDao.add(question).get();
    }

    public Question getQuestionById(int id) {
        return questionDao.find(id).get();
    }

    public void removeQuestionById(int id) {
        questionDao.remove(id);
    }

    public Question updateQuestionById(int id, Question question) {
        return questionDao.update(id, question).get();
    }

    public List<Question> getAllQuestion() {
        return questionDao.getAll();
    }
}
