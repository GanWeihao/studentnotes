package com.example.studentnotes.mapper;

import com.example.studentnotes.model.Comments;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("CommentsMapper")
public interface CommentsMapper {
    //添加评论
    void insertSelective(Comments comments);
    //删除评论
    void deletecomments(Comments comments);
    List<Comments> selectByAid(Comments comments);
}