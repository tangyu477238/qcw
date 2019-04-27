package com.bootdo.biz.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * InnoDB free: 11264 kB
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-01-01 16:03:47
 */
public class RouteDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Long id;
	//出发地
	private String fromStation;
	//目的地
	private String toStation;

	/**
	 * 设置：id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：出发地
	 */
	public void setFromStation(String fromStation) {
		this.fromStation = fromStation;
	}
	/**
	 * 获取：出发地
	 */
	public String getFromStation() {
		return fromStation;
	}
	/**
	 * 设置：目的地
	 */
	public void setToStation(String toStation) {
		this.toStation = toStation;
	}
	/**
	 * 获取：目的地
	 */
	public String getToStation() {
		return toStation;
	}
}
