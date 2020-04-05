package com.bootdo.gc.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2020-03-28 10:36:31
 */
public class PayeeDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//收款人
	private String name;
	//收款账号
	private String account;
	//地区
	private Long deptId;

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
	 * 设置：收款人
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：收款人
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：收款账号
	 */
	public void setAccount(String account) {
		this.account = account;
	}
	/**
	 * 获取：收款账号
	 */
	public String getAccount() {
		return account;
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
}
