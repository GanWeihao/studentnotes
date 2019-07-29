package com.example.studentnotes.controller;


import com.example.studentnotes.model.*;
import com.example.studentnotes.service.*;
import com.example.studentnotes.util.Constants;
import com.example.studentnotes.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    FeedBackService feedBackService;
    @Autowired
    ConfirmeService confirmeService;
    @Autowired
    ArticleService articleService;
    @Autowired
    UfileService ufileService;
    @Autowired
    CommentsService commentsService;
    @Autowired
    CollectionService collectionService;
    @Autowired
    RecordService recordService;


    //登陆
    @ResponseBody
    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    public JsonResult login(User user){
        JsonResult jr;
        try{
            User u = userService.userLogin(user);
                if(u!=null){
                    jr = new JsonResult(Constants.STATUS_SUCCESS,"登陆成功！",u);
                }else{
                    jr = new JsonResult(Constants.STATUS_NOT_FOUND,"账号或密码错误！");
                }
        }catch(Exception e){
            jr = new JsonResult(Constants.STATUS_FAIL,"登陆异常！");
        }
        return jr;
    }

    //修改用户信息
    @ResponseBody
    @RequestMapping(value = "/user/update",method = RequestMethod.GET)
    public JsonResult update(User user){
        JsonResult jr;
        try{
            userService.updateData(user);
            jr = new JsonResult(Constants.STATUS_SUCCESS,"修改成功！");
        }catch (Exception e){
            jr = new JsonResult(Constants.STATUS_FAIL,"修改异常！");
        }
        return jr;
    }

    //用户反馈
    @ResponseBody
    @RequestMapping(value = "/user/addfeedback",method = RequestMethod.GET)
    public JsonResult addFeedback(FeedBack feedBack){
        JsonResult jr;
        try{
            if(feedBack!=null){
                feedBackService.addFeedBack(feedBack);
                jr = new JsonResult(Constants.STATUS_SUCCESS,"反馈成功！",feedBack);
            }else{
                jr = new JsonResult(Constants.STATUS_ERROR,"反馈失败！");
            }
        }catch (Exception e){
            jr = new JsonResult(Constants.STATUS_FAIL,"反馈异常！");
        }
        return jr;
    }

    //学霸申请
    @ResponseBody
    @RequestMapping(value = "/user/applysmart",method = RequestMethod.POST)
    public JsonResult applysma(@RequestParam("file")MultipartFile [] files, Confirme confirme) throws IOException {
        JsonResult jr;
       // String id = confirme.getConfirmeUserId();

       // User u = userService.findById(id);

        //if(u.getUserRank()!=0){
            try{
                for(MultipartFile file : files){
                    //获取文件名
                    String fileName = file.getOriginalFilename();
                    System.out.println(fileName);
                    //获取文件后缀名
                    String suffixName = fileName.substring(fileName.lastIndexOf("."));
                    if(".jpg".equalsIgnoreCase(suffixName)||".png".equalsIgnoreCase(suffixName)){
                        String uuid = UUID.randomUUID().toString().replace("-","");
                        //重新生成文件名
                        fileName = uuid+suffixName;
                        //指定本地文件夹存储图片
                        String filePath = "C:\\APPimg\\wx\\";
                        String ss =filePath.replace("\\","\\\\");
                        File dir = new File(filePath);
                        if(!dir.exists()){
                            dir.mkdir();
                        }
                        confirme.setConfirmeImgUrl("http://154.8.199.136:8089/wx/"+fileName);
                       // confirme.setConfirmeUserStuid(u.getUserStuId());
                        confirmeService.insertSelective(confirme);
                        file.transferTo(new File(filePath+fileName));
                    }else{
                        return new JsonResult(Constants.STATUS_NOT_FOUND,"提交失败，文件格式有误！");
                    }
                }
                jr = new JsonResult(Constants.STATUS_SUCCESS,"提交成功！");
            }catch (Exception e){
                jr = new JsonResult(Constants.STATUS_ERROR,"提交失败，异常！");
            }
        //}else{
        //    jr = new JsonResult(Constants.STATUS_ERROR,"提交失败，你已经是学霸了！");
        //}
        return jr;
    }

    //上传文件    RecordStatus  1    上传   2  下载
    @ResponseBody
    @RequestMapping(value = "/user/release",method = RequestMethod.POST)
    public JsonResult release(MultipartFile file, Ufile ufile){
        JsonResult jr;
         //if(u.getUserRank()!=0){
            if(file.isEmpty()){
                return new JsonResult(Constants.STATUS_NOT_FOUND,"上传失败，未选择文件！");
            }
            //获取文件名
            String fileName = file.getOriginalFilename();
            Record record = new Record();
            record.setRecordId(UUID.randomUUID().toString());
            record.setRceordTime(new Date());
            record.setRecordStatus(1);
            record.setRecordUfileName(fileName);
            record.setRecordUserId(ufile.getUfileUserId());
            //获取文件后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            String uuid= UUID.randomUUID().toString().replace("-","");
            //重新生成文件名
            fileName = uuid+suffixName;
            //指定本地文件夹存储文件
            String filePath = "C:\\root\\";
            String ss =filePath.replace("\\","\\\\");
            File dir = new File(filePath);
            if(!dir.exists()){
                dir.mkdir();
            }
            try {
                User user = new User();
                user.setUserId(ufile.getUfileUserId());
                //User u = userService.findById(ufile.getUfileUserId());
               // ufile.setUfileName(file.getOriginalFilename());
                ufile.setUfileUrl(ss+fileName);
                ufile.setUfileName(fileName);
                ufileService.insert(ufile);
                userService.upload(user);
                recordService.insert(record);
                file.transferTo(new File(filePath+fileName));
                jr = new JsonResult(Constants.STATUS_SUCCESS,"上传成功！",ufile);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                jr = new JsonResult(Constants.STATUS_FAIL,"上传异常！");
            }
        //}else{
            //jr = new JsonResult(Constants.STATUS_ERROR,"用户为普通用户，无法上传文件！");
        //}
        return jr;
    }

    //下载文件
    @ResponseBody
    @RequestMapping(value = "/user/download",method = RequestMethod.GET)
    public void download(HttpServletResponse response, Ufile file, User user) throws UnsupportedEncodingException {

        String realPath = file.getUfileUrl();
        String fileName = file.getUfileName();

        response.setContentType("application/force-download");
        response.addHeader("Content-Disposition", "attachment;fileName=" +
                new String(fileName.getBytes("gbk"), "iso8859-1"));
        response.setContentType("multipart/form-data;charset=UTF-8");
        InputStream in = null;
        BufferedInputStream ins = null;
        OutputStream out = null;
        Record record = new Record();
        record.setRecordId(UUID.randomUUID().toString());
        record.setRceordTime(new Date());
        record.setRecordStatus(2);
        record.setRecordUfileName(fileName);
        record.setRecordUserId(file.getUfileUserId());
        try{
            ufileService.download(file);
            //User u = userService.findById(file.getUfileUserId());
            //userService.upload(u);
            userService.download(user);
            recordService.insert(record);
            //获取文件输入流
            in = new FileInputStream(realPath);
            ins = new BufferedInputStream(in);
            out = new BufferedOutputStream(response.getOutputStream());
            byte[] buffer = new byte[1024];
            while(true){
                int i = in.read(buffer);
                if(i==-1){
                    break;
                }
                out.write(buffer,0,i);
            }
            out.flush();
            out.close();
            ins.close();

        }catch (Exception e){
            System.out.println(e.getMessage()+"----");
        }finally {
            if(ins!=null){
                try {
                    ins.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(out!=null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //删除文章
    @ResponseBody
    @RequestMapping(value = "user/deletearticle",method = RequestMethod.GET)
    public JsonResult deleteart(Article article){
        JsonResult jr;
        try{
            articleService.deleteByPrimaryKey(article);
            jr = new JsonResult(Constants.STATUS_SUCCESS,"删除成功！");
        }catch (Exception e){
            jr = new JsonResult(Constants.STATUS_FAIL,"删除失败！");
        }
        return jr;
    }

    //标题查询文章
    @ResponseBody
    @RequestMapping(value = "/user/selectart",method = RequestMethod.GET)
    public JsonResult selectart(Article article){
        JsonResult jr;
        try{
            List<Article> articles =  articleService.selectByTitle(article);
            jr = new JsonResult(Constants.STATUS_SUCCESS,"查询成功！",articles);
        }catch (Exception e){
            jr = new JsonResult(Constants.STATUS_FAIL,"查询失败！");
        }
        return jr;
    }

    //发布文章
    @ResponseBody
    @RequestMapping(value = "/user/addarticle",method = RequestMethod.POST)
    public JsonResult addarticle(MultipartFile file,Article article) throws IOException {
        JsonResult jr;
        //获取文件名
        if(file != null){
            String fileName = file.getOriginalFilename();
            //获取文件后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            String uuid= UUID.randomUUID().toString().replace("-","");
            //重新生成文件名
            fileName = uuid+suffixName;
            //指定本地文件夹存储文件
            String filePath = "C:\\APPimg\\wx\\";
            String ss =filePath.replace("\\","\\\\");
//            "http://154.8.199.136:8089/wx/";
            File dir = new File(filePath);
            if(!dir.exists()){
                dir.mkdir();
            }
            article.setArticleUrl("http://154.8.199.136:8089/wx/"+fileName);

            file.transferTo(new File(ss+fileName));
        }

        try{
            article.setArticleTime(new Date());
            article.setArticlePraise(0);
            article.setArticleStatus(1);
            articleService.insertSelective(article);
            jr = new JsonResult(Constants.STATUS_SUCCESS,"发布成功！");
        }catch (Exception e){
            jr = new JsonResult(Constants.STATUS_ERROR,"发布失败！");
        }
        return jr;
    }

    //修改文章
    @ResponseBody
    @RequestMapping(value = "/user/updatearticle",method = RequestMethod.GET)
    public JsonResult updatearticle(Article article){
        JsonResult jr;
        try{
            articleService.updateByPrimaryKeySelective(article);
            jr = new JsonResult(Constants.STATUS_SUCCESS,"修改成功！");
        }catch (Exception e) {
            jr = new JsonResult(Constants.STATUS_FAIL, "修改异常！");
        }
        return jr;
    }

    //添加评论
    @ResponseBody
    @RequestMapping(value = "/user/addcomments",method = RequestMethod.GET)
    public JsonResult addcomments(Comments comments){
        JsonResult jr;
        try{
            commentsService.insertSelective(comments);
            jr = new JsonResult(Constants.STATUS_SUCCESS,"发表成功！");
        }catch (Exception e){
            jr = new JsonResult(Constants.STATUS_FAIL,"反馈异常！");
        }
        return jr;
    }

    //删除评论
    @ResponseBody
    @RequestMapping(value = "/user/deletecomm",method = RequestMethod.GET)
    public JsonResult deletecomm(Comments comments){
        JsonResult jr;
        try{
            commentsService.deletecomments(comments);
            jr = new JsonResult(Constants.STATUS_SUCCESS,"删除成功！");
        }catch (Exception e){
            jr = new JsonResult(Constants.STATUS_FAIL,"删除成功！");
        }
        return jr;
    }

    //根据用户ID查询所有文件
    @ResponseBody
    @RequestMapping(value = "/user/findfilebyuid",method = RequestMethod.GET)
    public JsonResult findbyuid(Ufile ufile){
        JsonResult jr;
        try{
            List<Ufile> list = ufileService.selectByUserId(ufile);
            jr = new JsonResult(Constants.STATUS_SUCCESS,"查询成功！",list);
        }catch (Exception e){
            jr = new JsonResult(Constants.STATUS_FAIL,"查询异常！");
        }
        return jr;
    }

    //根据文件标题查询所有文件
    @ResponseBody
    @RequestMapping(value = "/user/findallfile",method = RequestMethod.GET)
    public JsonResult findallfile(Ufile ufile){
        JsonResult jr;
        try{
            List<Ufile> list = ufileService.selectByTitle(ufile);
            jr = new JsonResult(Constants.STATUS_SUCCESS,"查询成功！",list);
        }catch (Exception e){
            jr = new JsonResult(Constants.STATUS_FAIL,"查询异常！"+e.getMessage());
        }
        return jr;
    }


    //收藏文章   collectionStatus    0 文章  1  文件
    @ResponseBody
    @RequestMapping(value = "/user/addcollect",method = RequestMethod.GET)
    public JsonResult addcollect(Collection collection){
        JsonResult jr;
        try{
            List<Collection> list = collectionService.selectByArticle(collection);
            if(list.size()>0){
                jr = new JsonResult(Constants.STATUS_ERROR,"已收藏！");
            }else{
                collectionService.insert(collection);
                jr = new JsonResult(Constants.STATUS_SUCCESS,"收藏成功！");
            }
        }catch (Exception e){
            jr = new JsonResult(Constants.STATUS_FAIL,"收藏异常！"+e.getMessage());
        }
        return jr;
    }

    //删除收藏
    @ResponseBody
    @RequestMapping(value = "/user/deletecollect",method = RequestMethod.GET)
    public JsonResult deletecllect(Collection collection){
        JsonResult jr;
        try{
            collectionService.deleteByPrimaryKey(collection);
            jr = new JsonResult(Constants.STATUS_SUCCESS,"删除成功！");
        }catch (Exception e){
            jr = new JsonResult(Constants.STATUS_FAIL,"删除异常！");
        }
        return jr;
    }

    //显示用户所有收藏
    @ResponseBody
    @RequestMapping(value = "/user/selectcollect",method = RequestMethod.GET)
    public JsonResult selectcollect(Collection collection){
        JsonResult jr;
        try{
            List<Collection> list = collectionService.selectByPrimaryKey(collection);
            if(list.size()>0){
                jr = new JsonResult(Constants.STATUS_SUCCESS,"查询成功！",list);
            }else{
                jr = new JsonResult(Constants.STATUS_NOT_FOUND,"暂无数据！");
            }
        }catch (Exception e){
            jr = new JsonResult(Constants.STATUS_FAIL,"查询异常！");
        }
        return jr;
    }

    //根据文章ID显示所有收藏
    @ResponseBody
    @RequestMapping(value = "/user/selectcollection",method = RequestMethod.GET)
    public JsonResult selectcollection(Collection collection){
        JsonResult jr;
        try{
            List<Collection> list = collectionService.selectByArticle(collection);
            if(list.size()>0){
                jr = new JsonResult(Constants.STATUS_SUCCESS,"查询成功！",list);
            }else{
                jr = new JsonResult(Constants.STATUS_NOT_FOUND,"暂无数据！");
            }
        }catch (Exception e){
            jr = new JsonResult(Constants.STATUS_FAIL,"查询异常！"+e.getMessage());
        }
        return jr;
    }
    //根據ID查文章
    @ResponseBody
    @RequestMapping(value = "/artice/select",method = RequestMethod.GET)
    public JsonResult selectartice(Article article){
        JsonResult jr;
        try{
            Article art  =articleService.selectById(article);
            jr = new JsonResult(Constants.STATUS_SUCCESS,"查询成功",art);
        }catch (Exception e){
            jr = new JsonResult(Constants.STATUS_FAIL,"查询异常");
        }
        return jr;
    }

    //查积分
    @ResponseBody
    @RequestMapping(value = "/user/score",method = RequestMethod.GET)
    public JsonResult selectScore(User user){
        JsonResult jr;
        try{
            User u = userService.findById(user.getUserId());
            jr = new JsonResult(Constants.STATUS_SUCCESS,"查询成功！",u);
        }catch (Exception e){
            jr = new JsonResult(Constants.STATUS_FAIL,"查询失败！");
        }
        return jr;
    }
    //查所有
    @ResponseBody
    @RequestMapping(value = "/user/all",method = RequestMethod.GET)
    public JsonResult selectAll(User user){
        JsonResult jr;
        try{
            List<User> u = userService.selectAll(user);
            if(u.size()>0){
                jr = new JsonResult(Constants.STATUS_SUCCESS,"查询成功！",u);
            }else{
                jr = new JsonResult(Constants.STATUS_NOT_FOUND,"暂无数据！");
            }
        }catch (Exception e){
            jr = new JsonResult(Constants.STATUS_FAIL,"查询失败！");
        }
        return jr;
    }

    //模糊查
    @ResponseBody
    @RequestMapping(value = "/user/id",method = RequestMethod.GET)
    public JsonResult selectAll(String string){
        JsonResult jr;
        try{
            List<User> u = userService.selectId(string);
            if(u.size()>0){
                jr = new JsonResult(Constants.STATUS_SUCCESS,"查询成功！",u);
            }else{
                jr = new JsonResult(Constants.STATUS_NOT_FOUND,"暂无数据！");
            }
        }catch (Exception e){
            jr = new JsonResult(Constants.STATUS_FAIL,"查询失败！");
        }
        return jr;
    }

    //查认证
    @ResponseBody
    @RequestMapping(value = "/select/confirme",method = RequestMethod.GET)
    public JsonResult selectAll(Confirme confirme){
        JsonResult jr;
        try{
            List<Confirme> u = confirmeService.selectAll(confirme);
            if(u.size()>0){
                jr = new JsonResult(Constants.STATUS_SUCCESS,"查询成功！",u);
            }else{
                jr = new JsonResult(Constants.STATUS_NOT_FOUND,"暂无数据！");
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
            jr = new JsonResult(Constants.STATUS_FAIL,"查询异常！");
        }
        return jr;
    }
    //查认证
    @ResponseBody
    @RequestMapping(value = "/select/confirmeById",method = RequestMethod.GET)
    public JsonResult selectById(Confirme confirme){
        JsonResult jr;
        try{
            Confirme u = confirmeService.selectByPrimaryKey(confirme);
            if(u!=null){
                jr = new JsonResult(Constants.STATUS_SUCCESS,"查询成功！",u);
            }else{
                jr = new JsonResult(Constants.STATUS_NOT_FOUND,"暂无数据！");
            }

        }catch (Exception e){
            jr = new JsonResult(Constants.STATUS_FAIL,"查询异常！");
        }
        return jr;
    }
}
