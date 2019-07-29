package com.example.studentnotes.service;

import com.example.studentnotes.model.Comments;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

public interface CommentsService {
    //添加评论
    public void insertSelective(Comments comments);
    //删除评论
    public void deletecomments(Comments comments);

    List<Comments> select(Comments comments);
}