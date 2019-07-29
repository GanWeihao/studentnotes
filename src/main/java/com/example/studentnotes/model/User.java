package com.example.studentnotes.model;

import java.util.Date;

public class User extends Page{
    private String userId;
    private String userUname;
    private String userName;
    private String userPassword;
    private Date userTime;
    private String userStuId;
    private String userPhone;
    private Integer userRank;
    private Integer userStatus;
    private Integer userStuStatus;
    private Integer userIntegral;
    private String userHeadimg;

    public User(String userId, String userUname, String userName, String userPassword, Date userTime, String userStuId, String userPhone, Integer userRank, Integer userStatus, Integer userStuStatus, Integer userIntegral, String userHeadimg) {
        this.userId = userId;
        this.userUname = userUname;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userTime = userTime;
        this.userStuId = userStuId;
        this.userPhone = userPhone;
        this.userRank = userRank;
        this.userStatus = userStatus;
        this.userStuStatus = userStuStatus;
        this.userIntegral = userIntegral;
        this.userHeadimg = userHeadimg;
    }

    public User() {
        super();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserUname() {
        return userUname;
    }

    public void setUserUname(String userUname) {
        this.userUname = userUname;
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

    public Date getUserTime() {
        return userTime;
    }

    public void setUserTime(Date userTime) {
        this.userTime = userTime;
    }

    public String getUserStuId() {
        return userStuId;
    }

    public void setUserStuId(String userStuId) {
        this.userStuId = userStuId;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Integer getUserRank() {
        return userRank;
    }

    public void setUserRank(Integer userRank) {
        this.userRank = userRank;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Integer getUserStuStatus() {
        return userStuStatus;
    }

    public void setUserStuStatus(Integer userStuStatus) {
        this.userStuStatus = userStuStatus;
    }

    public Integer getUserIntegral() {
        return userIntegral;
    }

    public void setUserIntegral(Integer userIntegral) {
        this.userIntegral = userIntegral;
    }

    public String getUserHeadimg() {
        return userHeadimg;
    }

    public void setUserHeadimg(String userHeadimg) {
        this.userHeadimg = userHeadimg;
    }
}
