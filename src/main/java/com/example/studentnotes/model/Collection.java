package com.example.studentnotes.model;

import java.util.Date;

public class Collection extends Page{
    private Integer collectionId;

    private Date collectionTime;

    private Integer collectionArticleId;

    private String collectionUserId;
    private Integer collectionStatus;
    public Collection(Integer collectionId, Date collectionTime, Integer collectionArticleId, String collectionUserId,Integer collectionStatus) {
        this.collectionId = collectionId;
        this.collectionTime = collectionTime;
        this.collectionArticleId = collectionArticleId;
        this.collectionUserId = collectionUserId;
        this.collectionStatus = collectionStatus;
    }

    public Integer getCollectionStatus() {
        return collectionStatus;
    }

    public void setCollectionStatus(Integer collectionStatus) {
        this.collectionStatus = collectionStatus;
    }

    public Collection() {
        super();
    }

    public Integer getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Integer collectionId) {
        this.collectionId = collectionId;
    }

    public Date getCollectionTime() {
        return collectionTime;
    }

    public void setCollectionTime(Date collectionTime) {
        this.collectionTime = collectionTime;
    }

    public Integer getCollectionArticleId() {
        return collectionArticleId;
    }

    public void setCollectionArticleId(Integer collectionFileId) {
        this.collectionArticleId = collectionArticleId;
    }

    public String getCollectionUserId() {
        return collectionUserId;
    }

    public void setCollectionUserId(String collectionUserId) {
        this.collectionUserId = collectionUserId;
    }
}