package com.bootdo.biz.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * InnoDB free: 11264 kB
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2018-12-18 08:09:29
 */
public class SelldayDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Long id;
	//天数
	private Integer days;
	//开售时间
	private String time;

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
	 * 设置：天数
	 */
	public void setDays(Integer days) {
		this.days = days;
	}
	/**
	 * 获取：天数
	 */
	public Integer getDays() {
		return days;
	}
	/**
	 * 设置：开售时间
	 */
	public void setTime(String time) {
		this.time = time;
	}
	/**
	 * 获取：开售时间
	 */
	public String getTime() {
		return time;
	}
}
