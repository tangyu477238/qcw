package com.bootdo.gc.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 客户
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-10-10 16:17:23
 */
@Data
public class CustomDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//名称
	private String name;
	//税率
	private BigDecimal shuilv;



	private Long deptId;
	private String stype;









}
