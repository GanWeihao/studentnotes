package com.example.studentnotes.service.impl;

import com.example.studentnotes.mapper.CommentsMapper;
import com.example.studentnotes.model.Comments;
import com.example.studentnotes.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsServiceImpl implements CommentsService{
    @Autowired
    CommentsMapper commentsMapper;

    @Override
    public void insertSelective(Comments comments) {
        commentsMapper.insertSelective(comments);
    }

    @Override
    public void deletecomments(Comments comments) {
        commentsMapper.deletecomments(comments);
    }

    @Override
    public List<Comments> select(Comments comments) {
        return commentsMapper.selectByAid(comments);
    }
}