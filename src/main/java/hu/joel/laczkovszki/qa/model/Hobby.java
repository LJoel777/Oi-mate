package hu.joel.laczkovszki.qa.model;

import java.util.List;

public class Hobby {
    private Long id;
    private List<String> fieldsOfInterest;

    public Hobby(Long id, List<String> fieldsOfInterest) {
        this.id = id;
        this.fieldsOfInterest = fieldsOfInterest;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getFieldsOfInterest() {
        return fieldsOfInterest;
    }

    public void setFieldsOfInterest(List<String> fieldsOfInterest) {
        this.fieldsOfInterest = fieldsOfInterest;
    }
}
