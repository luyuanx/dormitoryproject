package com.it.dormitory.mapper;

import com.it.dormitory.entity.Student;

import java.util.List;
import java.util.Map;


public interface StudentMapper {

	public int create(Student student);

	public int delete(Integer id);

	public int update(Student student);

	public int updateSelective(Student student);

	public List<Student> query(Student student);

	public Student detail(Integer id);

	public int count(Student student);

}