package com.bootdo.gc.domain;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 
 * 导出交单明细表
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-05-25 10:38:02
 */
@Data
public class SijiItemAminvoiceVO1 implements Serializable {
	private static final long serialVersionUID = 1L;
	


	@Excel(name = "订单号", orderNum = "1",isImportField = "orderNo")
	private String orderNo;

	@Excel(name = "业务日期", orderNum = "2",isImportField = "bizdate")
	private String bizdate;

	@Excel(name = "车牌号", orderNum = "3",isImportField = "carnum")
	private String carnum;

	//到站
	@Excel(name = "到站", orderNum = "4",isImportField = "arrivstation")
	private String arrivstation;





	@Excel(name = "钢材运费", orderNum = "5",isImportField = "trancost" , type=10 )
	private BigDecimal trancost;

	//业务员
	@Excel(name = "业务员", orderNum = "6",isImportField = "scustompay"  )
	private String scustompay;

	@Excel(name = "付款单位", orderNum = "7",isImportField = "inforfee"  )
	//付款单位
	private String inforfee;

	@Excel(name = "对账日期", orderNum = "8",isImportField = "billdate")
	//交单日期
	private String billdate;



	@Excel(name = "扣零", orderNum = "9",isImportField = "kouling" , type=10 )
	//扣零
	private BigDecimal kouling;

	@Excel(name = "结算金额", orderNum = "10",isImportField = "aminvoice" , type=10 )
	//结算金额
	private BigDecimal aminvoice;

	@Excel(name = "余额", orderNum = "11",isImportField = "yue" , type=10 )
	private BigDecimal yue;









}
