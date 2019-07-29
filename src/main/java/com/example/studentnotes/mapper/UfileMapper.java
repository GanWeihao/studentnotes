package com.example.studentnotes.mapper;

import com.example.studentnotes.model.Ufile;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("UfileMapper")
public interface UfileMapper {
    //更新文件信息
    void updateByPrimaryKeySelective(Ufile ufile);
    //根据ID删除文件
    void deleteByPrimaryKey(Ufile ufile);
    //上传文件
    void insert(Ufile ufile);
    //根据ID查文件
    Ufile selectByPrimaryKey(Ufile ufile);
    //文件下载，次数+1
    void download(Ufile ufile);
    //根据文件标题模糊搜索
    List<Ufile> selectByTitle(Ufile ufile);
    //根据用户ID查询文件
    List<Ufile> selectByUserId(Ufile ufile);

    //文件总量
    List<Ufile> selectAll();

    List<Ufile> selectByCategory(Integer integer);
    void updateUfile(Ufile ufile);
}