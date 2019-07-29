package com.example.studentnotes.model;

import java.util.Date;

public class FeedBack extends Page{
    private Integer feedBackId;
    private String feedBackContent;
    private Date feedBackTime;
    private Integer feedBackStatus;
    private String feedBackUserId;

    public FeedBack(Integer feedBackId, String feedBackContent, Date feedBackTime, Integer feedBackStatus, String feedBackUserId) {
        this.feedBackId = feedBackId;
        this.feedBackContent = feedBackContent;
        this.feedBackTime = feedBackTime;
        this.feedBackStatus = feedBackStatus;
        this.feedBackUserId = feedBackUserId;
    }

    public FeedBack() {
        super();
    }

    public Integer getFeedBackId() {
        return feedBackId;
    }

    public void setFeedBackId(Integer feedBackId) {
        this.feedBackId = feedBackId;
    }

    public String getFeedBackContent() {
        return feedBackContent;
    }

    public void setFeedBackContent(String feedBackContent) {
        this.feedBackContent = feedBackContent;
    }

    public Date getFeedBackTime() {
        return feedBackTime;
    }

    public void setFeedBackTime(Date feedBackTime) {
        this.feedBackTime = feedBackTime;
    }

    public Integer getFeedBackStatus() {
        return feedBackStatus;
    }

    public void setFeedBackStatus(Integer feedBackStatus) {
        this.feedBackStatus = feedBackStatus;
    }

    public String getFeedBackUserId() {
        return feedBackUserId;
    }

    public void setFeedBackUserId(String feedBackUserId) {
        this.feedBackUserId = feedBackUserId;
    }
}
