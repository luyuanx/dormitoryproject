package com.it.dormitory.mapper;

import com.it.dormitory.entity.Dormitory;

import java.util.List;
import java.util.Map;


public interface DormitoryMapper {

	public int create(Dormitory dormitory);

	public int delete(Integer id);

	public int update(Dormitory dormitory);

	public int updateSelective(Dormitory dormitory);

	public List<Dormitory> query(Dormitory dormitory);

	public Dormitory detail(Integer id);

	public int count(Dormitory dormitory);

}