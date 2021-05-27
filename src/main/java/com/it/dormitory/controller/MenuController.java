package com.it.dormitory.controller;

import com.github.pagehelper.PageInfo;
import com.it.dormitory.entity.Menu;
import com.it.dormitory.entity.User;
import com.it.dormitory.entity.UserMenu;
import com.it.dormitory.service.MenuService;
import com.it.dormitory.service.UserMenuService;
import com.it.dormitory.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private UserMenuService userMenuService;

    @PostMapping("create")
    public Result create(@RequestBody Menu menu){
        int flag = menuService.create(menu);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @GetMapping("delete")
    public Result delete(String ids){
        int flag = menuService.delete(ids);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @PostMapping("update")
    public Result update(@RequestBody Menu menu){
        int flag = menuService.update(menu);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @GetMapping("detail")
    public Menu detail(Integer id){
        return menuService.detail(id);
    }

    @GetMapping("query")
    public Result query(HttpServletRequest request){
        List<Menu> menus = new ArrayList<>();
        if(request.getAttribute("user") != null){
            User user = (User) request.getAttribute("user");
            menus = menuService.query(user.getId());
        }
//        else if(request.getAttribute("student") != null){
//            menus = menuService.queryByType();
//        }

        List<Menu> menuList1 = new ArrayList<>();
        //找出一级菜单
        for (Menu menu : menus) {
            if(menu.getParentId() == 0){
                menuList1.add(menu);
            }
        }

        //嵌套循环找出关联设置child属性
        for (Menu parent : menuList1) {
            List<Menu> child = new ArrayList<>();
            for (Menu entity : menus) {
                if(parent.getId() == entity.getParentId()){
                    child.add(entity);
                }
            }
            parent.setChild(child);
        }

        return Result.ok(menuList1);
    }



    @RequestMapping("tree")
    public Result tree(@RequestParam(required = false) Integer id,HttpServletRequest request){        //生成树形节点
        List<Integer> checkedMenuId = new ArrayList<>();

        //查询用户已选中的功能
        if (id!=null){
            User user = (User) request.getAttribute("user");
            //查询出来自己已经设置过得menuId
            checkedMenuId = menuService.queryCheckMenuId(user.getId());

        }

        List<Menu> list = menuService.list();
        List<Map<String,Object>> menus = new ArrayList<>();



        for (Menu menu : list) {
            if (menu.getParentId()==0){
                Map<String, Object> map = new HashMap<>();
                map.put("id", menu.getId());
                map.put("name", menu.getTitle());
                map.put("isParent", true);
                map.put("open",true);
                map.put("checked", checkedMenuId.contains(menu.getId()));
                List<Map<String,Object>> children =new ArrayList<>();
                for (Menu menu1 : list) {
                    if(menu1.getParentId()!=0 && menu.getId()==menu1.getParentId()){
                        Map<String, Object> map1 = new HashMap<>();
                        map1.put("id", menu1.getId());
                        map1.put("name", menu1.getTitle());
                        map1.put("isParent", false);
                        map1.put("open",true);
                        map1.put("checked",checkedMenuId.contains(menu1.getId()));
                        children.add(map1);

                    }

                }

                map.put("children", children);
                menus.add(map);

            }
        }

        return Result.ok(menus);
    }





}
