package com.bootdo.biz.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * InnoDB free: 11264 kB; (`plan_id`) REFER `bootdo/biz_plan_price`(`id`)
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-01-01 22:46:29
 */
public class CarDatetimeSeatDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Long id;
	//日期
	private String bizDate;
	//时间
	private String bizTime;
	//车型
	private Long carId;
	//路线
	private Long planId;
	//座位名称
	private String name;
	//排数
	private BigDecimal rowIndex;
	//第几个座位
	private BigDecimal colIndex;
	//座位类型（1正常2过道3爱心）
	private Integer seatType;

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
	/**
	 * 设置：时间
	 */
	public void setBizTime(String bizTime) {
		this.bizTime = bizTime;
	}
	/**
	 * 获取：时间
	 */
	public String getBizTime() {
		return bizTime;
	}
	/**
	 * 设置：车型
	 */
	public void setCarId(Long carId) {
		this.carId = carId;
	}
	/**
	 * 获取：车型
	 */
	public Long getCarId() {
		return carId;
	}
	/**
	 * 设置：路线
	 */
	public void setPlanId(Long planId) {
		this.planId = planId;
	}
	/**
	 * 获取：路线
	 */
	public Long getPlanId() {
		return planId;
	}
	/**
	 * 设置：座位名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：座位名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：排数
	 */
	public void setRowIndex(BigDecimal rowIndex) {
		this.rowIndex = rowIndex;
	}
	/**
	 * 获取：排数
	 */
	public BigDecimal getRowIndex() {
		return rowIndex;
	}
	/**
	 * 设置：第几个座位
	 */
	public void setColIndex(BigDecimal colIndex) {
		this.colIndex = colIndex;
	}
	/**
	 * 获取：第几个座位
	 */
	public BigDecimal getColIndex() {
		return colIndex;
	}
	/**
	 * 设置：座位类型（1正常2过道3爱心）
	 */
	public void setSeatType(Integer seatType) {
		this.seatType = seatType;
	}
	/**
	 * 获取：座位类型（1正常2过道3爱心）
	 */
	public Integer getSeatType() {
		return seatType;
	}
}
