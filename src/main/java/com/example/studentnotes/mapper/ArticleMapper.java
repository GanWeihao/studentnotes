package com.example.studentnotes.mapper;

import com.example.studentnotes.model.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("ArticleMapper")
public interface ArticleMapper {
    //删除文章
    void deleteByPrimaryKey(Article article);
    //发布文章
    void insertSelective(Article article);
    //修改文章
    void updateByPrimaryKeySelective(Article article);
    //根据标题查询文章
    List<Article> selectByTitle(Article article);
    //根据ARTICLE_ID查询文章
    Article selectById(Article article);

    //文章总量
    List<Article> selectArticleNum();

    List<Article> selectAll();
}