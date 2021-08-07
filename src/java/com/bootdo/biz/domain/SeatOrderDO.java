package com.bootdo.biz.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2021-05-28 23:30:47
 */
@Data
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
	//计划班次id
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
	//是否验票
	private Integer ckstate;
	//线路id
	private Long routeId;
	//
	private String lp;
}
