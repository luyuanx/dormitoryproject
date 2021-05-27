package com.it.dormitory.service;

import com.it.dormitory.mapper.MenuMapper;
import com.it.dormitory.entity.Menu;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    private MenuMapper menuMapper;

    public int create(Menu menu) {
        return menuMapper.create(menu);
    }

    public int delete(String ids) {
        String[] arr = ids.split(",");
        int row = 0;
        for (String s : arr) {
            if(!StringUtils.isEmpty(s)){
                menuMapper.delete(Integer.parseInt(s));
            row++;
            }
        }
        return row;
    }

    public int delete(Integer id) {
        return menuMapper.delete(id);
    }

    public int update(Menu menu) {
        return menuMapper.update(menu);
    }

    public int updateSelective(Menu menu) {
        return menuMapper.updateSelective(menu);
    }

    public List<Menu> query(Integer userId){
        return menuMapper.query(userId);
    }

    public PageInfo<Menu> queryAll(Menu menu) {
        if(menu != null && menu.getPage() != null){
            PageHelper.startPage(menu.getPage(),menu.getLimit());
        }
        return new PageInfo<Menu>(menuMapper.queryAll(menu));
    }

    public Menu detail(Integer id) {
        return menuMapper.detail(id);
    }

    public int count(Menu menu) {
        return menuMapper.count(menu);
    }

    public List<Integer> queryCheckMenuId(Integer userId){
        return menuMapper.queryCheckMenuId(userId);
    }

    public List<Menu> queryByType(){
        return menuMapper.queryByType();
    }

    public List<Menu> list(){
        return menuMapper.list();
    }
}
