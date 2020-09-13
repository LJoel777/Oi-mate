package hu.joel.laczkovszki.qa.model;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
@NoArgsConstructor
public class Answer {
    private static int idCounter;
    @Id
    @GeneratedValue
    private Long id1;

    public Long getId1() {
        return id1;
    }

    @Transient
    private int id;
    private String description;
    private String imagePath;
    private  int questionId;
    private  int userId;

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public Answer(String description, String imagePath, int questionId, int userId) {
        this.description = description;
        this.imagePath = imagePath;
        this.questionId = questionId;
        this.userId = userId;
//        id = idCounter++;
    }

    public int getQuestionId() {
        return questionId;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgPath() {
        return imagePath;
    }

    public void setImgPath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
