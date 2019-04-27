package com.bootdo.biz.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-01-27 16:18:29
 */
public class SeatOrderDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Long id;
	//单号
	private String orderNo;
	//乘车日期
	private String bizDate;
	//乘车时间
	private String bizTime;
	//路线
	private Long planId;
	//座位信息
	private String info;
	//单价
	private BigDecimal price;
	//数量
	private BigDecimal num;
	//总金额(支付金额)
	private BigDecimal amout;
	//创建时间
	private Date createTime;
	//最迟支付时间
	private Date updateTime;
	//购买人
	private String createUser;
	//状态（0待支付1已支付）
	private Integer state;
	//备注
	private String remark;
	//出发站
	private String fromStation;
	//目的站
	private String toStation;
	//姓名
	private String userName;
	//手机号
	private String userMobile;
	//上车点
	private String routeStation;
	//
	private Integer ckstate;

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
	 * 设置：单号
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	/**
	 * 获取：单号
	 */
	public String getOrderNo() {
		return orderNo;
	}
	/**
	 * 设置：乘车日期
	 */
	public void setBizDate(String bizDate) {
		this.bizDate = bizDate;
	}
	/**
	 * 获取：乘车日期
	 */
	public String getBizDate() {
		return bizDate;
	}
	/**
	 * 设置：乘车时间
	 */
	public void setBizTime(String bizTime) {
		this.bizTime = bizTime;
	}
	/**
	 * 获取：乘车时间
	 */
	public String getBizTime() {
		return bizTime;
	}
	/**
	 * 设置：路线
	 */
	public void setPlanId(Long planId) {
		this.planId = planId;
	}
	/**
	 * 获取：路线
	 */
	public Long getPlanId() {
		return planId;
	}
	/**
	 * 设置：座位信息
	 */
	public void setInfo(String info) {
		this.info = info;
	}
	/**
	 * 获取：座位信息
	 */
	public String getInfo() {
		return info;
	}
	/**
	 * 设置：单价
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * 获取：单价
	 */
	public BigDecimal getPrice() {
		return price;
	}
	/**
	 * 设置：数量
	 */
	public void setNum(BigDecimal num) {
		this.num = num;
	}
	/**
	 * 获取：数量
	 */
	public BigDecimal getNum() {
		return num;
	}
	/**
	 * 设置：总金额(支付金额)
	 */
	public void setAmout(BigDecimal amout) {
		this.amout = amout;
	}
	/**
	 * 获取：总金额(支付金额)
	 */
	public BigDecimal getAmout() {
		return amout;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：最迟支付时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：最迟支付时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：购买人
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	/**
	 * 获取：购买人
	 */
	public String getCreateUser() {
		return createUser;
	}
	/**
	 * 设置：状态（0待支付1已支付）
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	/**
	 * 获取：状态（0待支付1已支付）
	 */
	public Integer getState() {
		return state;
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
	 * 设置：出发站
	 */
	public void setFromStation(String fromStation) {
		this.fromStation = fromStation;
	}
	/**
	 * 获取：出发站
	 */
	public String getFromStation() {
		return fromStation;
	}
	/**
	 * 设置：目的站
	 */
	public void setToStation(String toStation) {
		this.toStation = toStation;
	}
	/**
	 * 获取：目的站
	 */
	public String getToStation() {
		return toStation;
	}
	/**
	 * 设置：姓名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：姓名
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置：手机号
	 */
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	/**
	 * 获取：手机号
	 */
	public String getUserMobile() {
		return userMobile;
	}
	/**
	 * 设置：上车点
	 */
	public void setRouteStation(String routeStation) {
		this.routeStation = routeStation;
	}
	/**
	 * 获取：上车点
	 */
	public String getRouteStation() {
		return routeStation;
	}
	/**
	 * 设置：
	 */
	public void setCkstate(Integer ckstate) {
		this.ckstate = ckstate;
	}
	/**
	 * 获取：
	 */
	public Integer getCkstate() {
		return ckstate;
	}
}
