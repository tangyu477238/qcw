package com.bootdo.biz.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * InnoDB free: 9216 kB
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-04-09 22:50:45
 */

public class ProxyipDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//
	private String ip;
	//
	private Integer port;
	//
	private String type;
	//
	private String addr;
	//
	private Integer used;
	//
	private String other;

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
	 * 设置：
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
	/**
	 * 获取：
	 */
	public String getIp() {
		return ip;
	}
	/**
	 * 设置：
	 */
	public void setPort(Integer port) {
		this.port = port;
	}
	/**
	 * 获取：
	 */
	public Integer getPort() {
		return port;
	}
	/**
	 * 设置：
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：
	 */
	public void setAddr(String addr) {
		this.addr = addr;
	}
	/**
	 * 获取：
	 */
	public String getAddr() {
		return addr;
	}
	/**
	 * 设置：
	 */
	public void setUsed(Integer used) {
		this.used = used;
	}
	/**
	 * 获取：
	 */
	public Integer getUsed() {
		return used;
	}
	/**
	 * 设置：
	 */
	public void setOther(String other) {
		this.other = other;
	}
	/**
	 * 获取：
	 */
	public String getOther() {
		return other;
	}
}
