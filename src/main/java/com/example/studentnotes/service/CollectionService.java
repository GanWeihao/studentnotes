package com.example.studentnotes.service;

import com.example.studentnotes.model.Collection;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

public interface CollectionService {
    //根据用户ID显示收藏
    public List<Collection> selectByPrimaryKey(Collection collection);
    //根据文章ID显示收藏
    public List<Collection> selectByArticle(Collection collection);
    //根据收藏ID删除收藏
    public void deleteByPrimaryKey(Collection collection);
    //添加收藏
    public void insert(Collection collection);
}