package com.example.studentnotes.service.impl;

import com.example.studentnotes.Bo.ArticleRespBo;
import com.example.studentnotes.mapper.ArticleMapper;
import com.example.studentnotes.mapper.CommentsMapper;
import com.example.studentnotes.mapper.UserMapper;
import com.example.studentnotes.model.Article;
import com.example.studentnotes.model.Comments;
import com.example.studentnotes.model.Page;
import com.example.studentnotes.model.User;
import com.example.studentnotes.service.ArticleService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    CommentsMapper commentsMapper;
    @Override
    public void insertSelective(Article article) {
        articleMapper.insertSelective(article);
    }

    @Override
    public void updateByPrimaryKeySelective(Article article) {
        articleMapper.updateByPrimaryKeySelective(article);
    }

    @Override
    public List<Article> selectByTitle(Article article) {
        PageHelper.startPage(article.getPageNum(),article.getPageSize());
        String title = article.getArticleTitle();
        article.setArticleTitle("%"+title+"%");
        return articleMapper.selectByTitle(article);
    }

    @Override
    public void deleteByPrimaryKey(Article article) {
        articleMapper.deleteByPrimaryKey(article);
    }

    @Override
    public Article selectById(Article article) {
        return articleMapper.selectById(article);
    }

    @Override
    public List selectArticleNum() {
        return articleMapper.selectArticleNum();
    }

    @Override
    public List<Article> selectAll() {
        return articleMapper.selectAll();
    }

    @Override
    public List<ArticleRespBo> select() {
        List<ArticleRespBo> list = new ArrayList<ArticleRespBo>();
        List<Article> list1 = articleMapper.selectAll();
        for(int i=0;i<list1.size();i++){
            ArticleRespBo articleRespBo = new ArticleRespBo();
            User user = userMapper.findById(list1.get(i).getArticleUserId());
            Comments comments =new Comments();
            comments.setCommentsArticleId(list1.get(i).getArticleId());
            List<Comments> list2 = commentsMapper.selectByAid(comments);
            articleRespBo.setArticle(list1.get(i));
            articleRespBo.setUserUname(user.getUserUname());
            articleRespBo.setUserUrl(user.getUserHeadimg());
            articleRespBo.setUserStatus(user.getUserRank());
            articleRespBo.setSize(list2.size());
            list.add(articleRespBo);
        }
        return list;
    }
}
