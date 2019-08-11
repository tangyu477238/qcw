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
public class SijiItemImp1 implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	@Excel(name = "id", orderNum = "0" )
	private Long id;


	@Excel(name = "交单日期", orderNum = "1" )
	//交单日期
	private String billdate;

	//扣零
	@Excel(name = "扣零", orderNum = "2" )
	private BigDecimal kouling;

	//结算金额
	@Excel(name = "结算金额", orderNum = "3" )
	private BigDecimal aminvoice;


	//开票单位
	@Excel(name = "开票单位", orderNum = "4" )
	private String issueoffice;

	//开票日期
	@Excel(name = "开票日期", orderNum = "5" )
	private String issueofficedate;


	//结算金额
	@Excel(name = "税率", orderNum = "6" )
	private BigDecimal shuilv;


	//付税款日期
	@Excel(name = "付税款日期", orderNum = "7" )
	private String paydate;




}
