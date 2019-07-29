package com.example.studentnotes.service.impl;

import com.example.studentnotes.mapper.CollectionMapper;
import com.example.studentnotes.model.Collection;
import com.example.studentnotes.service.CollectionService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionServiceImpl implements CollectionService {
    @Autowired
    CollectionMapper collectionMapper;

    @Override
    public List<Collection> selectByPrimaryKey(Collection collection) {
        PageHelper.startPage(collection.getPageNum(),collection.getPageSize());
        return collectionMapper.selectByPrimaryKey(collection);
    }

    @Override
    public List<Collection> selectByArticle(Collection collection) {
        return collectionMapper.selectByArticle(collection);
    }

    @Override
    public void deleteByPrimaryKey(Collection collection) {
        collectionMapper.deleteByPrimaryKey(collection);
    }

    @Override
    public void insert(Collection collection) {
        collectionMapper.insert(collection);
    }
}