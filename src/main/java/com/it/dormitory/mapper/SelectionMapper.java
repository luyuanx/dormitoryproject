package com.it.dormitory.mapper;

import com.it.dormitory.entity.Selection;

import java.util.List;
import java.util.Map;


public interface SelectionMapper {

	public int create(Selection selection);

	public int delete(Integer id);

	public int update(Selection selection);

	public int updateSelective(Selection selection);

	public List<Selection> query(Selection selection);

	public Selection detail(Integer id);

	public int count(Selection selection);

}