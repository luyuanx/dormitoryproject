package com.it.dormitory.mapper;

import com.it.dormitory.entity.Grade;

import java.util.List;
import java.util.Map;


public interface GradeMapper {

	public int create(Grade grade);

	public int delete(Integer id);

	public int update(Grade grade);

	public int updateSelective(Grade grade);

	public List<Grade> query(Grade grade);

	public Grade detail(Integer id);

	public int count(Grade grade);

}