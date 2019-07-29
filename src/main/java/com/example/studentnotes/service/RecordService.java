package com.example.studentnotes.service;


import com.example.studentnotes.model.Record;

import java.util.List;

public interface RecordService {

    void insert(Record record);
    List<Record> select(Record record);
    List<Record> selectUserId(Record record);
}
