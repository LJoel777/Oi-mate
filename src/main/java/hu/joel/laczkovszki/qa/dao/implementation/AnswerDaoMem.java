package hu.joel.laczkovszki.qa.dao.implementation;

import hu.joel.laczkovszki.qa.dao.AnswerDao;
import hu.joel.laczkovszki.qa.dao.CRUDInterface;
import hu.joel.laczkovszki.qa.exception.ApiRequestException;
import hu.joel.laczkovszki.qa.model.Answer;
import hu.joel.laczkovszki.qa.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AnswerDaoMem implements AnswerDao {
    private static List<Answer> answers;
    private final CRUDInterface<Question> questionDao;

    @Autowired
    public static void setAnswers(List<Answer> answers) {
        AnswerDaoMem.answers = answers;
    }

    @Autowired
    public AnswerDaoMem(QuestionDaoMem questionDao) {
        this.questionDao = questionDao;
    }

    @Override
    public void add(Answer answer) {
        int questionId = answer.getQuestionId();
        questionDao.find(questionId);
        answers.add(answer);
    }

    @Override
    public Answer find(int id) {
        return answers.stream()
                .filter((answer -> answer.getId() == id))
                .findFirst()
                .orElseThrow(() -> new ApiRequestException("Answer id not found" + "(" + id + ")"));
    }

    @Override
    public void remove(int id) {
        answers.remove(answers.stream()
                .filter((answer -> answer.getId() == id))
                .findFirst()
                .orElseThrow(() -> new ApiRequestException("Answer id not found" + "(" + id + ")")));
    }

    @Override
    public void update(int id, Answer updateAnswer) {
        Answer answer = find(id);
        remove(id);
        updateAnswer.setId(id);
        updateAnswer.setQuestionId(answer.getQuestionId());
        updateAnswer.setUserId(answer.getUserId());
        answers.add(updateAnswer);
    }

    @Override
    public List<Answer> getAll() {
        return null;
    }

    @Override
    public List<Answer> getAnswersByQuestionId(int questionId) {
        questionDao.find(questionId);
        return answers.stream()
                .filter((answer -> answer.getQuestionId() == questionId))
                .collect(Collectors.toList());
    }

    @Override
    public void removeAnswersByQuestionId(int questionId) {
        List<Answer> deletedAnswers = answers.stream()
                .filter((answer -> answer.getQuestionId() == questionId)).collect(Collectors.toList());
        if (deletedAnswers.size() > 0)
            deletedAnswers.forEach(answer -> remove(answer.getId()));
    }
}
