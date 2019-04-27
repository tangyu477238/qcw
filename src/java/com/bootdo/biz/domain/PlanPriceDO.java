package com.bootdo.biz.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * InnoDB free: 11264 kB; (`car_id`) REFER `bootdo/biz_car`(`id`); (`route_id`) REF
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-01-01 16:03:51
 */
public class PlanPriceDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Long id;
	//路线id
	private Long routeId;
	//业主票价
	private BigDecimal price;
	//非业主票价
	private BigDecimal fprice;
	//车型
	private Long carId;
	//工作日
	private String sday;
	//限制非业主购买班次
	private String fday;
	//节假日班次
	private String wday;

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
	 * 设置：路线id
	 */
	public void setRouteId(Long routeId) {
		this.routeId = routeId;
	}
	/**
	 * 获取：路线id
	 */
	public Long getRouteId() {
		return routeId;
	}
	/**
	 * 设置：业主票价
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * 获取：业主票价
	 */
	public BigDecimal getPrice() {
		return price;
	}
	/**
	 * 设置：非业主票价
	 */
	public void setFprice(BigDecimal fprice) {
		this.fprice = fprice;
	}
	/**
	 * 获取：非业主票价
	 */
	public BigDecimal getFprice() {
		return fprice;
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
	 * 设置：工作日
	 */
	public void setSday(String sday) {
		this.sday = sday;
	}
	/**
	 * 获取：工作日
	 */
	public String getSday() {
		return sday;
	}
	/**
	 * 设置：限制非业主购买班次
	 */
	public void setFday(String fday) {
		this.fday = fday;
	}
	/**
	 * 获取：限制非业主购买班次
	 */
	public String getFday() {
		return fday;
	}
	/**
	 * 设置：节假日班次
	 */
	public void setWday(String wday) {
		this.wday = wday;
	}
	/**
	 * 获取：节假日班次
	 */
	public String getWday() {
		return wday;
	}
}
