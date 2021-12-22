package com.mycompany.artbalear.Models;

import java.time.LocalDate;

public class User {

    private int id;
    private String userMail;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String gender;
    private boolean admin;
    private String password;

    public User(String userMail, String firstName, String lastName, LocalDate birthDate, String gender, boolean admin) {
        this.userMail = userMail;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.admin = admin;
    }

    public User(int id, String userMail, String firstName, String lastName, LocalDate birthDate, String gender, boolean admin, String password) {
        this.id = id;
        this.userMail = userMail;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.admin = admin;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", userMail=" + userMail + ", firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate + ", gender=" + gender + ", admin=" + admin + ", password=" + password + '}';
    }

}
