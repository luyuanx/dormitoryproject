package com.it.dormitory.mapper;

import com.it.dormitory.entity.DormitorySet;

import java.util.List;
import java.util.Map;


public interface DormitorySetMapper {

	public int create(DormitorySet dormitorySet);

	public int delete(Integer id);

	public int update(DormitorySet dormitorySet);

	public int updateSelective(DormitorySet dormitorySet);

	public List<DormitorySet> query(DormitorySet dormitorySet);

	public DormitorySet detail(Integer id);

	public int count(DormitorySet dormitorySet);

}