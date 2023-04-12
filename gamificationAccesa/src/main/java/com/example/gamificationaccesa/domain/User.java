package com.example.gamificationaccesa.domain;

import java.util.*;

public class User extends Entity{
    private String firstname;
    private String lastname;
    private String mail;
    private int age;
    private String password;

    private int tokens;

    private String badges;

    @Override
    public String toString() {
        return "User{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", mail='" + mail + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", tokens=" + tokens +
                ", badges='" + badges + '\'' +
                '}';
    }

    public int getTokens() {
        return tokens;
    }

    public void setTokens(int tokens) {
        this.tokens = tokens;
    }

    public String getBadges() {
        return badges;
    }

    public void setBadges(String badges) {
        this.badges = badges;
    }

    public User(Long id, String firstname, String lastname, String mail, int age, String password, int tokens, String badges) {
        super(id);
        this.firstname = firstname;
        this.lastname = lastname;
        this.mail = mail;
        this.age = age;
        this.password = password;
        this.tokens = tokens;
        this.badges = badges;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getMail() {
        return mail;
    }

    public int getAge() {
        return age;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(firstname, user.firstname) && Objects.equals(lastname, user.lastname) && Objects.equals(mail, user.mail) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, mail, age, password, tokens, badges);
    }
}
