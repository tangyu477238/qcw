package com.bootdo.biz.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 汽车年份; InnoDB free: 10240 kB
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-04-03 23:03:17
 */
public class BaoyangDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//
	private String categorycode;
	//
	private String categoryname;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setCategorycode(String categorycode) {
		this.categorycode = categorycode;
	}
	/**
	 * 获取：
	 */
	public String getCategorycode() {
		return categorycode;
	}
	/**
	 * 设置：
	 */
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	/**
	 * 获取：
	 */
	public String getCategoryname() {
		return categoryname;
	}
}
