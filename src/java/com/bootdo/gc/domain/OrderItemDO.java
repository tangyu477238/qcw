package com.bootdo.gc.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-12-14 21:31:20
 */
public class OrderItemDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Long id;
	//地区
	private Long deptId;
	//上级id
	private Long pid;
	//业务找车人
	private String createusername;
	//业务找车人Id
	private Long createuser;
	//车号
	private String carnum;
	//装载吨数
	private BigDecimal tonnage;
	//运费
	private String trancost;
	//车主
	private String carname;
	//车主电话
	private String cartel;
	//司机
	private String driver;
	//司机身份证
	private String idcard;
	//司机电话
	private String tel;
	//常跑线路
	private String route;
	//备注
	private String remark;
	//状态
	private Integer state;

	private String bizdate;
	private String station;
	private String forwunit;


	public String getBizdate() {
		return bizdate;
	}

	public void setBizdate(String bizdate) {
		this.bizdate = bizdate;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public String getForwunit() {
		return forwunit;
	}

	public void setForwunit(String forwunit) {
		this.forwunit = forwunit;
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
	 * 设置：上级id
	 */
	public void setPid(Long pid) {
		this.pid = pid;
	}
	/**
	 * 获取：上级id
	 */
	public Long getPid() {
		return pid;
	}
	/**
	 * 设置：业务找车人
	 */
	public void setCreateusername(String createusername) {
		this.createusername = createusername;
	}
	/**
	 * 获取：业务找车人
	 */
	public String getCreateusername() {
		return createusername;
	}
	/**
	 * 设置：业务找车人Id
	 */
	public void setCreateuser(Long createuser) {
		this.createuser = createuser;
	}
	/**
	 * 获取：业务找车人Id
	 */
	public Long getCreateuser() {
		return createuser;
	}
	/**
	 * 设置：车号
	 */
	public void setCarnum(String carnum) {
		this.carnum = carnum;
	}
	/**
	 * 获取：车号
	 */
	public String getCarnum() {
		return carnum;
	}
	/**
	 * 设置：装载吨数
	 */
	public void setTonnage(BigDecimal tonnage) {
		this.tonnage = tonnage;
	}
	/**
	 * 获取：装载吨数
	 */
	public BigDecimal getTonnage() {
		return tonnage;
	}
	/**
	 * 设置：运费
	 */
	public void setTrancost(String trancost) {
		this.trancost = trancost;
	}
	/**
	 * 获取：运费
	 */
	public String getTrancost() {
		return trancost;
	}
	/**
	 * 设置：车主
	 */
	public void setCarname(String carname) {
		this.carname = carname;
	}
	/**
	 * 获取：车主
	 */
	public String getCarname() {
		return carname;
	}
	/**
	 * 设置：车主电话
	 */
	public void setCartel(String cartel) {
		this.cartel = cartel;
	}
	/**
	 * 获取：车主电话
	 */
	public String getCartel() {
		return cartel;
	}
	/**
	 * 设置：司机
	 */
	public void setDriver(String driver) {
		this.driver = driver;
	}
	/**
	 * 获取：司机
	 */
	public String getDriver() {
		return driver;
	}
	/**
	 * 设置：司机身份证
	 */
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	/**
	 * 获取：司机身份证
	 */
	public String getIdcard() {
		return idcard;
	}
	/**
	 * 设置：司机电话
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**
	 * 获取：司机电话
	 */
	public String getTel() {
		return tel;
	}
	/**
	 * 设置：常跑线路
	 */
	public void setRoute(String route) {
		this.route = route;
	}
	/**
	 * 获取：常跑线路
	 */
	public String getRoute() {
		return route;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
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
