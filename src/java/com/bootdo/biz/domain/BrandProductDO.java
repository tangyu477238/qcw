package com.bootdo.biz.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 产品与品牌的关系; InnoDB free: 10240 kB
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-04-05 14:14:36
 */
public class BrandProductDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//
	private Long pid;
	//
	private Long prodId;

	private String prodName;

	private String Image;

	private String xinghao1;


	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}

	public String getXinghao1() {
		return xinghao1;
	}

	public void setXinghao1(String xinghao1) {
		this.xinghao1 = xinghao1;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
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
	public void setPid(Long pid) {
		this.pid = pid;
	}
	/**
	 * 获取：
	 */
	public Long getPid() {
		return pid;
	}
	/**
	 * 设置：
	 */
	public void setProdId(Long prodId) {
		this.prodId = prodId;
	}
	/**
	 * 获取：
	 */
	public Long getProdId() {
		return prodId;
	}
}
