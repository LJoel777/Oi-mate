package hu.joel.laczkovszki.qa.service;

import hu.joel.laczkovszki.qa.dao.CRUDInterface;
import hu.joel.laczkovszki.qa.dao.implementation.QuestionDaoMem;
import hu.joel.laczkovszki.qa.model.Question;
import hu.joel.laczkovszki.qa.testData.TestQuestionData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    private final CRUDInterface<Question> questionDao;
    private final AnswerService answerService;

    @Autowired
    public QuestionService(QuestionDaoMem questionDao, AnswerService answerService) {
        this.questionDao = questionDao;
        QuestionDaoMem.setQuestions(TestQuestionData.questionList);
        this.answerService = answerService;
    }

    public void addQuestion(Question question) {
        questionDao.add(question);
    }

    public Question getQuestionById(int id) {
        return questionDao.find(id);
    }

    public void removeQuestionById(int id) {
        answerService.removeAnswersByQuestionId(id);
        questionDao.remove(id);
    }

    public void updateQuestionById(int id, Question question) {
        questionDao.update(id, question);
    }

    public List<Question> getAllQuestion() {
        return questionDao.getAll();
    }
}
