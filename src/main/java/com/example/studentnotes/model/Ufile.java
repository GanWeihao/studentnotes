package com.example.studentnotes.model;

import java.util.Date;

public class Ufile extends Page{
    private Integer ufileId;

    private String ufileTitle;

    private Date ufileTime;

    private Integer ufileDownload;

    private String ufileIntroduce;

    private String ufileUrl;

    private String ufileName;

    private Integer ufileStatus;

    private Integer ufileCategoryId;

    private String ufileUserId;

    public Ufile(Integer ufileId, String ufileTitle, Date ufileTime, Integer ufileDownload, String ufileIntroduce, String ufileUrl, String ufileName, Integer ufileStatus, Integer ufileCategoryId, String ufileUserId) {
        this.ufileId = ufileId;
        this.ufileTitle = ufileTitle;
        this.ufileTime = ufileTime;
        this.ufileDownload = ufileDownload;
        this.ufileIntroduce = ufileIntroduce;
        this.ufileUrl = ufileUrl;
        this.ufileName = ufileName;
        this.ufileStatus = ufileStatus;
        this.ufileCategoryId = ufileCategoryId;
        this.ufileUserId = ufileUserId;
    }

    public Ufile() {
        super();
    }

    public Integer getUfileId() {
        return ufileId;
    }

    public void setUfileId(Integer ufileId) {
        this.ufileId = ufileId;
    }

    public String getUfileTitle() {
        return ufileTitle;
    }

    public void setUfileTitle(String ufileTitle) {
        this.ufileTitle = ufileTitle == null ? null : ufileTitle.trim();
    }

    public Date getUfileTime() {
        return ufileTime;
    }

    public void setUfileTime(Date ufileTime) {
        this.ufileTime = ufileTime;
    }

    public Integer getUfileDownload() {
        return ufileDownload;
    }

    public void setUfileDownload(Integer ufileDownload) {
        this.ufileDownload = ufileDownload;
    }

    public String getUfileIntroduce() {
        return ufileIntroduce;
    }

    public void setUfileIntroduce(String ufileIntroduce) {
        this.ufileIntroduce = ufileIntroduce == null ? null : ufileIntroduce.trim();
    }

    public String getUfileUrl() {
        return ufileUrl;
    }

    public void setUfileUrl(String ufileUrl) {
        this.ufileUrl = ufileUrl == null ? null : ufileUrl.trim();
    }

    public String getUfileName() {
        return ufileName;
    }

    public void setUfileName(String ufileName) {
        this.ufileName = ufileName == null ? null : ufileName.trim();
    }

    public Integer getUfileStatus() {
        return ufileStatus;
    }

    public void setUfileStatus(Integer ufileStatus) {
        this.ufileStatus = ufileStatus;
    }

    public Integer getUfileCategoryId() {
        return ufileCategoryId;
    }

    public void setUfileCategoryId(Integer ufileCategoryId) {
        this.ufileCategoryId = ufileCategoryId;
    }

    public String getUfileUserId() {
        return ufileUserId;
    }

    public void setUfileUserId(String ufileUserId) {
        this.ufileUserId = ufileUserId;
    }
}