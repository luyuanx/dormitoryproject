package com.it.dormitory.mapper;

import com.it.dormitory.entity.Repair;

import java.util.List;
import java.util.Map;


public interface RepairMapper {

	public int create(Repair repair);

	public int delete(Integer id);

	public int update(Repair repair);

	public int updateSelective(Repair repair);

	public List<Repair> query(Repair repair);

	public Repair detail(Integer id);

	public int count(Repair repair);

}