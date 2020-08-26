package hu.joel.laczkovszki.qa.daoTests;

import hu.joel.laczkovszki.qa.dao.QuestionDao;
import hu.joel.laczkovszki.qa.dao.implementation.QuestionDaoMem;
import hu.joel.laczkovszki.qa.model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionDaoMemTest {
    QuestionDao questionDao;

    @BeforeEach
    public void init() {
        questionDao = new QuestionDaoMem();
    }

    @Test
    public void findQuestion_byExistingId() {
        int id = 100;
        Question question = new Question("test", "test");
        question.setId(id);
        List<Question> questions = new ArrayList<>() {{
            add(question);
        }};
        Question expected = question;
        Question result = questionDao.find(id);
    }

}
