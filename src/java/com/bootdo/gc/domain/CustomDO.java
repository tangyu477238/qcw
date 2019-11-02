package com.bootdo.gc.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 客户
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-10-10 16:17:23
 */
public class CustomDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//名称
	private String name;
	//税率
	private BigDecimal shuilv;

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
	 * 设置：名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：税率
	 */
	public void setShuilv(BigDecimal shuilv) {
		this.shuilv = shuilv;
	}
	/**
	 * 获取：税率
	 */
	public BigDecimal getShuilv() {
		return shuilv;
	}
}
