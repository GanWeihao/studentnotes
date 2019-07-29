package com.example.studentnotes.service.impl;

import com.example.studentnotes.Bo.CategoryRespBo;
import com.example.studentnotes.mapper.CategoryMapper;
import com.example.studentnotes.model.Category;
import com.example.studentnotes.model.Ufile;
import com.example.studentnotes.service.CategoryService;
import com.example.studentnotes.service.UfileService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    UfileService ufileService;

    @Override
    public void insert(Category category) {
        categoryMapper.insert(category);
    }

    @Override
    public Category selectByPrimaryKey(Category category) {
        return categoryMapper.selectByPrimaryKey(category);
    }

    @Override
    public void deleteByPrimaryKey(Category category) {
        categoryMapper.deleteByPrimaryKey(category);
    }

    @Override
    public void updateByPrimaryKeySelective(Category category) {
        categoryMapper.updateByPrimaryKeySelective(category);
    }

    @Override
    public List<Category> findAllCategory(Category category) {
        PageHelper.startPage(category.getPageNum(),category.getPageSize());
        return categoryMapper.selectAll();
    }

    @Override
    public Category selectByName(Category category) {
        return categoryMapper.selectByName(category);
    }

    @Override
    public List<CategoryRespBo> select() {
        List<CategoryRespBo> categoryRespBos = new ArrayList<CategoryRespBo>();
        List<Category> lists = categoryMapper.selectAll();
        if(lists != null){
            for(int i=0;i<lists.size();i++){
                CategoryRespBo categoryRespBo= new CategoryRespBo();
                categoryRespBo.setCategoryId(lists.get(i).getCategoryId());
                categoryRespBo.setCategoryName(lists.get(i).getCategoryName());
                List<Ufile> ufileList = ufileService.selectByCategory(lists.get(i).getCategoryId());
                categoryRespBo.setUfiles(ufileList);
                categoryRespBos.add(categoryRespBo);
            }
        }else{
            return null;
        }
        return categoryRespBos;
    }

    @Override
    public List<Category> selectR() {
        return categoryMapper.selectR();
    }

}