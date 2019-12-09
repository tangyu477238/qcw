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
public class SijiItemAminvoiceDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Long id;
	//pid
	//@Excel(name = "pid", orderNum = "1",isImportField = "pid")
	private String pid;

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

	@Excel(name = "未开票金额", orderNum = "11",isImportField = "yue" , type=10 )
	private BigDecimal yue;




	//基价
	@Excel(name = "开票金额", orderNum = "12",isImportField = "baseprice" , type=10 )
	private BigDecimal baseprice;
	//系数
	@Excel(name = "待回款金额", orderNum = "13",isImportField = "coefficient" , type=10 )
	private BigDecimal coefficient;
	//运率
	@Excel(name = "已回款金额", orderNum = "14",isImportField = "tranrate" , type=10 )
	private BigDecimal tranrate;
	//运费



	//吨位
	@Excel(name = "余额", orderNum = "15",isImportField = "tonnage" , type=10 )
	private BigDecimal tonnage;


	private String remark;











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
