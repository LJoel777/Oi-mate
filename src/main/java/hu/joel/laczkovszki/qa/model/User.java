package hu.joel.laczkovszki.qa.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;

    private String userName;
    private String psw;
    private String emailAddress;
    private String firstName;
    private String lastName;
    private String profilePicture = "https://lh3.googleusercontent.com/proxy/0PjSFxSxbv2GiRKxCxez_Kq_UPLDZnMGOtB4ATH4TVKohc2Csdd0hCjnjJbJg7ZIAEEYraNGkuqCeKyTL1UqX6ko5LZvqTsdCQwNBxfJdsKSqPxcMyPwmRI";
    private List<String> fieldsOfInterest;
    private List<Integer> friends;
    private static int idCounter = 0;

    public User(String userName, String psw, String emailAddress, String firstName, String lastName, String profilePicture, List<String> fieldsOfInterest, List<Integer> friends) {
        this.userName = userName;
        this.psw = psw;
        this.emailAddress = emailAddress;
        this.firstName = firstName;
        this.lastName = lastName;
        if (!profilePicture.equals(""))
            this.profilePicture = profilePicture;
        this.fieldsOfInterest = fieldsOfInterest != null ? fieldsOfInterest : new ArrayList<>();
        this.friends = friends != null ? friends : new ArrayList<>();
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

    public List<Integer> getFriends() {
        return friends;
    }

    public void setFriends(List<Integer> friends) {
        this.friends = friends;
    }

    public void addFriend(Integer id) {
        this.friends.add(id);
    }
}
