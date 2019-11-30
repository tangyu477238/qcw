package com.bootdo.gc.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-11-27 17:12:30
 */
public class CustomShuilvDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Long id;
	//地区
	private Long deptId;
	//税率
	private BigDecimal shuilv;
	//付款单位
	private String fkwd;
	//开票单位
	private String kpdw;

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
	 * 设置：税率
	 */
	public void setShuilv(BigDecimal shuilv) {
		this.shuilv = shuilv;
	}
	/**
	 * 获取：税率
	 */
	public BigDecimal getShuilv() {
		return shuilv;
	}
	/**
	 * 设置：付款单位
	 */
	public void setFkwd(String fkwd) {
		this.fkwd = fkwd;
	}
	/**
	 * 获取：付款单位
	 */
	public String getFkwd() {
		return fkwd;
	}
	/**
	 * 设置：开票单位
	 */
	public void setKpdw(String kpdw) {
		this.kpdw = kpdw;
	}
	/**
	 * 获取：开票单位
	 */
	public String getKpdw() {
		return kpdw;
	}
}
