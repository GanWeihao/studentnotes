package com.example.studentnotes.service.impl;


import com.example.studentnotes.mapper.RecordMapper;
import com.example.studentnotes.model.Record;
import com.example.studentnotes.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    RecordMapper recordMapper;
    @Override
    public void insert(Record record) {
        recordMapper.insertSelective(record);
    }

    @Override
    public List<Record> select(Record record) {
        return recordMapper.selectByStatus(record);
    }

    @Override
    public List<Record> selectUserId(Record record) {
        return recordMapper.selectByUserId(record);
    }


}
