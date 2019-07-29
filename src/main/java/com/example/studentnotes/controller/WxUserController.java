package com.example.studentnotes.controller;


import com.example.studentnotes.model.User;
import com.example.studentnotes.service.UserService;
import com.example.studentnotes.util.AesCbcUtil;
import com.example.studentnotes.util.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.jfunc.json.impl.JSONObject;

import java.util.HashMap;
import java.util.Map;

@Controller
public class WxUserController {
    @Autowired
    UserService userService;

    @SuppressWarnings({"unchecked", "rawtypes"})
    @RequestMapping(value = "/decodeUserInfo", method = RequestMethod.POST)
    @ResponseBody
    public Map decodeUserInfo(@RequestParam("encryptedData") String encryptedData, @RequestParam("iv") String iv, @RequestParam("code") String code) {
        Map map = new HashMap();
        // 登录凭证不能为空
        if (code == null || code.length() == 0) {
            map.put("status", 0);
            map.put("msg", "code 不能为空");
            return map;
        }

        // 小程序唯一标识 (在微信小程序管理后台获取)
        String wxspAppid = "wxb9715e9d3d067793";
        // 小程序的 app secret (在微信小程序管理后台获取)
        String wxspSecret = "895248bb12618b52acb960aad913bb2e";
        // 授权（必填）
        String grant_type = "authorization_code";

        //////////////// 1、向微信服务器 使用登录凭证 code 获取 session_key 和 openid
        //////////////// ////////////////
        // 请求参数
        String params = "appid=" + wxspAppid + "&secret=" + wxspSecret + "&js_code=" + code + "&grant_type="
                + grant_type;
        // 发送请求
        String sr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);
        // 解析相应内容（转换成json对象）
        JSONObject json = new JSONObject(sr);

        // 获取会话密钥（session_key）

        String session_key = json.get("session_key").toString();
        // 用户的唯一标识（openid）
        String openid = (String) json.get("openid");
        //////////////// 2、对encryptedData加密数据进行AES解密 / / / / / / / / / / / / / / / /
        try {
            String result = AesCbcUtil.decrypt(encryptedData, session_key, iv, "UTF-8");
            if (null != result && result.length() > 0) {
                map.put("status", 1);
                map.put("msg", "解密成功");

                JSONObject userInfoJSON = new JSONObject(result);

                String openId=userInfoJSON.get("openId").toString();

                User wxUser = userService.findById(openId);
                if (null!=wxUser){
                    Map userInfo = new HashMap();
                    userInfo.put("userName", wxUser.getUserName()==null? "" : wxUser.getUserName());
                    userInfo.put("userStatus", wxUser.getUserStatus()==null? "" : wxUser.getUserStatus());
                    userInfo.put("userStuStatus",wxUser.getUserStuStatus()==null? "" : wxUser.getUserStuStatus());
                    userInfo.put("userTime",wxUser.getUserTime()==null? "" : wxUser.getUserTime());
                    userInfo.put("userStuId", wxUser.getUserStuId()==null? "" : wxUser.getUserStuId());
                    userInfo.put("userPhone",wxUser.getUserPhone()==null? "" : wxUser.getUserPhone());
                    userInfo.put("userRank",wxUser.getUserRank()==null? "" : wxUser.getUserRank());
                    userInfo.put("userIntegral",wxUser.getUserIntegral()==null? "" : wxUser.getUserIntegral());
                    userInfo.put("userId", userInfoJSON.get("openId")==null? "" : userInfoJSON.get("openId"));
                    userInfo.put("userUname", userInfoJSON.get("nickName")==null? "" : userInfoJSON.get("nickName"));
                    userInfo.put("userHeadimg", userInfoJSON.get("avatarUrl")==null? "" : userInfoJSON.get("avatarUrl"));
                    // 解密unionId & openId;
                    //userInfo.put("unionId", userInfoJSON.get("unionId"));
                    map.put("userInfo", userInfo);
                }else {
                    User user = new User();
                    user.setUserId(openId);
                    user.setUserUname(userInfoJSON.get("nickName").toString());
                    user.setUserHeadimg(userInfoJSON.get("avatarUrl").toString());
                    userService.userRegister(user);
                    Map userInfo = new HashMap();
                    User wxUser1 = userService.findById(openId);
                    userInfo.put("userName", wxUser1.getUserName()==null? "" : wxUser1.getUserName());
                    userInfo.put("userStatus", wxUser1.getUserStatus()==null? "" : wxUser1.getUserStatus());
                    userInfo.put("userStuStatus",wxUser1.getUserStuStatus()==null? "" : wxUser1.getUserStuStatus());
                    userInfo.put("userTime",wxUser1.getUserTime()==null? "" : wxUser1.getUserTime());
                    userInfo.put("userStuId", wxUser1.getUserStuId()==null? "" : wxUser1.getUserStuId());
                    userInfo.put("userPhone",wxUser1.getUserPhone()==null? "" : wxUser1.getUserPhone());
                    userInfo.put("userRank",wxUser1.getUserRank()==null? "" : wxUser1.getUserRank());
                    userInfo.put("userIntegral",wxUser1.getUserIntegral()==null? "" : wxUser1.getUserIntegral());
                    userInfo.put("userId", userInfoJSON.get("openId")==null? "" : userInfoJSON.get("openId"));
                    userInfo.put("userUname", userInfoJSON.get("nickName")==null? "" : userInfoJSON.get("nickName"));
                    userInfo.put("userHeadimg", userInfoJSON.get("avatarUrl")==null? "" : userInfoJSON.get("avatarUrl"));
                    // 解密unionId & openId;
                    //userInfo.put("unionId", userInfoJSON.get("unionId"));
                    map.put("userInfo", userInfo);

                }
            } else {
                map.put("status", 0);
                map.put("msg", "解密失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }


}
