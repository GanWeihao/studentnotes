package com.example.studentnotes.controller;

import com.example.studentnotes.Bo.RecordRespBo;
import com.example.studentnotes.model.Record;
import com.example.studentnotes.service.RecordService;
import com.example.studentnotes.util.Constants;
import com.example.studentnotes.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SelectRecordController {
    @Autowired
    RecordService recordService;
    //
    @ResponseBody
    @RequestMapping(value = "/record/select",method = RequestMethod.GET)
    public JsonResult changeScore(Record record){
        JsonResult jr;
        try{
            List<Record> list= recordService.select(record);
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
    @RequestMapping(value = "/record/select1",method = RequestMethod.GET)
    public JsonResult changeScore1(Record record){
        JsonResult jr;
        try{
            RecordRespBo recordRespBo = new RecordRespBo();
            record.setRecordStatus(1);
            List<Record> list= recordService.selectUserId(record);
            record.setRecordStatus(2);
            List<Record> list1= recordService.selectUserId(record);
            recordRespBo.setUpload(list.size());
            recordRespBo.setDownload(list1.size());
            jr = new JsonResult(Constants.STATUS_SUCCESS,"查询成功！",recordRespBo);

        }catch(Exception e){
            jr = new JsonResult(Constants.STATUS_FAIL,"查询异常！");
        }
        return jr;
    }
}
