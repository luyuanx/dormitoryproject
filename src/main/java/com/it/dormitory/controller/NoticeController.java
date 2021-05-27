package com.it.dormitory.controller;

import com.github.pagehelper.PageInfo;
import com.it.dormitory.entity.Notice;
import com.it.dormitory.service.NoticeService;
import com.it.dormitory.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @PostMapping("create")
    public Result create(@RequestBody Notice notice){
        int flag = noticeService.create(notice);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @GetMapping("delete")
    public Result delete(String ids){
        int flag = noticeService.delete(ids);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @PostMapping("update")
    public Result update(@RequestBody Notice notice){
        int flag = noticeService.update(notice);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @GetMapping("detail")
    public Notice detail(Integer id){
        return noticeService.detail(id);
    }

    @PostMapping("query")
    public Map<String,Object> query(@RequestBody  Notice notice){
        PageInfo<Notice> pageInfo = noticeService.query(notice);
        return Result.ok(pageInfo);
    }

}
