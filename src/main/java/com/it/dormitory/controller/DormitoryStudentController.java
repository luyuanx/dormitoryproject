package com.it.dormitory.controller;

import com.github.pagehelper.PageInfo;
import com.it.dormitory.entity.DormitoryStudent;
import com.it.dormitory.service.DormitoryStudentService;
import com.it.dormitory.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dormitoryStudent")
public class DormitoryStudentController {

    @Autowired
    private DormitoryStudentService dormitoryStudentService;

    @PostMapping("create")
    public Result create(@RequestBody DormitoryStudent dormitoryStudent){
        int flag = dormitoryStudentService.create(dormitoryStudent);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @GetMapping("delete")
    public Result delete(String ids){
        int flag = dormitoryStudentService.delete(ids);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @PostMapping("update")
    public Result update(@RequestBody DormitoryStudent dormitoryStudent){
        int flag = dormitoryStudentService.update(dormitoryStudent);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @GetMapping("detail")
    public DormitoryStudent detail(Integer id){
        return dormitoryStudentService.detail(id);
    }

    @PostMapping("query")
    public Map<String,Object> query(@RequestBody  DormitoryStudent dormitoryStudent){
        PageInfo<DormitoryStudent> pageInfo = dormitoryStudentService.query(dormitoryStudent);
        return Result.ok(pageInfo);
    }

}
