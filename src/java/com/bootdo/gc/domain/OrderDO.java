package com.bootdo.gc.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-12-14 21:31:17
 */
public class OrderDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Long id;
	//地区
	private Long deptId;
	//业务接单员
	private String createusername;
	//业务接单员id
	private Long createuser;
	//日期
	private String bizdate;
	//发货单位
	private String forwunit;
	//钢号
	private String steelnum;
	//规格
	private String specs;
	//吨数
	private BigDecimal tonnage;

	private String jsprice;


	//剩余吨位
	private BigDecimal sytonnage;

//	private BigDecimal zztonnage;

	//卸车地址
	private String addr;
	//到站
	private String station;
	//装车地点
	private String fromstation;
	//订单人员
	private Long orderuser;
	//状态
	private Integer state;

	private String huidan;

	private Date biztime;



	public Date getBiztime() {
		return biztime;
	}

	public void setBiztime(Date biztime) {
		this.biztime = biztime;
	}

	public String getHuidan() {
		return huidan;
	}

	public void setHuidan(String huidan) {
		this.huidan = huidan;
	}

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
	 * 设置：地区
	 */
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	/**
	 * 获取：地区
	 */
	public Long getDeptId() {
		return deptId;
	}
	/**
	 * 设置：业务接单员
	 */
	public void setCreateusername(String createusername) {
		this.createusername = createusername;
	}
	/**
	 * 获取：业务接单员
	 */
	public String getCreateusername() {
		return createusername;
	}
	/**
	 * 设置：业务接单员id
	 */
	public void setCreateuser(Long createuser) {
		this.createuser = createuser;
	}
	/**
	 * 获取：业务接单员id
	 */
	public Long getCreateuser() {
		return createuser;
	}
	/**
	 * 设置：日期
	 */
	public void setBizdate(String bizdate) {
		this.bizdate = bizdate;
	}
	/**
	 * 获取：日期
	 */
	public String getBizdate() {
		return bizdate;
	}
	/**
	 * 设置：发货单位
	 */
	public void setForwunit(String forwunit) {
		this.forwunit = forwunit;
	}
	/**
	 * 获取：发货单位
	 */
	public String getForwunit() {
		return forwunit;
	}
	/**
	 * 设置：钢号
	 */
	public void setSteelnum(String steelnum) {
		this.steelnum = steelnum;
	}
	/**
	 * 获取：钢号
	 */
	public String getSteelnum() {
		return steelnum;
	}
	/**
	 * 设置：规格
	 */
	public void setSpecs(String specs) {
		this.specs = specs;
	}
	/**
	 * 获取：规格
	 */
	public String getSpecs() {
		return specs;
	}
	/**
	 * 设置：吨数
	 */
	public void setJsprice(String jsprice) {
		this.jsprice = jsprice;
	}
	/**
	 * 获取：吨数
	 */
	public String getJsprice() {
		return jsprice;
	}


	/**
	 * 设置：吨数
	 */
	public void setTonnage(BigDecimal tonnage) {
		this.tonnage = tonnage;
	}
	/**
	 * 获取：吨数
	 */
	public BigDecimal getTonnage() {
		return tonnage;
	}



	/**
	 * 设置：剩余吨位
	 */
	public void setSytonnage(BigDecimal sytonnage) {
		this.sytonnage = sytonnage;
	}
	/**
	 * 获取：剩余吨位
	 */
	public BigDecimal getSytonnage() {
		return sytonnage;
	}
	/**
	 * 设置：卸车地址
	 */
	public void setAddr(String addr) {
		this.addr = addr;
	}
	/**
	 * 获取：卸车地址
	 */
	public String getAddr() {
		return addr;
	}
	/**
	 * 设置：到站
	 */
	public void setStation(String station) {
		this.station = station;
	}
	/**
	 * 获取：到站
	 */
	public String getStation() {
		return station;
	}
	/**
	 * 设置：装车地点
	 */
	public void setFromstation(String fromstation) {
		this.fromstation = fromstation;
	}
	/**
	 * 获取：装车地点
	 */
	public String getFromstation() {
		return fromstation;
	}
	/**
	 * 设置：订单人员
	 */
	public void setOrderuser(Long orderuser) {
		this.orderuser = orderuser;
	}
	/**
	 * 获取：订单人员
	 */
	public Long getOrderuser() {
		return orderuser;
	}
	/**
	 * 设置：状态
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	/**
	 * 获取：状态
	 */
	public Integer getState() {
		return state;
	}
}
