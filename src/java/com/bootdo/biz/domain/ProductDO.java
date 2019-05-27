package com.bootdo.biz.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 汽车排量; InnoDB free: 10240 kB
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-04-05 14:14:42
 */
public class ProductDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//
	private String productId;
	//
	private String variantId;
	//
	private String displayName;
	//
	private String primaryParentCategory;
	//
	private String Image;
	//
	private BigDecimal price;
	//
	private String unit;
	//
	private BigDecimal marketingPrice;


	private String brand;

	private String xinghao1;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getXinghao1() {
		return xinghao1;
	}

	public void setXinghao1(String xinghao1) {
		this.xinghao1 = xinghao1;
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
	public void setProductId(String productId) {
		this.productId = productId;
	}
	/**
	 * 获取：
	 */
	public String getProductId() {
		return productId;
	}
	/**
	 * 设置：
	 */
	public void setVariantId(String variantId) {
		this.variantId = variantId;
	}
	/**
	 * 获取：
	 */
	public String getVariantId() {
		return variantId;
	}
	/**
	 * 设置：
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	/**
	 * 获取：
	 */
	public String getDisplayName() {
		return displayName;
	}
	/**
	 * 设置：
	 */
	public void setPrimaryParentCategory(String primaryParentCategory) {
		this.primaryParentCategory = primaryParentCategory;
	}
	/**
	 * 获取：
	 */
	public String getPrimaryParentCategory() {
		return primaryParentCategory;
	}


	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}

	/**
	 * 设置：
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getPrice() {
		return price;
	}
	/**
	 * 设置：
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
	/**
	 * 获取：
	 */
	public String getUnit() {
		return unit;
	}
	/**
	 * 设置：
	 */
	public void setMarketingPrice(BigDecimal marketingPrice) {
		this.marketingPrice = marketingPrice;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getMarketingPrice() {
		return marketingPrice;
	}
}
