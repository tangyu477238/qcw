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
public class SijiItemAminvoiceVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Long id;


	@Excel(name = "订单号", orderNum = "1",isImportField = "orderNo")
	private String orderNo;

	@Excel(name = "业务日期", orderNum = "2",isImportField = "bizdate")
	private String bizdate;

	@Excel(name = "发货单位", orderNum = "3",isImportField = "forwunit")
	private String forwunit;

	@Excel(name = "车牌号", orderNum = "4",isImportField = "carnum")
	private String carnum;

	@Excel(name = "到站", orderNum = "5",isImportField = "arrivstation")
	private String arrivstation;




	@Excel(name = "付款单位", orderNum = "6",isImportField = "inforfee"  )
	private String inforfee;

	@Excel(name = "对账日期", orderNum = "7",isImportField = "billdate")
	private String billdate;

	@Excel(name = "总金额", orderNum = "8",isImportField = "aminvoice" , type=10 )
	private BigDecimal aminvoice;

	@Excel(name = "开票单位", orderNum = "9",isImportField = "issueoffice")
	private String issueoffice;


	@Excel(name = "开票日期", orderNum = "10",isImportField = "issueofficedate")
	private String issueofficedate;

	@Excel(name = "录入日期", orderNum = "11",isImportField = "inputdate")
	private String inputdate;

	@Excel(name = "开票金额", orderNum = "12",isImportField = "takeamount" , type=10 )
	private BigDecimal takeamount;

	@Excel(name = "余额", orderNum = "13",isImportField = "syue" , type=10 )
	private BigDecimal syue;




}
