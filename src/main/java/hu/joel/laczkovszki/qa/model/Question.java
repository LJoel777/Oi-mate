package hu.joel.laczkovszki.qa.model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question {
    private static int idCounter;
    private int id;
    private String description;
    private String imagePath;
    private int userId;
    private List<String> categories;

    public List<String> getCategories() {
        return categories;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Question( String description, String imagePath, int userId, String[] categories) {
        this.description = description;
        this.imagePath = imagePath;
        this.userId = userId;
        this.categories = categories != null ? Arrays.asList(categories) : new ArrayList<>();
        id = idCounter++;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public boolean checkCategory(String hobby) {
        return categories.contains(hobby);
    }
}
