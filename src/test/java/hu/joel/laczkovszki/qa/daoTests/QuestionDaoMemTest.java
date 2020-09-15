//package hu.joel.laczkovszki.qa.daoTests;
//
//import hu.joel.laczkovszki.qa.dao.implementation.QuestionDaoMem;
//import hu.joel.laczkovszki.qa.exception.ApiRequestException;
//import hu.joel.laczkovszki.qa.model.Post;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import static org.junit.Assert.*;
//
//import java.util.ArrayList;
//
//@SpringBootTest
//public class QuestionDaoMemTest {
//    QuestionDaoMem questionDaoMem;
//
//    @BeforeEach
//    public void init() {
//        questionDaoMem = new QuestionDaoMem();
//        QuestionDaoMem.setPosts(new ArrayList<>());
//    }
//
//    @Test
//    public void addQuestion() {
//        int id = 0;
//        Post post = new Post("test", "test", "test", 0, null);
//        post.setId(id);
//        questionDaoMem.add(post);
//        assertEquals(post, questionDaoMem.find(id));
//    }
//
//    @Test
//    public void findQuestion_withExistingId() {
//        int id = 0;
//        Post post = new Post("test", "test", "test", 0, null);
//        post.setId(id);
//        questionDaoMem.add(post);
//        assertEquals(post, questionDaoMem.find(id));
//    }
//
//    @Test
//    public void findQuestion_withNonExistingId_throwApiRequestException() {
//        int nonExistingId = 0;
//        assertThrows(ApiRequestException.class, () -> questionDaoMem.find(nonExistingId));
//    }
//
//    @Test
//    public void removeQuestion_withExistingId() {
//        int id = 0;
//        for (int i = 0; i <= 3; i++) {
//            Post post = new Post("test", "test", "test", 0, null);
//            post.setId(i);
//            questionDaoMem.add(post);
//        }
//        questionDaoMem.remove(id);
//        int expectedSize = 3;
//        assertEquals(expectedSize, questionDaoMem.getAll().size());
//    }
//
//    @Test
//    public void removeQuestion_withNonExistingId_throwApiRequestException() {
//        int nonExistingId = 2000;
//        Exception exception = assertThrows(ApiRequestException.class, () -> questionDaoMem.remove(nonExistingId));
//        assertEquals("Post id not found(2000)", exception.getMessage());
//    }
//
//    @Test
//    public void updateQuestion_withExistingId() {
//        int id = 0;
//        Post post = new Post("test", "test", "test", 0, null);
//        post.setId(id);
//        questionDaoMem.add(post);
//        Post updateQuestion = new Post("updated", "updated", "updated", 0, null);
//        questionDaoMem.update(id, updateQuestion);
//        assertEquals(updateQuestion, questionDaoMem.find(id));
//    }
//
//    @Test
//    public void updateQuestion_withNonExistingId_throwApiRequestException() {
//        int nonExistingId = 2000;
//        Post updateQuestion = new Post("updated", "updated", "updated", 0, null);
//        Exception exception = assertThrows(ApiRequestException.class, () -> questionDaoMem.update(nonExistingId, updateQuestion));
//        assertEquals("Post id not found(2000)", exception.getMessage());
//    }
//
//    @Test
//    public void getAllQuestion() {
//        for (int i = 0; i <= 3; i++) {
//            Post post = new Post("test", "test", "test", 0, null);
//            post.setId(i);
//            questionDaoMem.add(post);
//        }
//        int expectedSize = 4;
//        assertEquals(expectedSize, questionDaoMem.getAll().size());
//    }
//
//    @Test
//    public void getQuestion_byUserId() {
//        int userId = 0;
//        Post post = new Post("test", "test", "test", userId, null);
//        post.setId(0);
//        questionDaoMem.add(post);
//        assertEquals(post, questionDaoMem.getAllQuestion_byUserId(userId).get(0));
//    }
//}