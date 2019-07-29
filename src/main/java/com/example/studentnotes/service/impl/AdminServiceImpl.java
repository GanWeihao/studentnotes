package com.example.studentnotes.service.impl;

import com.example.studentnotes.mapper.AdminMapper;
import com.example.studentnotes.model.Admin;
import com.example.studentnotes.model.User;
import com.example.studentnotes.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;
    @Override
    public Admin login(Admin admin) {
        return adminMapper.adminSelect(admin);
    }
}
