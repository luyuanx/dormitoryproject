package com.it.dormitory.mapper;

import com.it.dormitory.entity.UserMenu;

import java.util.List;
import java.util.Map;


public interface UserMenuMapper {

	public int create(UserMenu userMenu);

	public int delete(Integer id);

	public int update(UserMenu userMenu);

	public int updateSelective(UserMenu userMenu);

	public List<UserMenu> query(UserMenu userMenu);

	public List<UserMenu> detail(Integer id);


	public int count(UserMenu userMenu);

}