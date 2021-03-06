package com.it.dormitory.entity;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import com.it.dormitory.utils.Entity;
import java.util.Date;



public class Building extends Entity{

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
	 * 4/6/8人间
	 */
	private Integer type;
	/**
	 * 
	 */
	private Integer storeyNum;
	/**
	 * 
	 */
	private Integer sex;
	/**
	 * 
	 */
	@Length(max = 0)
	private String remark;
	/**
	 * 
	 */
	private Integer userId;

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

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
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getStoreyNum() {
		return storeyNum;
	}
	public void setStoreyNum(Integer storeyNum) {
		this.storeyNum = storeyNum;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}