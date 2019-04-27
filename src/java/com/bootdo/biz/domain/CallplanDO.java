package com.bootdo.biz.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * InnoDB free: 11264 kB
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2018-12-17 21:41:29
 */
public class CallplanDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//出发地
	private String fromstation;
	//目的地
	private String tostation;

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
	 * 设置：出发地
	 */
	public void setFromstation(String fromstation) {
		this.fromstation = fromstation;
	}
	/**
	 * 获取：出发地
	 */
	public String getFromstation() {
		return fromstation;
	}
	/**
	 * 设置：目的地
	 */
	public void setTostation(String tostation) {
		this.tostation = tostation;
	}
	/**
	 * 获取：目的地
	 */
	public String getTostation() {
		return tostation;
	}
}
