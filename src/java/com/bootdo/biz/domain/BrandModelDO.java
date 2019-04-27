package com.bootdo.biz.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 汽车型号; InnoDB free: 10240 kB
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-04-03 23:03:20
 */
public class BrandModelDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//
	private Long pid;
	//
	private String vehicle;
	//
	private String productid;
	//
	private String brandtype;
	//
	private String brand;
	//
	private String url;
	//
	private String src;
	//
	private String isbaoyang;
	//
	private String carname;
	//
	private String appsrc;
	//
	private String image;
	//
	private String imageurl;
	//
	private String tires;
	//
	private String specialtiresize;
	//
	private String originallsbaoyang;
	//
	private String priority2;
	//
	private String priority3;
	//
	private String vehicleseries;

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
	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}
	/**
	 * 获取：
	 */
	public String getVehicle() {
		return vehicle;
	}
	/**
	 * 设置：
	 */
	public void setProductid(String productid) {
		this.productid = productid;
	}
	/**
	 * 获取：
	 */
	public String getProductid() {
		return productid;
	}
	/**
	 * 设置：
	 */
	public void setBrandtype(String brandtype) {
		this.brandtype = brandtype;
	}
	/**
	 * 获取：
	 */
	public String getBrandtype() {
		return brandtype;
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
	public void setSrc(String src) {
		this.src = src;
	}
	/**
	 * 获取：
	 */
	public String getSrc() {
		return src;
	}
	/**
	 * 设置：
	 */
	public void setIsbaoyang(String isbaoyang) {
		this.isbaoyang = isbaoyang;
	}
	/**
	 * 获取：
	 */
	public String getIsbaoyang() {
		return isbaoyang;
	}
	/**
	 * 设置：
	 */
	public void setCarname(String carname) {
		this.carname = carname;
	}
	/**
	 * 获取：
	 */
	public String getCarname() {
		return carname;
	}
	/**
	 * 设置：
	 */
	public void setAppsrc(String appsrc) {
		this.appsrc = appsrc;
	}
	/**
	 * 获取：
	 */
	public String getAppsrc() {
		return appsrc;
	}
	/**
	 * 设置：
	 */
	public void setImage(String image) {
		this.image = image;
	}
	/**
	 * 获取：
	 */
	public String getImage() {
		return image;
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
	/**
	 * 设置：
	 */
	public void setTires(String tires) {
		this.tires = tires;
	}
	/**
	 * 获取：
	 */
	public String getTires() {
		return tires;
	}
	/**
	 * 设置：
	 */
	public void setSpecialtiresize(String specialtiresize) {
		this.specialtiresize = specialtiresize;
	}
	/**
	 * 获取：
	 */
	public String getSpecialtiresize() {
		return specialtiresize;
	}
	/**
	 * 设置：
	 */
	public void setOriginallsbaoyang(String originallsbaoyang) {
		this.originallsbaoyang = originallsbaoyang;
	}
	/**
	 * 获取：
	 */
	public String getOriginallsbaoyang() {
		return originallsbaoyang;
	}
	/**
	 * 设置：
	 */
	public void setPriority2(String priority2) {
		this.priority2 = priority2;
	}
	/**
	 * 获取：
	 */
	public String getPriority2() {
		return priority2;
	}
	/**
	 * 设置：
	 */
	public void setPriority3(String priority3) {
		this.priority3 = priority3;
	}
	/**
	 * 获取：
	 */
	public String getPriority3() {
		return priority3;
	}
	/**
	 * 设置：
	 */
	public void setVehicleseries(String vehicleseries) {
		this.vehicleseries = vehicleseries;
	}
	/**
	 * 获取：
	 */
	public String getVehicleseries() {
		return vehicleseries;
	}
}
