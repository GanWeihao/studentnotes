package com.example.studentnotes.Bo;

import com.example.studentnotes.model.Article;


public class ArticleRespBo {
    private String userUname;
    private Article article;
    private String userUrl;
    private Integer userStatus;
    private Integer size;

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserUname() {
        return userUname;
    }

    public void setUserUname(String userUname) {
        this.userUname = userUname;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public String getUserUrl() {
        return userUrl;
    }

    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl;
    }
}
