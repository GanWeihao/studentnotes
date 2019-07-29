package com.example.studentnotes.service;

import com.example.studentnotes.Bo.ArticleRespBo;
import com.example.studentnotes.model.Article;

import java.util.List;

public interface ArticleService {
    //发布文章
    public void insertSelective(Article article);
    //修改文章
    public void updateByPrimaryKeySelective(Article article);
    //根据ARTICLE_ID删除文章
    public void deleteByPrimaryKey(Article article);
    //根据标题查询文章
    public List<Article> selectByTitle(Article article);
    //根据ARTICLE_ID查询文章
    public Article selectById(Article article);

    //文章总量
    public List selectArticleNum();
    List<Article> selectAll();
    List<ArticleRespBo> select();
}
