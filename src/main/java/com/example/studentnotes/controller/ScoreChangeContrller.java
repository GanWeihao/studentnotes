package com.example.studentnotes.controller;

import com.example.studentnotes.model.User;
import com.example.studentnotes.service.UserService;
import com.example.studentnotes.util.Constants;
import com.example.studentnotes.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lwx on 2019/4/29.
 */
@RestController
public class ScoreChangeContrller {

    @Autowired
    UserService userService;

    //加分
    @ResponseBody
    @RequestMapping(value = "/user/add",method = RequestMethod.GET)
    public JsonResult changeScore(User user){
        JsonResult jr;
        try{
            userService.AddScore(user);
                jr = new JsonResult(Constants.STATUS_SUCCESS,"充值成功！");

        }catch(Exception e){
            jr = new JsonResult(Constants.STATUS_FAIL,"充值异常！");
        }
        return jr;
    }

    //扣分
    @ResponseBody
    @RequestMapping(value = "/user/minus",method = RequestMethod.GET)
    public JsonResult changeScore1(User user){
        JsonResult jr;
        try{
            User u = userService.findById(user.getUserId());
            if(u.getUserIntegral()-user.getUserIntegral() < 0){
                return new JsonResult(Constants.STATUS_ERROR,"扣除失败，剩余积分不足！");
            }else{
                userService.MinusScore(user);
                jr = new JsonResult(Constants.STATUS_SUCCESS,"扣除成功！");
            }
        }catch(Exception e){
            jr = new JsonResult(Constants.STATUS_FAIL,"扣除异常！");
        }
        return jr;
    }

}

