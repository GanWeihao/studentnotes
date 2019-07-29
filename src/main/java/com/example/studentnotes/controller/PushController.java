package com.example.studentnotes.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PushController {
    @ResponseBody
    @RequestMapping(value = "/push",method = RequestMethod.GET)
    public String push(){
        String r = null;

        // 小程序唯一标识 (在微信小程序管理后台获取)
        String wxspAppid = "wxacc0ec0a52e5d6d2";
        // 小程序的 app secret (在微信小程序管理后台获取)
        String wxspSecret = "789cd66d0667f601bd08001b15573eae";

        /*WxMpInMemoryConfigStorage wxStorage = new WxMpInMemoryConfigStorage();
        wxStorage.setAppId("wxacc0ec0a52e5d6d2");//appid
        wxStorage.setSecret("789cd66d0667f601bd08001b15573eae");//appsecret
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxStorage);

        //2,推送消息
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                .toUser("o5kho6DgC7SDry8zCmXuvHJGvrgI")//要推送的用户openid
                .templateId("Ds51iUt7muIwKE2hBdWTV6LKIdxOrcpX-Yqkt4G5cU0")//模版id
                //.url("https://30paotui.com/")//点击模版消息要访问的网址
                .build();
        //3,如果是正式版发送模版消息，这里需要配置你的信息
        //        templateMessage.addData(new WxMpTemplateData("name", "value", "#FF00FF"));
        //                templateMessage.addData(new WxMpTemplateData(name2, value2, color2));

        //发起推送
        try {
            String msg = wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
            r = "推送成功：" + msg;
        } catch (Exception e) {
            r = "推送失败：" + e.getMessage();
            e.printStackTrace();
        }*/
        return r;
    }

}
