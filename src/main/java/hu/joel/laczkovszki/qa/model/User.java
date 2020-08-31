package hu.joel.laczkovszki.qa.model;

import java.util.UUID;

public class User {
    private UUID id;
    private String userName;
    private String psw;
    private String emailAdress;
    private String firstName;
    private String lastName;
    private String profilePicture;

    public User(String userName, String psw, String emailAdress, String firstName, String lastName, String profilePicture) {
        this.userName = userName;
        this.psw = psw;
        this.emailAdress = emailAdress;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profilePicture = profilePicture;
        this.id = UUID.randomUUID();
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

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
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
