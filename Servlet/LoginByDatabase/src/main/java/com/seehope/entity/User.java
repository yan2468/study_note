package com.seehope.entity;

import java.util.Arrays;
import java.util.Date;

public class User {
    private int userID;
    private String userName;
    private String userPassword;
    private String sex;
    private String school;
    private String hobby;
    private String birthday;
    private String phoneNumber;

    public User() {
    }

    public User(String userName, String userPassword, String sex, String school, String hobby, String birthday, String phoneNumber) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.sex = sex;
        this.school = school;
        this.hobby = hobby;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
    }

    public User(int userID, String userName, String userPassword, String sex, String school, String hobby, String birthday, String phoneNumber) {
        this.userID = userID;
        this.userName = userName;
        this.userPassword = userPassword;
        this.sex = sex;
        this.school = school;
        this.hobby = hobby;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + userID +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", sex='" + sex + '\'' +
                ", school='" + school + '\'' +
                ", hobby='" + hobby + '\'' +
                ", birthday='" + birthday + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
