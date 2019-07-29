package com.example.studentnotes.mapper;

import com.example.studentnotes.model.Confirme;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component("ConfirmeMapper")
public interface ConfirmeMapper {
    void deleteByPrimaryKey(Integer confirmeId);

    void insert(Confirme record);

    void insertSelective(Confirme record);

    Confirme selectByPrimaryKey(Integer confirmeId);

    void updateByPrimaryKeySelective(Confirme record);

    void updateByPrimaryKeyWithBLOBs(Confirme record);

    void updateByPrimaryKey(Confirme record);


    Confirme selectByPrimaryKey(Confirme confirme);
    List<Confirme> selectAll();




}