package com.it.dormitory.controller;

import com.github.pagehelper.PageInfo;
import com.it.dormitory.entity.SelectionDormitory;
import com.it.dormitory.service.SelectionDormitoryService;
import com.it.dormitory.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/selectionDormitory")
public class SelectionDormitoryController {

    @Autowired
    private SelectionDormitoryService selectionDormitoryService;

    @PostMapping("create")
    public Result create(@RequestBody SelectionDormitory selectionDormitory){
        int flag = selectionDormitoryService.create(selectionDormitory);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @GetMapping("delete")
    public Result delete(String ids){
        int flag = selectionDormitoryService.delete(ids);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @PostMapping("update")
    public Result update(@RequestBody SelectionDormitory selectionDormitory){
        int flag = selectionDormitoryService.update(selectionDormitory);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @GetMapping("detail")
    public SelectionDormitory detail(Integer id){
        return selectionDormitoryService.detail(id);
    }

    @PostMapping("query")
    public Map<String,Object> query(@RequestBody  SelectionDormitory selectionDormitory){
        PageInfo<SelectionDormitory> pageInfo = selectionDormitoryService.query(selectionDormitory);
        return Result.ok(pageInfo);
    }

}
