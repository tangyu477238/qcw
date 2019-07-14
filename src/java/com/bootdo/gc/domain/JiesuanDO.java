package com.bootdo.gc.domain;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-07-14 08:50:37
 */
@Data
public class JiesuanDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Long id;
	//
	private Long deptId;
	//
	private String updatedName;
	//日期
	@Excel(name = "日期",exportFormat = "yyyy-MM-dd", orderNum = "0" )
	private String bizdate;
	//付款单位
	@Excel(name = "付款单位", orderNum = "1")
	private String payer;

	//发票号
	@Excel(name = "发票号", orderNum = "2" ,type=10)
	private String invoice;
	//发票金额
	@Excel(name = "发票金额", orderNum = "3",type=10)
	private BigDecimal amount;

	//备注
	@Excel(name = "备注", orderNum = "4")
	private String remark;

	//
	private String pid;

}
