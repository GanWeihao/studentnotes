package com.example.studentnotes.model;

import java.util.Date;

public class Comments {
    private Integer commentsId;

    private Date commentsTime;

    private Integer commentsStatus;

    private String commentsContent;

    private Integer commentsArticleId;

    private String commentsUserId;

    public Comments(Integer commentsId, Date commentsTime, Integer commentsStatus, String commentsContent,  Integer commentsArticleId, String commentsUserId) {
        this.commentsId = commentsId;
        this.commentsTime = commentsTime;
        this.commentsStatus = commentsStatus;
        this.commentsContent = commentsContent;
        this.commentsArticleId = commentsArticleId;
        this.commentsUserId = commentsUserId;
    }

    public Comments() {
        super();
    }

    public Integer getCommentsId() {
        return commentsId;
    }

    public void setCommentsId(Integer commentsId) {
        this.commentsId = commentsId;
    }

    public Date getCommentsTime() {
        return commentsTime;
    }

    public void setCommentsTime(Date commentsTime) {
        this.commentsTime = commentsTime;
    }

    public Integer getCommentsStatus() {
        return commentsStatus;
    }

    public void setCommentsStatus(Integer commentsStatus) {
        this.commentsStatus = commentsStatus;
    }

    public String getCommentsContent() {
        return commentsContent;
    }

    public void setCommentsContent(String commentsContent) {
        this.commentsContent = commentsContent;
    }


    public Integer getCommentsArticleId() {
        return commentsArticleId;
    }

    public void setCommentsArticleId(Integer commentsArticleId) {
        this.commentsArticleId = commentsArticleId;
    }

    public String getCommentsUserId() {
        return commentsUserId;
    }

    public void setCommentsUserId(String commentsUserId) {
        this.commentsUserId = commentsUserId;
    }
}