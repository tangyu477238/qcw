package com.bootdo.biz.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 人员信息表
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2021-05-27 06:32:46
 */
@Data
public class SellerInfoDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private String sellerId;
	//账号
	private String username;
	//密码
	private String password;
	//微信openid
	private String openid;
	//创建时间
	private Date createTime;
	//修改时间
	private Date updateTime;
	//身份证
	private String cardId;
	//手机号
	private String mobile;
	//姓名
	private String name;
	//卡号
	private String cardNo;
	//卡类型
	private String cardType;

	private BigDecimal amount;

	private BigDecimal czje;
}
