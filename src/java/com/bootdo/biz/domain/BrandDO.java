package com.bootdo.biz.domain;

import java.io.Serializable;



/**
 * InnoDB free: 10240 kB
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-03-26 23:04:52
 */
public class BrandDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//
	private String brand;
	//
	private String url;
	//
	private String imageurl;

	private String pid;


	public void setPid(String pid) {
		this.pid = pid;
	}
	/**
	 * 获取：
	 */
	public String getPid() {
		return pid;
	}


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
	public void setBrand(String brand) {
		this.brand = brand;
	}
	/**
	 * 获取：
	 */
	public String getBrand() {
		return brand;
	}
	/**
	 * 设置：
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 设置：
	 */
	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}
	/**
	 * 获取：
	 */
	public String getImageurl() {
		return imageurl;
	}
}
