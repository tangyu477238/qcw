package com.bootdo.gc.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 序列号
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-06-14 11:00:32
 */
public class SequenceDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Long id;
	//序号
	private Integer num;
	//序列类型()
	private String stype;
	//日期
	private String bizDate;

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
	 * 设置：序号
	 */
	public void setNum(Integer num) {
		this.num = num;
	}
	/**
	 * 获取：序号
	 */
	public Integer getNum() {
		return num;
	}
	/**
	 * 设置：序列类型()
	 */
	public void setStype(String stype) {
		this.stype = stype;
	}
	/**
	 * 获取：序列类型()
	 */
	public String getStype() {
		return stype;
	}
	/**
	 * 设置：日期
	 */
	public void setBizDate(String bizDate) {
		this.bizDate = bizDate;
	}
	/**
	 * 获取：日期
	 */
	public String getBizDate() {
		return bizDate;
	}
}
