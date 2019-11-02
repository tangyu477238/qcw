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
public class SijiItemInvoiceDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Long id;
	//pid
	//@Excel(name = "pid", orderNum = "1",isImportField = "pid")
	private String pid;

	//钢号
	@Excel(name = "业务日期", orderNum = "4",isImportField = "bizdate")
	private String bizdate;


	//规格
	@Excel(name = "订单号", orderNum = "5",isImportField = "orderNo")
	private String orderNo;

	//业务员
	@Excel(name = "业务员", orderNum = "6",isImportField = "custompay"  )
	private String scustompay;



	//吨数
	@Excel(name = "吨数", orderNum = "7",isImportField = "tonnage" , type=10 )
	private BigDecimal tonnage;
	//基价
	@Excel(name = "基价", orderNum = "8",isImportField = "baseprice" , type=10 )
	private BigDecimal baseprice;
	//系数
	@Excel(name = "系数", orderNum = "9",isImportField = "coefficient" , type=10 )
	private BigDecimal coefficient;
	//运率
	@Excel(name = "运率", orderNum = "10",isImportField = "tranrate" , type=10 )
	private BigDecimal tranrate;
	//运费
	@Excel(name = "运费", orderNum = "11",isImportField = "trancost" , type=10 )
	private BigDecimal trancost;

	private String carnum;

	//到站
	@Excel(name = "到站", orderNum = "12",isImportField = "arrivstation")
	private String arrivstation;

	@Excel(name = "备注", orderNum = "13",isImportField = "remark")
	private String remark;


	//付款单位
	private String inforfee;





	@Excel(name = "交单日期", orderNum = "14",isImportField = "billdate")
	//交单日期
	private String billdate;

	//扣零
	private BigDecimal kouling;

	//结算金额
	private BigDecimal aminvoice;

	//结算录入日期
	private String aminvoicedate;

	//开票单位
	private String issueoffice;

	//开票日期
	private String issueofficedate;

	//付税款日期
	private String paydate;



	//收款日期
	private String custompay;

	//收款方式
	private String taxdatepay;

	//收款金额
	private BigDecimal takeamount;

	//收款录入日期
	private String inputdate;



	private BigDecimal yue;

	//核对
	private String payer;



	private String receiptdate;




	private Long deptId;

	private String updatedName;

	//税率/税额
	private BigDecimal shuilv;
	private BigDecimal shuie;

	//是否最新结算
	private Integer state;

}
