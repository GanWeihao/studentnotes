package com.example.studentnotes.service.impl;

import com.example.studentnotes.mapper.FeedBackMapper;
import com.example.studentnotes.model.FeedBack;
import com.example.studentnotes.service.FeedBackService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedBackServiceImpl implements FeedBackService {

    @Autowired
    FeedBackMapper feedbackMapper;

    @Override
    public void addFeedBack(FeedBack feedBack) {
        this.feedbackMapper.addFeedBack(feedBack);
    }

    @Override
    public void deleteFeedBack(FeedBack feedBack) {
        this.feedbackMapper.deleteFeedBack(feedBack);
    }

    @Override
    public List<FeedBack> selectAll(FeedBack feedBack) {
        PageHelper.startPage(feedBack.getPageNum(),feedBack.getPageSize());
        return feedbackMapper.selectAll();
    }

    @Override
    public FeedBack selectId(FeedBack feedBack) {
        return feedbackMapper.selectId(feedBack);
    }

    @Override
    public void update(FeedBack feedBack) {
        feedbackMapper.updateStatus(feedBack);
    }
}
