package hu.joel.laczkovszki.qa.service;

import hu.joel.laczkovszki.qa.dao.CRUDInterface;
import hu.joel.laczkovszki.qa.dao.QuestionDao;
import hu.joel.laczkovszki.qa.dao.implementation.QuestionDaoMem;
import hu.joel.laczkovszki.qa.model.Question;
import hu.joel.laczkovszki.qa.model.User;
import hu.joel.laczkovszki.qa.testData.TestQuestionData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class QuestionService {
    private final QuestionDao questionDao;
    private final AnswerService answerService;
    private final UserService userService;

    @Autowired
    public QuestionService(QuestionDaoMem questionDao, AnswerService answerService, UserService userService) {
        this.questionDao = questionDao;
        QuestionDaoMem.setQuestions(TestQuestionData.questionList);
        this.answerService = answerService;
        this.userService = userService;
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

    public List<Question> getAllQuestion_byUserId(int userId) {
        return questionDao.getAllQuestion_byUserId(userId);
    }

    public List<Question> getQuestionByHobby(int id) {
        List<String> hobbies = getUserById(id).getFieldsOfInterest();
        List<Question> result = new ArrayList<>();
        for (String hobby:hobbies) {
            result = Stream.concat(result.stream(), questionDao.getQuestionsByHobby(hobby).stream()).distinct().collect(Collectors.toList());
        }
        return result;
    }

    public List<Question> getQuestionByFriend(int id) {
        List<Integer> friendIds = getUserById(id).getFriends();
        List<Question> result = new ArrayList<>();
        for (Integer i:friendIds) {
            result = Stream.concat(result.stream(), questionDao.getAllQuestion_byUserId(i).stream()).distinct().collect(Collectors.toList());
        }
        return result;
    }

    public User getUserById (int id) {
        return userService.getUser(id);
    }
}
