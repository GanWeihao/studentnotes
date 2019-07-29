package com.example.studentnotes.controller;

import com.example.studentnotes.Bo.ArticleRespBo;
import com.example.studentnotes.model.*;
import com.example.studentnotes.service.*;
import com.example.studentnotes.util.Constants;
import com.example.studentnotes.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AdminController {
    @Autowired
    UserService userService;
    @Autowired
    FeedBackService feedbackService;
    @Autowired
    ConfirmeService confirmeService;
    @Autowired
    UfileService ufileService;
    @Autowired
    ArticleService articleService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    CommentsService commentsService;
    @Autowired
    AdminService adminService;
    //管理员设置用户为学霸
    @ResponseBody
    @RequestMapping(value = "/admin/setsmartstu", method = RequestMethod.GET)
    public JsonResult setSmartStu(Confirme confirme) {
        JsonResult jr;
        System.out.println(confirme.toString());
        try {
//                if(user!=null){
            User user = new User();
            user.setUserId(confirme.getConfirmeUserId());
            userService.setSmartStu(user);
            confirme.setConfirmeStatus(1);
            confirmeService.update(confirme);
//                    User u = userService.findById(user.getUserId());
            jr = new JsonResult(Constants.STATUS_SUCCESS, "修改成功！");
//                }else{
//                    jr = new JsonResult(Constants.STATUS_NOT_FOUND,"用户不存在！");
//                }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            jr = new JsonResult(Constants.STATUS_ERROR, "修改异常！");
        }
        return jr;
    }

    //管理员封禁用户
    @ResponseBody
    @RequestMapping(value = "/admin/banneduser", method = RequestMethod.GET)
    public JsonResult bannedUser(User user) {
        JsonResult jr;
        try {
            if (user != null) {
                userService.bannedUser(user);
                User u = userService.findById(user.getUserId());
                jr = new JsonResult(Constants.STATUS_SUCCESS, "修改成功！", u);
            } else {
                jr = new JsonResult(Constants.STATUS_NOT_FOUND, "用户不存在！");
            }
        } catch (Exception e) {
            jr = new JsonResult(Constants.STATUS_ERROR, "修改异常！");
        }
        return jr;
    }

    //管理员设置学生毕业或退学
    @ResponseBody
    @RequestMapping(value = "/admin/setstudent", method = RequestMethod.GET)
    public JsonResult setStudent(User user) {
        JsonResult jr;
        try {
            if (user != null) {
                userService.setStudent(user);
                User u = userService.findById(user.getUserId());
                jr = new JsonResult(Constants.STATUS_SUCCESS, "修改成功！", u);
            } else {
                jr = new JsonResult(Constants.STATUS_NOT_FOUND, "用户不存在！");
            }
        } catch (Exception e) {
            jr = new JsonResult(Constants.STATUS_ERROR, "修改异常！");
        }
        return jr;
    }

    //查询符合条件的用户
    @ResponseBody
    @RequestMapping(value = "/user/select", method = RequestMethod.GET)
    public JsonResult login11(User user) {
        JsonResult jr;
        try {
            List<User> u = userService.findUser(user);
            jr = new JsonResult(Constants.STATUS_SUCCESS, "查找成功！", u);
        } catch (Exception e) {
            jr = new JsonResult(Constants.STATUS_FAIL, "查找异常！");
        }
        return jr;
    }

    //根据用户ID删除用户
    @ResponseBody
    @RequestMapping(value = "/admin/deleteuser", method = RequestMethod.GET)
    public JsonResult deleteUser(User user) {
        JsonResult jr;
        try {
            if (user != null) {
                userService.deleteUser(user);
                jr = new JsonResult(Constants.STATUS_SUCCESS, "删除成功！");
            } else {
                jr = new JsonResult(Constants.STATUS_NOT_FOUND, "用户不存在！");
            }
        } catch (Exception e) {
            jr = new JsonResult(Constants.STATUS_ERROR, "删除异常！");
        }
        return jr;
    }

    //根据反馈ID删除反馈
    @ResponseBody
    @RequestMapping(value = "/feedback/update", method = RequestMethod.GET)
    public JsonResult deleteFeedback(FeedBack feedBack) {
        JsonResult jr;
        try {
            feedbackService.update(feedBack);
            jr = new JsonResult(Constants.STATUS_SUCCESS, "查阅成功");
        } catch (Exception e) {
            jr = new JsonResult(Constants.STATUS_FAIL, "异常！");
        }
        return jr;
    }

    //查所有反馈
    @ResponseBody
    @RequestMapping(value = "/feedback/select", method = RequestMethod.GET)
    public JsonResult select(FeedBack feedBack) {
        JsonResult jr;
        try {
            List<FeedBack> list = feedbackService.selectAll(feedBack);
            jr = new JsonResult(Constants.STATUS_SUCCESS, "成功！", list);
        } catch (Exception e) {
            jr = new JsonResult(Constants.STATUS_FAIL, "反馈异常！");
        }
        return jr;
    }
    //查所有反馈id
    @ResponseBody
    @RequestMapping(value = "/feedback/selectId", method = RequestMethod.GET)
    public JsonResult selectId(FeedBack feedBack) {
        JsonResult jr;
        try {
            FeedBack feedBack1 = feedbackService.selectId(feedBack);
            jr = new JsonResult(Constants.STATUS_SUCCESS, "成功！", feedBack1);
        } catch (Exception e) {
            jr = new JsonResult(Constants.STATUS_FAIL, "异常！");
        }
        return jr;
    }

    //查所有用户、文件、文章总量
    @ResponseBody
    @RequestMapping(value="/admin/selectNum",method = RequestMethod.GET)
    public JsonResult selectNum(){
        JsonResult jr;
        List list = new ArrayList();
        try {
            int u = userService.selectUserNum().size();
            int f = ufileService.selectFileNum().size();
            int a = articleService.selectArticleNum().size();
            list.add(u);
            list.add(f);
            list.add(a);
            jr = new JsonResult(Constants.STATUS_SUCCESS, "成功！",list);
        }catch (Exception e) {
            jr = new JsonResult(Constants.STATUS_FAIL, "异常！");
        }

        return jr;
    }

    //删除文章
    @ResponseBody
    @RequestMapping(value = "/article/delete",method = RequestMethod.GET)
    public JsonResult delete(Article article){
        JsonResult jr;
        try{
            article.setArticleStatus(1);
           articleService.updateByPrimaryKeySelective(article);
           jr = new JsonResult(Constants.STATUS_SUCCESS,"删除成功");
        }catch (Exception e){
            jr = new JsonResult(Constants.STATUS_FAIL,"删除异常");
        }
        return jr;
    }

    //删除评论
    @ResponseBody
    @RequestMapping(value = "/comments/delete",method = RequestMethod.GET)
    public JsonResult delete(Comments comments){
        JsonResult jr;
        try{
            commentsService.deletecomments(comments);
            jr = new JsonResult(Constants.STATUS_SUCCESS,"删除成功");
        }catch (Exception e){
            jr = new JsonResult(Constants.STATUS_FAIL,"删除异常");
        }
        return jr;
    }

    //删除类别
    @ResponseBody
    @RequestMapping(value = "/category/delete",method = RequestMethod.GET)
    public JsonResult delete(Category category){
        JsonResult jr;
        try{
            categoryService.deleteByPrimaryKey(category);
            jr = new JsonResult(Constants.STATUS_SUCCESS,"删除成功");
        }catch (Exception e){
            jr = new JsonResult(Constants.STATUS_FAIL,"删除异常");
        }
        return jr;
    }
    //wenjian
    @ResponseBody
    @RequestMapping(value = "/ufile/select",method = RequestMethod.GET)
    public JsonResult select(){
        JsonResult jr;
        try{
             List<Ufile> list = ufileService.selectAll();
            jr = new JsonResult(Constants.STATUS_SUCCESS,"查询成功",list);
        }catch (Exception e){

            jr = new JsonResult(Constants.STATUS_FAIL,"查询异常");
        }
        return jr;
    }
    //shan wenjian
    @ResponseBody
    @RequestMapping(value = "/ufile/delete",method = RequestMethod.GET)
    public JsonResult udelete(Ufile ufile){
        JsonResult jr;
        try{
            ufileService.deleteByPrimaryKey(ufile);
            jr = new JsonResult(Constants.STATUS_SUCCESS,"删除成功");
        }catch (Exception e){
            jr = new JsonResult(Constants.STATUS_FAIL,"删除异常");
        }
        return jr;
    }
    //wen zhang
    @ResponseBody
    @RequestMapping(value = "/artice/all",method = RequestMethod.GET)
    public JsonResult all(){
        JsonResult jr;
        try{
            List<Article> list  =articleService.selectAll();
            jr = new JsonResult(Constants.STATUS_SUCCESS,"查询成功",list);
        }catch (Exception e){
            jr = new JsonResult(Constants.STATUS_FAIL,"查询异常");
        }
        return jr;
    }

    //登录
    @ResponseBody
    @RequestMapping(value = "/admin/login",method = RequestMethod.POST)
    public JsonResult login(Admin admin){
        JsonResult jr;
        try{
            Admin admin1  =adminService.login(admin);
            jr = new JsonResult(Constants.STATUS_SUCCESS,"成功",admin1);
        }catch (Exception e){
            jr = new JsonResult(Constants.STATUS_FAIL,"异常");
        }
        return jr;
    }

    //wen zhang
    @ResponseBody
    @RequestMapping(value = "/artice/all1",method = RequestMethod.GET)
    public JsonResult all1(){
        JsonResult jr;
        try{
            List<ArticleRespBo> list  =articleService.select();

            jr = new JsonResult(Constants.STATUS_SUCCESS,"查询成功",list);
        }catch (Exception e){

            jr = new JsonResult(Constants.STATUS_FAIL,"查询异常");
        }
        return jr;
    }

    //wen zhang
    @ResponseBody
    @RequestMapping(value = "/category/random",method = RequestMethod.GET)
    public JsonResult all11(){
        JsonResult jr;
        try{
            List<Category> list  = categoryService.selectR();

            jr = new JsonResult(Constants.STATUS_SUCCESS,"查询成功",list);
        }catch (Exception e){

            jr = new JsonResult(Constants.STATUS_FAIL,"查询异常");
        }
        return jr;
    }
}

