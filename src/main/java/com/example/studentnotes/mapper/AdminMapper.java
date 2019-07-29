package com.example.studentnotes.mapper;

import com.example.studentnotes.model.Admin;
import com.example.studentnotes.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component("AdminMapper")
public interface AdminMapper {
    Admin adminSelect(Admin admin);
}
