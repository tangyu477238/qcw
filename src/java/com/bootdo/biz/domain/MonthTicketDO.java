package com.bootdo.biz.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 用户月票购买记录; InnoDB free: 11264 kB
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-01-01 16:03:30
 */
public class MonthTicketDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Long id;
	//套票名称
	private String ptypeName;
	//票价
	private BigDecimal price;
	//总次数
	private BigDecimal totalNum;
	//0无效1有效
	private Integer state;

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
	 * 设置：套票名称
	 */
	public void setPtypeName(String ptypeName) {
		this.ptypeName = ptypeName;
	}
	/**
	 * 获取：套票名称
	 */
	public String getPtypeName() {
		return ptypeName;
	}
	/**
	 * 设置：票价
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * 获取：票价
	 */
	public BigDecimal getPrice() {
		return price;
	}
	/**
	 * 设置：总次数
	 */
	public void setTotalNum(BigDecimal totalNum) {
		this.totalNum = totalNum;
	}
	/**
	 * 获取：总次数
	 */
	public BigDecimal getTotalNum() {
		return totalNum;
	}
	/**
	 * 设置：0无效1有效
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	/**
	 * 获取：0无效1有效
	 */
	public Integer getState() {
		return state;
	}
}
