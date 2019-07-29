package com.example.studentnotes.service;

import com.example.studentnotes.model.User;

import java.util.List;

public interface UserService {
    public User userLogin(User user);

    public List<User> findUser(User user);

    public User findById(String userId);

    public void updateData(User user);

    public void userRegister(User user);

    //上传加积分
    public void upload(User user);
    //下载减积分
    public void download(User user);

    //加分
    public void AddScore(User user);
    //扣分
    public void MinusScore(User user);

    //对User进行操作
    //管理员设置用户为学霸
    public void setSmartStu(User user);
    //管理员封禁用户
    public void bannedUser(User user);
    //管理员设置学生毕业或退学
    public void setStudent(User user);
    //根据用户ID删除用户
    public void deleteUser(User user);

    List<User> selectAll(User user);
    List<User> selectId(String string);

    //用户总量
    public List selectUserNum();
}
