package com.example.studentnotes.model;

import java.util.Date;

public class Record {
    private String recordId;

    private String recordUserId;

    private String recordUfileName;

    private Date rceordTime;

    private Integer recordStatus;

    public Record(String recordId, String recordUserId, String recordUfileName, Date rceordTime, Integer recordStatus) {
        this.recordId = recordId;
        this.recordUserId = recordUserId;
        this.recordUfileName = recordUfileName;
        this.rceordTime = rceordTime;
        this.recordStatus = recordStatus;
    }

    public Record() {
        super();
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId == null ? null : recordId.trim();
    }

    public String getRecordUserId() {
        return recordUserId;
    }

    public void setRecordUserId(String recordUserId) {
        this.recordUserId = recordUserId == null ? null : recordUserId.trim();
    }

    public String getRecordUfileName() {
        return recordUfileName;
    }

    public void setRecordUfileName(String recordUfileName) {
        this.recordUfileName = recordUfileName == null ? null : recordUfileName.trim();
    }

    public Date getRceordTime() {
        return rceordTime;
    }

    public void setRceordTime(Date rceordTime) {
        this.rceordTime = rceordTime;
    }

    public Integer getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Integer recordStatus) {
        this.recordStatus = recordStatus;
    }
}