package com.example.studentnotes.service;

import com.example.studentnotes.model.Confirme;

import java.util.List;

public interface ConfirmeService {
    void insertSelective(Confirme confirme);

    Confirme selectByPrimaryKey(Confirme confirme);
    List<Confirme> selectAll(Confirme confirme);
    void update(Confirme confirme);
}
