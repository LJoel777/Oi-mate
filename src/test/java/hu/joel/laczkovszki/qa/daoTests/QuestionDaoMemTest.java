package hu.joel.laczkovszki.qa.daoTests;

import hu.joel.laczkovszki.qa.dao.QuestionDao;
import hu.joel.laczkovszki.qa.dao.implementation.QuestionDaoMem;
import hu.joel.laczkovszki.qa.exception.ApiRequestException;
import hu.joel.laczkovszki.qa.model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.*;

import java.util.ArrayList;

@SpringBootTest
public class QuestionDaoMemTest {
    QuestionDaoMem questionDaoMem;

    @BeforeEach
    public void init() {
        questionDaoMem = new QuestionDaoMem();
        QuestionDaoMem.setQuestions(new ArrayList<>());
    }

    @Test
    public void addQuestion() {
        int id = 0;
        Question question = new Question("test", "test", "test");
        question.setId(id);
        questionDaoMem.add(question);
        assertEquals(question, questionDaoMem.find(id));
    }

    @Test
    public void findQuestion_withExistingId() {
        int id = 0;
        Question question = new Question("test", "test", "test");
        question.setId(id);
        questionDaoMem.add(question);
        assertEquals(question, questionDaoMem.find(id));
    }

    @Test
    public void findQuestion_withNonExistingId_throwApiRequestException() {
        int nonExistingId = 0;
        assertThrows(ApiRequestException.class, () -> questionDaoMem.find(nonExistingId));
    }

    @Test
    public void removeQuestion_withExistingId() {
        int id = 0;
        for (int i = 0; i <= 3; i++) {
            Question question = new Question("test", "test", "test");
            question.setId(i);
            questionDaoMem.add(question);
        }
        questionDaoMem.remove(id);
        int expectedSize = 3;
        assertEquals(expectedSize, questionDaoMem.getAll().size());
    }

    @Test
    public void removeQuestion_withNonExistingId_throwApiRequestException() {
        int nonExistingId = 2000;
        Exception exception = assertThrows(ApiRequestException.class, () -> questionDaoMem.remove(nonExistingId));
        assertEquals("Question id not found(2000)", exception.getMessage());
    }

    @Test
    public void updateQuestion_withExistingId() {
        int id = 0;
        Question question = new Question("test", "test", "test");
        question.setId(id);
        questionDaoMem.add(question);
        Question updateQuestion = new Question("updated", "updated", "updated");
        questionDaoMem.update(id, updateQuestion);
        assertEquals(updateQuestion, questionDaoMem.find(id));
    }

    @Test
    public void updateQuestion_withNonExistingId_throwApiRequestException() {
        int nonExistingId = 2000;
        Question updateQuestion = new Question("updated", "updated", "updated");
        Exception exception = assertThrows(ApiRequestException.class, () -> questionDaoMem.update(nonExistingId, updateQuestion));
        assertEquals("Question id not found(2000)", exception.getMessage());
    }

    @Test
    public void getAllQuestion() {
        for (int i = 0; i <= 3; i++) {
            Question question = new Question("test", "test", "test");
            question.setId(i);
            questionDaoMem.add(question);
        }
        int expectedSize = 4;
        assertEquals(expectedSize, questionDaoMem.getAll().size());
    }
}