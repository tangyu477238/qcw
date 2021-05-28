package com.bootdo.gc.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2020-03-28 10:36:31
 */
@Data
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

	private Date createTime;

}
