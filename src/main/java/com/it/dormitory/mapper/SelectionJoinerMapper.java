package com.it.dormitory.mapper;

import com.it.dormitory.entity.SelectionJoiner;

import java.util.List;
import java.util.Map;


public interface SelectionJoinerMapper {

	public int create(SelectionJoiner selectionJoiner);

	public int delete(Integer id);

	public int update(SelectionJoiner selectionJoiner);

	public int updateSelective(SelectionJoiner selectionJoiner);

	public List<SelectionJoiner> query(SelectionJoiner selectionJoiner);

	public SelectionJoiner detail(Integer id);

	public int count(SelectionJoiner selectionJoiner);

}