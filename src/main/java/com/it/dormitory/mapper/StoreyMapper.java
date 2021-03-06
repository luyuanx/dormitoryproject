package com.it.dormitory.mapper;

import com.it.dormitory.entity.Storey;

import java.util.List;
import java.util.Map;


public interface StoreyMapper {

	public int create(Storey storey);

	public int delete(Integer id);

	public int update(Storey storey);

	public int updateSelective(Storey storey);

	public List<Storey> query(Storey storey);

	public Storey detail(Integer id);

	public int count(Storey storey);

}