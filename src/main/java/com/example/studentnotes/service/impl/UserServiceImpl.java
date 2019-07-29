package com.example.studentnotes.service.impl;

import com.example.studentnotes.mapper.UserMapper;
import com.example.studentnotes.model.User;
import com.example.studentnotes.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User userLogin(User user) {
        return userMapper.userLogin(user);
    }

    @Override
    public List<User> findUser(User user){
        PageHelper.startPage(user.getPageNum(),user.getPageSize());
        return userMapper.findUser(user);
    }

    @Override
    public User findById(String userId){
        return userMapper.findById(userId);
    }

    @Override
    public void updateData(User user){
        userMapper.updateData(user);
    }

    @Override
    public void userRegister(User user) {
        userMapper.userRegister(user);
    }

    @Override
    public void upload(User user) {
        userMapper.upload(user);
    }

    @Override
    public void download(User user) {
        userMapper.download(user);
    }

    @Override
    public void AddScore(User user) {
        userMapper.updateAddScore(user);
    }

    @Override
    public void MinusScore(User user) {
        userMapper.updateMinusScore(user);
    }

    @Override
    public void setSmartStu(User user) {
        userMapper.setSmartStu(user);
    }

    @Override
    public void bannedUser(User user) {
        userMapper.bannedUser(user);
    }

    @Override
    public void setStudent(User user) {
        userMapper.setStudent(user);
    }

    @Override
    public void deleteUser(User user) {
        userMapper.deleteUser(user);
    }

    @Override
    public List<User> selectAll(User user) {
        PageHelper.startPage(user.getPageNum(),user.getPageSize());
        return userMapper.selectAll();
    }

    @Override
    public List<User> selectId(String string) {
        return userMapper.selectId(string);
    }

    @Override
    public List selectUserNum() {
        return userMapper.selectAll();
    }

}
