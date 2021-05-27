package com.it.dormitory.mapper;

import com.it.dormitory.entity.Menu;

import java.util.List;
import java.util.Map;


public interface MenuMapper {

	public int create(Menu menu);

	public int delete(Integer id);

	public int update(Menu menu);

	public int updateSelective(Menu menu);

	public List<Menu> query(Integer userId);

	public List<Menu> queryAll(Menu menu);

	public Menu detail(Integer id);

	public int count(Menu menu);

	public List<Menu> queryByType();

	public List<Integer> queryCheckMenuId(Integer userId);

	public List<Menu> list();



}