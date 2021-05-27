package com.it.dormitory.controller;

import com.github.pagehelper.PageInfo;
import com.it.dormitory.entity.Absence;
import com.it.dormitory.service.AbsenceService;
import com.it.dormitory.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/absence")
public class AbsenceController {

    @Autowired
    private AbsenceService absenceService;

    @PostMapping("create")
    public Result create(@RequestBody Absence absence){
        int flag = absenceService.create(absence);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @GetMapping("delete")
    public Result delete(String ids){
        int flag = absenceService.delete(ids);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @PostMapping("update")
    public Result update(@RequestBody Absence absence){
        int flag = absenceService.update(absence);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @GetMapping("detail")
    public Absence detail(Integer id){
        return absenceService.detail(id);
    }

    @PostMapping("query")
    public Map<String,Object> query(@RequestBody  Absence absence){
        PageInfo<Absence> pageInfo = absenceService.query(absence);
        return Result.ok(pageInfo);
    }

}
