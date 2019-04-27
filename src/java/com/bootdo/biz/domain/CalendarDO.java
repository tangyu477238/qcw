package com.bootdo.biz.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * InnoDB free: 11264 kB
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2018-12-18 22:09:03
 */
public class CalendarDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Long id;
	//期日
	private String bizDate;
	//是否节假日
	private Integer holiday;
	//年
	private Integer year;
	//季度
	private Integer quarter;
	//月
	private Integer month;
	//周
	private Integer week;
	//日
	private Integer day;

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
	 * 设置：期日
	 */
	public void setBizDate(String bizDate) {
		this.bizDate = bizDate;
	}
	/**
	 * 获取：期日
	 */
	public String getBizDate() {
		return bizDate;
	}
	/**
	 * 设置：是否节假日
	 */
	public void setHoliday(Integer holiday) {
		this.holiday = holiday;
	}
	/**
	 * 获取：是否节假日
	 */
	public Integer getHoliday() {
		return holiday;
	}
	/**
	 * 设置：年
	 */
	public void setYear(Integer year) {
		this.year = year;
	}
	/**
	 * 获取：年
	 */
	public Integer getYear() {
		return year;
	}
	/**
	 * 设置：季度
	 */
	public void setQuarter(Integer quarter) {
		this.quarter = quarter;
	}
	/**
	 * 获取：季度
	 */
	public Integer getQuarter() {
		return quarter;
	}
	/**
	 * 设置：月
	 */
	public void setMonth(Integer month) {
		this.month = month;
	}
	/**
	 * 获取：月
	 */
	public Integer getMonth() {
		return month;
	}
	/**
	 * 设置：周
	 */
	public void setWeek(Integer week) {
		this.week = week;
	}
	/**
	 * 获取：周
	 */
	public Integer getWeek() {
		return week;
	}
	/**
	 * 设置：日
	 */
	public void setDay(Integer day) {
		this.day = day;
	}
	/**
	 * 获取：日
	 */
	public Integer getDay() {
		return day;
	}
}
