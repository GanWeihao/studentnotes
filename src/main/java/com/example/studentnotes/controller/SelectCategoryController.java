package com.example.studentnotes.controller;

import com.example.studentnotes.Bo.CategoryRespBo;
import com.example.studentnotes.model.Category;
import com.example.studentnotes.service.CategoryService;
import com.example.studentnotes.util.Constants;
import com.example.studentnotes.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SelectCategoryController {
    @Autowired
    CategoryService categoryService;

    @ResponseBody
    @RequestMapping(value = "/category/select",method = RequestMethod.GET)
    public JsonResult select(Category category){
        JsonResult jr;
        try{
          List<Category> list= categoryService.findAllCategory(category);
            if(list.size()>0){
                jr = new JsonResult(Constants.STATUS_SUCCESS,"查询成功！",list);
            }else{
                jr = new JsonResult(Constants.STATUS_NOT_FOUND,"暂无数据！");
            }
        }catch(Exception e){
            jr = new JsonResult(Constants.STATUS_FAIL,"查询异常！");
        }
        return jr;
    }
    @ResponseBody
    @RequestMapping(value = "/category/selectBycategory",method = RequestMethod.GET)
    public JsonResult select11(){
        JsonResult jr;
        try{
            List<CategoryRespBo> list= categoryService.select();
            if(null == list || list.size() ==0 ){
                jr = new JsonResult(Constants.STATUS_NOT_FOUND,"暂无数据！");

            }else{
                jr = new JsonResult(Constants.STATUS_SUCCESS,"查询成功！",list);
            }
        }catch(Exception e){
            jr = new JsonResult(Constants.STATUS_FAIL,"查询异常！");
        }
        return jr;
    }

    @ResponseBody
    @RequestMapping(value = "/category/selectId",method = RequestMethod.GET)
    public JsonResult select1(Category category){
        System.out.println(category.getCategoryName());
        JsonResult jr;
        try{
            Category category1 = categoryService.selectByName(category);
            System.out.println(category1.getCategoryId());
                jr = new JsonResult(Constants.STATUS_SUCCESS,"查询成功！",category1);

        }catch(Exception e){
            System.out.println(e.getMessage().toString());
            jr = new JsonResult(Constants.STATUS_FAIL,"查询异常！");
        }
        return jr;
    }

    //添加类别
    @ResponseBody
    @RequestMapping(value = "/category/add",method = RequestMethod.GET)
    public JsonResult add(Category category){
        JsonResult jr;
        try{
            categoryService.insert(category);
            jr = new JsonResult(Constants.STATUS_SUCCESS,"添加成功!");
        }catch (Exception e){
            jr = new JsonResult(Constants.STATUS_FAIL,"添加异常!");
        }
        return jr;
    }

    //修改类别
    @ResponseBody
    @RequestMapping(value = "/category/update",method = RequestMethod.GET)
    public JsonResult update(Category category){
        JsonResult jr;
        try{
            category.setCategoryName(category.getCategoryName());
            categoryService.updateByPrimaryKeySelective(category);
            jr = new JsonResult(Constants.STATUS_SUCCESS,"修改成功!");
        }catch (Exception e){
            jr = new JsonResult(Constants.STATUS_FAIL,"修改异常!");
        }
        return jr;
    }
}
