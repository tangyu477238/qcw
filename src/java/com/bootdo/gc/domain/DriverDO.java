package com.bootdo.gc.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-12-15 12:44:32
 */
public class DriverDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Long id;
	//地区
	private Long deptId;
	//车牌号
	private String carnum;
	//车主
	private String carname;
	//车主电话
	private String cartel;
	//司机
	private String driver;
	//司机电话
	private String tel;
	//司机身份证
	private String idcard;
	//备注信息
	private String remark;
	//状态
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
	 * 设置：车牌号
	 */
	public void setCarnum(String carnum) {
		this.carnum = carnum;
	}
	/**
	 * 获取：车牌号
	 */
	public String getCarnum() {
		return carnum;
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
	 * 设置：备注信息
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注信息
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
