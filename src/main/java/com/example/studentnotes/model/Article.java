package com.example.studentnotes.model;

import java.util.Date;

public class Article extends Page{
    private Integer articleId;

    private String articleTitle;

    private String articleContent;

    private Integer articlePraise;

    private Date articleTime;

    private Integer articleStatus;

    private String articleUserId;

    private Integer articleCategoryId;
    private String articleUrl;
    public Article(Integer articleId, String articleTitle, String articleContent, Integer articlePraise, Date articleTime, Integer articleStatus, String articleUserId, Integer articleCategoryId, String articleUrl) {
        this.articleId = articleId;
        this.articleTitle = articleTitle;
        this.articleContent = articleContent;
        this.articlePraise = articlePraise;
        this.articleTime = articleTime;
        this.articleStatus = articleStatus;
        this.articleUserId = articleUserId;
        this.articleCategoryId = articleCategoryId;
        this.articleUrl = articleUrl;
    }
    public Article() {
        super();
    }
    public String getArticleUrl() {
        return articleUrl;
    }

    public void setArticleUrl(String articleUrl) {
        this.articleUrl = articleUrl;
    }



    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public Integer getArticlePraise() {
        return articlePraise;
    }

    public void setArticlePraise(Integer articlePraise) {
        this.articlePraise = articlePraise;
    }

    public Date getArticleTime() {
        return articleTime;
    }

    public void setArticleTime(Date articleTime) {
        this.articleTime = articleTime;
    }

    public Integer getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(Integer articleStatus) {
        this.articleStatus = articleStatus;
    }

    public String getArticleUserId() {
        return articleUserId;
    }

    public void setArticleUserId(String articleUserId) {
        this.articleUserId = articleUserId;
    }

    public Integer getArticleCategoryId() {
        return articleCategoryId;
    }

    public void setArticleCategoryId(Integer articleCategoryId) {
        this.articleCategoryId = articleCategoryId;
    }
}