package hu.joel.laczkovszki.qa.model;

public class Answer {
    private static int idCounter;
    private int id;
    private String description;
    private String imagePath;
    private int questionId;

    public Answer(String description, int questionId) {
        this.description = description;
        this.questionId = questionId;
        id = idCounter++;
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
