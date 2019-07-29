package com.example.studentnotes.Bo;

import com.example.studentnotes.model.Ufile;

import java.util.List;

public class CategoryRespBo {
    private Integer categoryId;
    private String categoryName;
    private List<Ufile> ufiles;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public List<Ufile> getUfiles() {
        return ufiles;
    }

    public void setUfiles(List<Ufile> ufiles) {
        this.ufiles = ufiles;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
