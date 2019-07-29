package com.example.studentnotes.model;

import java.util.Date;

public class Category extends Page{
    private Integer categoryId;

    private String categoryName;

    private Date categoryTime;

    private Integer categoryStatus;

    public Category(Integer categoryId, String categoryName, Date categoryTime, Integer categoryStatus) {
        this.categoryId = categoryId;
        this.categoryTime = categoryTime;
        this.categoryName = categoryName;
        this.categoryStatus = categoryStatus;
    }

    public Category() {
        super();
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public Date getCategoryTime() {
        return categoryTime;
    }

    public void setCategoryTime(Date categoryTime) {
        this.categoryTime = categoryTime;
    }

    public Integer getCategoryStatus() {
        return categoryStatus;
    }

    public void setCategoryStatus(Integer categoryStatus) {
        this.categoryStatus = categoryStatus;
    }
}