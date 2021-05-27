package com.it.dormitory.entity;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import com.it.dormitory.utils.Entity;
import java.util.Date;



public class SelectionJoiner extends Entity{

	/**
	 * 
	 */
	private Integer id;
	/**
	 * 
	 */
	private Integer selectionId;
	/**
	 * 
	 */
	private Integer clazzId;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSelectionId() {
		return selectionId;
	}
	public void setSelectionId(Integer selectionId) {
		this.selectionId = selectionId;
	}
	public Integer getClazzId() {
		return clazzId;
	}
	public void setClazzId(Integer clazzId) {
		this.clazzId = clazzId;
	}
}