package hu.joel.laczkovszki.qa.daoTests;

import static org.junit.Assert.*;

import hu.joel.laczkovszki.qa.dao.AnswerDao;
import hu.joel.laczkovszki.qa.dao.CRUDInterface;
import hu.joel.laczkovszki.qa.dao.implementation.AnswerDaoMem;
import hu.joel.laczkovszki.qa.dao.implementation.QuestionDaoMem;
import static org.mockito.Mockito.*;

import hu.joel.laczkovszki.qa.exception.ApiRequestException;
import hu.joel.laczkovszki.qa.model.Answer;
import hu.joel.laczkovszki.qa.model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class AnswerDaoMemTest {
    AnswerDao answerDao;
    CRUDInterface<Question> questionDao;

    @BeforeEach
    public void init() {
        questionDao = mock(QuestionDaoMem.class);
        answerDao = new AnswerDaoMem((QuestionDaoMem) questionDao);
        AnswerDaoMem.setAnswers(new ArrayList<>());
    }

    @Test
    public void addAnswer_withExistingQuestionId() {
        int answerId = 0;
        when(questionDao.find(0)).thenReturn(new Question("test", "test", "test"));
        Answer answer = new Answer("Test", "test", 0);
        answer.setId(answerId);
        answerDao.add(answer);
        assertEquals(answerDao.find(answerId), answer);
    }

    @Test
    public void addAnswer_withNonExistingQuestionId_throwApiRequestException() {
        when(questionDao.find(2)).thenThrow(new ApiRequestException("Question id not found (2)"));
        Answer answer = new Answer("test", "test", 2);
        Exception exception = assertThrows(ApiRequestException.class, () -> answerDao.add(answer));
        assertEquals(exception.getMessage(), "Question id not found (2)");
    }

    @Test
    public void findAnswer_withExistingId_returnAnswer() {
        int answerId = 2;
        Answer answer = new Answer("test", "test", 0);
        answer.setId(answerId);
        answerDao.add(answer);
        assertEquals(answerDao.find(answerId), answer);
    }

    @Test
    public void finsAnswer_withNonExistingId_throwApiRequestException() {
        int answerId = 100;
        Exception exception = assertThrows(ApiRequestException.class, () -> answerDao.find(answerId));
        assertEquals(exception.getMessage(), "Answer id not found(100)");
    }


    @Test
    public void removeAnswer_withExistingId() {
        int answerId1 = 1;
        int answerId2 = 2;
        int answerId3 = 3;
        Answer answer1 = new Answer("test", "test", 0);
        Answer answer2 = new Answer("test", "test", 0);
        Answer answer3 = new Answer("test", "test", 0);
        answer1.setId(answerId1);
        answer2.setId(answerId2);
        answer3.setId(answerId3);
        answerDao.add(answer1);
        answerDao.add(answer2);
        answerDao.add(answer3);
        ArrayList<Answer> result = new ArrayList<>(){{
            add(answer2);
            add(answer3);
        }};

        answerDao.remove(answerId1);
        assertEquals(answerDao.getAnswersByQuestionId(0), result);
    }
}
