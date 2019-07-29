package com.example.studentnotes.service;

import com.example.studentnotes.model.Ufile;

import java.util.List;

public interface UfileService {
    //更新文件信息
    public void updateByPrimaryKeySelective(Ufile ufile);
    //根据ID删除文件
    public void deleteByPrimaryKey(Ufile ufile);
    //上传文件
    public void insert(Ufile ufile);
    //根据ID查文件
    public Ufile selectByPrimaryKey(Ufile ufile);
    //文件下载，次数+1
    public void download(Ufile ufile);
    //根据文件标题模糊搜索
    public List<Ufile> selectByTitle(Ufile ufile);
    //根据用户ID查询文件
    public List<Ufile> selectByUserId(Ufile ufile);

    //文件总量
    public List selectFileNum();

    List<Ufile> selectByCategory(Integer integer);

    List<Ufile> selectAll();
}
