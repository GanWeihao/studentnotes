package com.example.studentnotes.service.impl;

import com.example.studentnotes.mapper.UfileMapper;
import com.example.studentnotes.model.Ufile;
import com.example.studentnotes.service.UfileService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UfileServiceImpl implements UfileService {
    @Autowired
    UfileMapper ufileMapper;

    @Override
    public void updateByPrimaryKeySelective(Ufile ufile) {
        ufileMapper.updateByPrimaryKeySelective(ufile);
    }

    @Override
    public void deleteByPrimaryKey(Ufile ufile) {
        ufileMapper.updateUfile(ufile);
    }

    @Override
    public void insert(Ufile ufile) {
        ufileMapper.insert(ufile);
    }

    @Override
    public Ufile selectByPrimaryKey(Ufile ufile) {
        return ufileMapper.selectByPrimaryKey(ufile);
    }

    @Override
    public void download(Ufile ufile) {
        ufileMapper.download(ufile);
    }

    @Override
    public List<Ufile> selectByTitle(Ufile ufile) {
        PageHelper.startPage(ufile.getPageNum(),ufile.getPageSize());
        String title = ufile.getUfileTitle();
        ufile.setUfileTitle("%"+title+"%");
        return ufileMapper.selectByTitle(ufile);
    }

    @Override
    public List<Ufile> selectByUserId(Ufile ufile) {
        return null;
    }

    @Override
    public List selectFileNum() {
        return ufileMapper.selectAll();
    }

    @Override
    public List<Ufile> selectByCategory(Integer integer) {
        return ufileMapper.selectByCategory(integer);
    }

    @Override
    public List<Ufile> selectAll() {
        return ufileMapper.selectAll();
    }
}
