package com.example.studentnotes.service;

import com.example.studentnotes.Bo.CategoryRespBo;
import com.example.studentnotes.model.Category;

import java.util.List;

public interface CategoryService {
    //添加类别
    public void insert(Category category);
    //查询类别
    public Category selectByPrimaryKey(Category category);
    //删除类别
    public void deleteByPrimaryKey(Category category);
    //更新类别
    public void updateByPrimaryKeySelective(Category category);
    //查询所有类别
    public List<Category> findAllCategory(Category category);
    Category selectByName(Category category);
    List<CategoryRespBo> select();
    List<Category> selectR();
}