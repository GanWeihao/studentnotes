package com.example.studentnotes.service;

import com.example.studentnotes.model.FeedBack;

import java.util.List;

public interface FeedBackService {

    public void addFeedBack(FeedBack feedBack);

    public void deleteFeedBack(FeedBack feedBack);
    List<FeedBack> selectAll(FeedBack feedBack);
    FeedBack selectId(FeedBack feedBack);
    void update(FeedBack feedBack);
}
