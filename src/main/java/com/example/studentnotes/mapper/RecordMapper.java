package com.example.studentnotes.mapper;

import com.example.studentnotes.model.Record;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("RecordMapper")
public interface RecordMapper {
    void deleteByPrimaryKey(String recordId);

    void insert(Record record);

    void insertSelective(Record record);

    Record selectByPrimaryKey(String recordId);

    void updateByPrimaryKeySelective(Record record);

    void updateByPrimaryKey(Record record);

    List<Record> selectByStatus(Record record);

    List<Record> selectByUserId(Record record);
}