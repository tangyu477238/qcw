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


	private String pid;

	//订单号
	@Excel(name = "订单号", orderNum = "1")
	private String orderNo;

	//业务日期
	@Excel(name = "业务日期", orderNum = "2")
	private String bizdate;

	//发货单位
	@Excel(name = "发货单位", orderNum = "3")
	private String forwunit;


	@Excel(name = "车牌号码", orderNum = "4")
	private String carnum;


	//到站
	@Excel(name = "到站", orderNum = "5")
	private String arrivstation;





	//付款单位
	@Excel(name = "付款单位", orderNum = "6")
	private String inforfee;

	//对账日期
	@Excel(name = "对账日期", orderNum = "7")
	private String billdate;


	//开票金额
	@Excel(name = "开票金额", orderNum = "8", type=10)
	private BigDecimal aminvoice;


	//开票单位
	@Excel(name = "开票单位", orderNum = "9")
	private String issueoffice;


	//开票日期
	@Excel(name = "开票日期", orderNum = "10")
	private String issueofficedate;






	//收款方式
	@Excel(name = "收款方式", orderNum = "11")
	private String taxdatepay;

	//收款日期
	@Excel(name = "收款日期", orderNum = "12")
	private String custompay;

	//收款录入日期
	@Excel(name = "收款录入日期", orderNum = "13")
	private String inputdate;

	//收款金额
	@Excel(name = "收款金额", orderNum = "14", type=10)
	private BigDecimal takeamount;














//	//业务员
//	@Excel(name = "业务员", orderNum = "6",isImportField = "custompay"  )
//	private String scustompay;

//
//
//
//	@Excel(name = "备注", orderNum = "13",isImportField = "remark")
//	private String remark;
//
//
//
//
	//吨位
	private BigDecimal tonnage;

	//运费
	private BigDecimal trancost;


	//扣零
	private BigDecimal kouling;

	//结算录入日期
	private String aminvoicedate;



	private BigDecimal yue;
//
//	//核对
//	private String payer;
//
//
//
//	private String receiptdate;
//
//
//
//
	private Long deptId;
//
//	private String updatedName;
//



	//付税款日期
	private String paydate;
	//税率/税额
	private BigDecimal shuilv;
	private BigDecimal shuie;

	//是否最新结算
	private Integer state;

}
