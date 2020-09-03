package hu.joel.laczkovszki.qa.model;

import java.util.List;

public class Hobby {
    private int id;
    private List<String> fieldsOfInterest;

    public Hobby(int id, List<String> fieldsOfInterest) {
        this.id = id;
        this.fieldsOfInterest = fieldsOfInterest;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getFieldsOfInterest() {
        return fieldsOfInterest;
    }

    public void setFieldsOfInterest(List<String> fieldsOfInterest) {
        this.fieldsOfInterest = fieldsOfInterest;
    }
}
