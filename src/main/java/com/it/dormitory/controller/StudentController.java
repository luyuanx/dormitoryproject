package com.it.dormitory.controller;

import com.github.pagehelper.PageInfo;
import com.it.dormitory.entity.Student;
import com.it.dormitory.service.StudentService;
import com.it.dormitory.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("create")
    public Result create(@RequestBody Student student){
        int flag = studentService.create(student);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @GetMapping("delete")
    public Result delete(String ids){
        int flag = studentService.delete(ids);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @PostMapping("update")
    public Result update(@RequestBody Student student){
        int flag = studentService.update(student);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @GetMapping("detail")
    public Student detail(Integer id){
        return studentService.detail(id);
    }

    @PostMapping("query")
    public Map<String,Object> query(@RequestBody  Student student){
        PageInfo<Student> pageInfo = studentService.query(student);
        return Result.ok(pageInfo);
    }

}
