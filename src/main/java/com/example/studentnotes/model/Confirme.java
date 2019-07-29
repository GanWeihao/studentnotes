package com.example.studentnotes.model;

public class Confirme extends Page{
    private Integer confirmeId;

    private String confirmeImgUrl;

    private String confirmeUserId;

    private String confirmeUserStuid;

    private Integer confirmeStatus;

    private String confirmeDisplay;

    public Confirme(Integer confirmeId, String confirmeImgUrl, String confirmeUserId, String confirmeUserStuid, Integer confirmeStatus, String confirmeDisplay) {
        this.confirmeId = confirmeId;
        this.confirmeImgUrl = confirmeImgUrl;
        this.confirmeUserId = confirmeUserId;
        this.confirmeUserStuid = confirmeUserStuid;
        this.confirmeStatus = confirmeStatus;
        this.confirmeDisplay = confirmeDisplay;
    }

    public Confirme() {
        super();
    }

    public Integer getConfirmeId() {
        return confirmeId;
    }

    public void setConfirmeId(Integer confirmeId) {
        this.confirmeId = confirmeId;
    }

    public String getConfirmeImgUrl() {
        return confirmeImgUrl;
    }

    public void setConfirmeImgUrl(String confirmeImgUrl) {
        this.confirmeImgUrl = confirmeImgUrl == null ? null : confirmeImgUrl.trim();
    }

    public String getConfirmeUserId() {
        return confirmeUserId;
    }

    public void setConfirmeUserId(String confirmeUserId) {
        this.confirmeUserId = confirmeUserId == null ? null : confirmeUserId.trim();
    }

    public String getConfirmeUserStuid() {
        return confirmeUserStuid;
    }

    public void setConfirmeUserStuid(String confirmeUserStuid) {
        this.confirmeUserStuid = confirmeUserStuid == null ? null : confirmeUserStuid.trim();
    }

    public Integer getConfirmeStatus() {
        return confirmeStatus;
    }

    public void setConfirmeStatus(Integer confirmeStatus) {
        this.confirmeStatus = confirmeStatus;
    }

    public String getConfirmeDisplay() {
        return confirmeDisplay;
    }

    public void setConfirmeDisplay(String confirmeDisplay) {
        this.confirmeDisplay = confirmeDisplay == null ? null : confirmeDisplay.trim();
    }
}