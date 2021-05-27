package com.it.dormitory.controller;

import com.it.dormitory.entity.User;
import com.it.dormitory.framework.jwt.JWTUtil;
import com.it.dormitory.service.UserService;
import com.it.dormitory.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;


    @ResponseBody
    @RequestMapping("/login")
    public Result login(@RequestBody User user) {

        Map map = new HashMap();

        User login = userService.login(user.getUserName(), user.getPassword());
        if (login != null) {
            String token = JWTUtil.sign(login);
            map.put(JWTUtil.token, token);
            map.put("User",user);
            return Result.ok("登录成功",map);
        } else {
            return Result.fail("用户名或密码错误");
        }
    }

}
