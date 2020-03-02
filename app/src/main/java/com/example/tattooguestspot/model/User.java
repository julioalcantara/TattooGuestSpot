package com.example.tattooguestspot.model;

public class User {

    private String userName;
    private String firstName;
    private String surname;
    private String email;
    private String password;
    private int id;

    public User(String userName, String firstName, String surname, String email, String password) {
        this.userName = userName;
        this.firstName = firstName;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }


    public String getUserName() {
        return userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail() { this.email = email; }

    public String getPassword() {
        return password;
    }

    public void setPassword() { this.password = password; }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
