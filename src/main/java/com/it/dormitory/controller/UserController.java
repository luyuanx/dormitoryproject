package com.it.dormitory.controller;

import com.github.pagehelper.PageInfo;
import com.it.dormitory.entity.User;
import com.it.dormitory.entity.UserMenu;
import com.it.dormitory.service.UserMenuService;
import com.it.dormitory.service.UserService;
import com.it.dormitory.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMenuService userMenuService;

    @PostMapping("create")
    public Result create(@RequestBody User user){
        int flag = userService.create(user);
        List<Integer> ids = user.getIds();
        int create=0;

        for (Integer id : ids) {
            UserMenu userMenu = new UserMenu();
            userMenu.setUserId(user.getId());
            userMenu.setMenuId(id);
            create=userMenuService.create(userMenu);
        }

        if(flag>0&&create>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @RequestMapping("delete")
    public Result delete(String ids){
        int flag = userService.delete(ids);

        int delete = userMenuService.delete(ids);

        if(flag>0 && delete>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @RequestMapping("update")
    public Result update(@RequestBody User user){


        int update = 0;
        int flag = userService.updateSelective(user);
        List<Integer> ids = user.getIds();



        userMenuService.delete(user.getId());

        for (Integer id : ids) {
            UserMenu userMenu = new UserMenu();
            userMenu.setUserId(user.getId());
            userMenu.setMenuId(id);
            update = userMenuService.create(userMenu);

        }

        if(flag>0&&update>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @GetMapping("detail")
    public User detail(Integer id){
        return userService.detail(id);
    }

    @PostMapping("query")
    public Map<String,Object> query(@RequestBody  User user){

        PageInfo<User> pageInfo = userService.query(user);
        return Result.ok(pageInfo);
    }

}
