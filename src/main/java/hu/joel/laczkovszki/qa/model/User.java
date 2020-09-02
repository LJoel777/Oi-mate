package hu.joel.laczkovszki.qa.model;

import java.util.List;

public class User {
    private int id;

    private String userName;
    private String psw;
    private String emailAddress;
    private String firstName;
    private String lastName;
    private String profilePicture = "https://lh3.googleusercontent.com/proxy/ShuDBfPQfNl63y3eaigj4OR4TNdzoTQYUFkHj_SB4-7chXH0adj2TBBAn5eX9N3xRWi6JyuO1gXMmjmBBgvZUqpNJGovLcLtL8fiSVtJQ-yNQmbi8mH6Lpw";
    private List<String> fieldsOfInterest;
    private static int idCounter = 0;

    public User(String userName, String psw, String emailAddress, String firstName, String lastName, String profilePicture, List<String> fieldsOfInterest) {
        this.userName = userName;
        this.psw = psw;
        this.emailAddress = emailAddress;
        this.firstName = firstName;
        this.lastName = lastName;
        if (!profilePicture.equals(""))
            this.profilePicture = profilePicture;
        this.fieldsOfInterest = fieldsOfInterest;
        this.id = idCounter++;
    }

    public List<String> getFieldsOfInterest() {
        return fieldsOfInterest;
    }

    public void setFieldsOfInterest(List<String> fieldsOfInterest) {
        this.fieldsOfInterest = fieldsOfInterest;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
}
