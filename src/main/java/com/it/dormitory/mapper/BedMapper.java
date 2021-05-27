package com.it.dormitory.mapper;

import com.it.dormitory.entity.Bed;

import java.util.List;
import java.util.Map;



public interface BedMapper {

	public int create(Bed bed);

	public int delete(Integer id);

	public int update(Bed bed);

	public int updateSelective(Bed bed);

	public List<Bed> query(Bed bed);

	public Bed detail(Integer id);

	public int count(Bed bed);

}