package hu.joel.laczkovszki.qa.model;

import java.util.UUID;

public class Answer {
    private static int idCounter;
    private int id;
    private String description;
    private String imgPath;
    private int questionID;

    public Answer(String description) {
        this.description = description;
        id = idCounter++;
    }

    public int getQuestionID() {
        return questionID;
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
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
}
