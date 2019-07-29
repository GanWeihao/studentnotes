package com.example.studentnotes.mapper;

import com.example.studentnotes.model.FeedBack;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("FeedBackMapper")
public interface FeedBackMapper {
    //添加反馈
    void addFeedBack(FeedBack feedBack);
    //删除反馈
    void deleteFeedBack(FeedBack feedBack);
    FeedBack selectId(FeedBack feedBack);
    List<FeedBack> selectAll();

    void updateStatus(FeedBack feedBack);
}
