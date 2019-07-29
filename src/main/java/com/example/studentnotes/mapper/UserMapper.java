package com.example.studentnotes.mapper;

import com.example.studentnotes.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("UserMapper")
public interface UserMapper {
    //登录
    User userLogin(User user);
    //查找用户
    List<User> findUser(User user);
    //根据学号查找用户
    User findByStuId(@Param("userStuId") String userStuId);
    //根据ID查找用户
    User findById(@Param("userId") String userId);
    //注册
    void userRegister(User user);
    //更新信息
    void updateData(User user);
    //上传加积分
    void upload(User user);
    //下载减积分
    void download(User user);
    //扣分
    void updateMinusScore(User user);
    //加分
    void updateAddScore(User user);
    List<User> selectAll();
    List<User> selectId(@Param("string") String string);

    //对User进行操作
    //管理员设置用户为学霸
    void setSmartStu(User user);
    //管理员封禁用户
    void bannedUser(User user);
    //管理员设置学生毕业或退学
    void setStudent(User user);
    //根据用户ID删除用户
    void deleteUser(User user);
}
