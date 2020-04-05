package com.bootdo.gc.domain;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-05-25 10:38:02
 */
@Data
public class YingshoukuanDO implements Serializable {
	private static final long serialVersionUID = 1L;


	//付款单位
	@Excel(name = "付款单位", orderNum = "1")
	private String inforfee;

	@Excel(name = "前11月", orderNum = "2", type=10)
	private BigDecimal bizMonth11;
	@Excel(name = "前10月", orderNum = "3", type=10)
	private BigDecimal bizMonth10;
	@Excel(name = "前9月", orderNum = "4", type=10)
	private BigDecimal bizMonth9;
	@Excel(name = "前8月", orderNum = "5", type=10)
	private BigDecimal bizMonth8;
	@Excel(name = "前7月", orderNum = "6", type=10)
	private BigDecimal bizMonth7;
	@Excel(name = "前6月", orderNum = "7", type=10)
	private BigDecimal bizMonth6;

	@Excel(name = "前5月", orderNum = "8", type=10)
	private BigDecimal bizMonth5;
	@Excel(name = "前4月", orderNum = "9", type=10)
	private BigDecimal bizMonth4;
	@Excel(name = "前3月", orderNum = "10", type=10)
	private BigDecimal bizMonth3;
	@Excel(name = "前2月", orderNum = "11", type=10)
	private BigDecimal bizMonth2;
	@Excel(name = "前1月", orderNum = "12", type=10)
	private BigDecimal bizMonth1;
	@Excel(name = "当月", orderNum = "13", type=10)
	private BigDecimal bizMonth0;

	@Excel(name = "当日开票", orderNum = "14", type=10)
	private BigDecimal dayTakeamount;
	@Excel(name = "当日回款", orderNum = "15", type=10)
	private BigDecimal dayInvoamount;
	@Excel(name = "调整金额", orderNum = "16", type=10)
	private BigDecimal tiaozheng;
	@Excel(name = "余额", orderNum = "17", type=10)
	private BigDecimal totalAmount;

}
