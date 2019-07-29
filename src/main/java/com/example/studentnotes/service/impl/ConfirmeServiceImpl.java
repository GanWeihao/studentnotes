package com.example.studentnotes.service.impl;

import com.example.studentnotes.mapper.ConfirmeMapper;
import com.example.studentnotes.model.Confirme;
import com.example.studentnotes.service.ConfirmeService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfirmeServiceImpl implements ConfirmeService {
    @Autowired
    ConfirmeMapper confirmeMapper;

    @Override
    public void insertSelective(Confirme confirme) {
        confirmeMapper.insertSelective(confirme);
    }

    @Override
    public Confirme selectByPrimaryKey(Confirme confirme) {
        return confirmeMapper.selectByPrimaryKey(confirme);
    }

    @Override
    public List<Confirme> selectAll(Confirme confirme) {
        PageHelper.startPage(confirme.getPageNum(),confirme.getPageSize());
        return confirmeMapper.selectAll();
    }

    @Override
    public void update(Confirme confirme) {
        confirmeMapper.updateByPrimaryKeySelective(confirme);
    }
}
