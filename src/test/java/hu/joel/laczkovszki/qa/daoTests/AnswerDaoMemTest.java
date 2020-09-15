//package hu.joel.laczkovszki.qa.daoTests;
//
//import static org.junit.Assert.*;
//
//import hu.joel.laczkovszki.qa.dao.AnswerDao;
//import hu.joel.laczkovszki.qa.dao.CRUDInterface;
//import hu.joel.laczkovszki.qa.dao.implementation.AnswerDaoMem;
//import hu.joel.laczkovszki.qa.dao.implementation.QuestionDaoMem;
//
//import static org.mockito.Mockito.*;
//
//import hu.joel.laczkovszki.qa.exception.ApiRequestException;
//import hu.joel.laczkovszki.qa.model.Comment;
//import hu.joel.laczkovszki.qa.model.Post;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.ArrayList;
//
//@SpringBootTest
//public class AnswerDaoMemTest {
//    AnswerDao answerDaoMem;
//    CRUDInterface<Post> questionDaoMem;
//
//    @BeforeEach
//    public void init() {
//        questionDaoMem = mock(QuestionDaoMem.class);
//        answerDaoMem = new AnswerDaoMem((QuestionDaoMem) questionDaoMem);
//        AnswerDaoMem.setComments(new ArrayList<>());
//    }
////
////    @Test
////    public void addAnswer_withExistingQuestionId() {
////        int answerId = 0;
////        when(questionDaoMem.find(0)).thenReturn(new Post("test", "test", "test", 0, null));
////        Comment expectedAnswer = new Comment("Test", "test", 0, 0);
////        expectedAnswer.setId(answerId);
////
////        answerDaoMem.add(expectedAnswer);
////        assertEquals(expectedAnswer, answerDaoMem.find(answerId));
////    }
//
//    @Test
//    public void addAnswer_withNonExistingQuestionId_throwApiRequestException() {
//        int questionId = 2;
//        when(questionDaoMem.find(questionId)).thenThrow(new ApiRequestException("Post id not found (2)"));
//        Comment answer = new Comment("test", "test", questionId, 1);
//
//        Exception exception = assertThrows(ApiRequestException.class, () -> answerDaoMem.add(answer));
//        assertEquals("Post id not found (2)", exception.getMessage());
//    }
//
//    @Test
//    public void findAnswer_withExistingId_returnAnswer() {
//        int answerId = 2;
//        Comment answer = new Comment("test", "test", 0, 2);
//        answer.setId(answerId);
//
//        answerDaoMem.add(answer);
//        assertEquals(answer, answerDaoMem.find(answerId));
//    }
//
//    @Test
//    public void finsAnswer_withNonExistingId_throwApiRequestException() {
//        int answerId = 100;
//
//        Exception exception = assertThrows(ApiRequestException.class, () -> answerDaoMem.find(answerId));
//        assertEquals("Comment id not found(100)", exception.getMessage());
//    }
//
//
//    @Test
//    public void removeAnswer_withExistingId() {
//        int answerId = 0;
//        for (int i = 0; i <= 3; i++) {
//            Comment answer = new Comment("test", "test", 0, 0);
//            answer.setId(i);
//            answerDaoMem.add(answer);
//        }
//        int expectedSize = 3;
//
//        answerDaoMem.remove(answerId);
//        assertEquals(expectedSize, answerDaoMem.getAnswersByQuestionId(0).size());
//    }
//
//    @Test
//    public void removeAnswer_withNonExistingId_throwApiRequestException() {
//        int nonExistingAnswerId = 200;
//        Exception exception = assertThrows(ApiRequestException.class, () -> answerDaoMem.remove(nonExistingAnswerId));
//        assertEquals("Comment id not found(200)", exception.getMessage());
//    }
//
//    @Test
//    public void updateAnswer_withExistingId() {
//        int answerId = 0;
//        Comment answer = new Comment("test", "test", 0, 0);
//        answer.setId(0);
//        answerDaoMem.add(answer);
//        Comment updatedAnswer = new Comment("updated", "updated", 0, 0);
//        answerDaoMem.update(answerId, updatedAnswer);
//
//        assertEquals(updatedAnswer, answerDaoMem.find(answerId));
//    }
//
//    @Test
//    public void updateAnswer_withNonExistingId_throwApiRequestException() {
//        int noeExistingId = 3000;
//        Comment updatedAnswer = new Comment("updated", "updated", 0, 0);
//        Exception exception = assertThrows(ApiRequestException.class, () -> answerDaoMem.update(noeExistingId, updatedAnswer));
//        assertEquals("Comment id not found(3000)", exception.getMessage());
//    }
//
//    @Test
//    public void getAnswerByQuestionId_withExistingQuestionId() {
//        int questionId = 0;
//        for (int i = 0; i <= 3; i++) {
//            Comment answer = new Comment("test", "test", questionId, 0);
//            answer.setId(i);
//            answerDaoMem.add(answer);
//        }
//        int expectedSize = 4;
//        assertEquals(expectedSize, answerDaoMem.getAnswersByQuestionId(questionId).size());
//    }
//
//    @Test
//    public void getAnswerByQuestionId_withNonExistingQuestionId_throwApiRequestException() {
//        int noeExistingQuestionId = 3000;
//        when(questionDaoMem.find(noeExistingQuestionId)).thenThrow(new ApiRequestException("Post id not found(3000)"));
//        Exception exception = assertThrows(ApiRequestException.class, () -> answerDaoMem.getAnswersByQuestionId(noeExistingQuestionId));
//        assertEquals("Post id not found(3000)", exception.getMessage());
//    }
//
//    @Test
//    public void removeAnswersByQuestionId_withExistingQuestionId() {
//        int questionId = 0;
//        for (int i = 0; i <= 3; i++) {
//            Comment answer = new Comment("test", "test", questionId, 0);
//            answer.setId(i);
//            answerDaoMem.add(answer);
//        }
//        int expectedSize = 0;
//        answerDaoMem.removeAnswersByQuestionId(questionId);
//        assertEquals(expectedSize, answerDaoMem.getAnswersByQuestionId(questionId).size());
//    }
//}
