package com.bootdo.gc.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2020-01-11 18:17:23
 */
public class AddrDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//到站
	private String station;
	//卸车地址
	private String addr;
	//地区
	private Long deptId;
	//联系电话
	private String tel;
	//联系人
	private String name;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
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
	 * 设置：联系电话
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**
	 * 获取：联系电话
	 */
	public String getTel() {
		return tel;
	}
	/**
	 * 设置：联系人
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：联系人
	 */
	public String getName() {
		return name;
	}
}
