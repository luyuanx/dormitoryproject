package com.it.dormitory.entity;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import com.it.dormitory.utils.Entity;
import java.util.Date;



public class Storey extends Entity{

	/**
	 * 
	 */
	private Integer id;
	/**
	 * 
	 */
	@Length(max = 0)
	private String name;
	/**
	 * 
	 */
	private Integer buildingId;
	/**
	 * 
	 */
	@Length(max = 0)
	private String remark;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}