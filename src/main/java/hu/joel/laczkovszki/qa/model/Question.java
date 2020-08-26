package hu.joel.laczkovszki.qa.model;



public class Question {
    private static int idCounter;
    private int id;
    private String title;
    private String description;
    private String imagePath;

    public Question(String title, String description) {
        this.title = title;
        this.description = description;
        id = idCounter++;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
