package com.it.dormitory.controller;

import com.github.pagehelper.PageInfo;
import com.it.dormitory.entity.UserMenu;
import com.it.dormitory.service.UserMenuService;
import com.it.dormitory.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/userMenu")
public class UserMenuController {

    @Autowired
    private UserMenuService userMenuService;

    @PostMapping("create")
    public Result create(@RequestBody UserMenu userMenu){
        int flag = userMenuService.create(userMenu);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @GetMapping("delete")
    public Result delete(String ids){
        int flag = userMenuService.delete(ids);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @PostMapping("update")
    public Result update(@RequestBody UserMenu userMenu){
        int flag = userMenuService.update(userMenu);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @GetMapping("detail")
    public List<UserMenu> detail(Integer id){
        return userMenuService.detail(id);
    }

    @PostMapping("query")
    public Map<String,Object> query(@RequestBody  UserMenu userMenu){
        PageInfo<UserMenu> pageInfo = userMenuService.query(userMenu);
        return Result.ok(pageInfo);
    }

}
