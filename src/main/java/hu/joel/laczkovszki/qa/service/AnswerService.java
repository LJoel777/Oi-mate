package hu.joel.laczkovszki.qa.service;

import hu.joel.laczkovszki.qa.dao.AnswerDao;
import hu.joel.laczkovszki.qa.dao.implementation.AnswerDaoMem;
import hu.joel.laczkovszki.qa.model.Answer;
import hu.joel.laczkovszki.qa.testData.TestAnswerData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {
    private final AnswerDao answerDao;

    @Autowired
    public AnswerService(AnswerDaoMem answerDaoMem) {
        this.answerDao = answerDaoMem;
        AnswerDaoMem.setAnswers(TestAnswerData.answerList);
    }

    public void addAnswer(Answer answer) {
        answerDao.add(answer);
    }

    public Answer getAnswerById(int id) {
        return answerDao.find(id);
    }

    public void removeAnswerById(int id) {
        answerDao.remove(id);
    }

    public void updateAnswerById(int id, Answer answer) {
        answerDao.update(id, answer);
    }

    public List<Answer> getAnswersByQuestionId(int questionId) {
        return answerDao.getAnswersByQuestionId(questionId);
    }

    public void removeAnswersByQuestionId(int questionId) {
        answerDao.removeAnswersByQuestionId(questionId);
    }
}
