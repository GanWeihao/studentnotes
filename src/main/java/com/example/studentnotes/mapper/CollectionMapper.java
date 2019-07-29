package com.example.studentnotes.mapper;

import com.example.studentnotes.model.Collection;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("CollectionMapper")
public interface CollectionMapper {
    //根据用户ID显示收藏
    List<Collection> selectByPrimaryKey(Collection collection);
    //根据文章ID显示收藏
    List<Collection> selectByArticle(Collection collection);
    //根据收藏ID删除收藏
    void deleteByPrimaryKey(Collection collection);
    //添加收藏
    void insert(Collection collection);
}