package com.example.studentnotes.mapper;

import com.example.studentnotes.model.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("CategoryMapper")
public interface CategoryMapper {
    //添加类别
    void insert(Category category);
    //查询类别
    Category selectByPrimaryKey(Category category);
    //删除类别
    void deleteByPrimaryKey(Category category);
    //更新类别
    void updateByPrimaryKeySelective(Category category);
    //查询所有类别
    List<Category> selectAll();
    Category selectByName(Category category);

    List<Category> selectR();
}