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
 * @date 2019-05-25 10:38:02
 */
@Data
public class SijiDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Long id;

	@Excel(name = "订单号", orderNum = "1",isImportField = "station")
	//订单号
	private String orderNo;


	//日期
	@Excel(name = "日期", orderNum = "2",isImportField = "bizdate")
	private String bizdate;
	//发货单位
	@Excel(name = "发货单位", orderNum = "3",isImportField = "forwunit")
	private String forwunit;
	//车号
	@Excel(name = "车号", orderNum = "4",isImportField = "carnum")
	private String carnum;
	//到站
	@Excel(name = "到站", orderNum = "5",isImportField = "station")
	private String arrivstation;

	//钢号
	@Excel(name = "钢号", orderNum = "6",isImportField = "station")
	private String steelnum;
	//规格
	@Excel(name = "规格", orderNum = "7",isImportField = "station")
	private String specs;
	//件数
	@Excel(name = "件数", orderNum = "8",isImportField = "station")
	private BigDecimal packnum;

	@Excel(name = "支数", orderNum = "9",isImportField = "station")
	private BigDecimal zhinum;

	//吨数
	@Excel(name = "吨数", orderNum = "10",isImportField = "station")
	private BigDecimal tonnage;
	//基价
	@Excel(name = "基价", orderNum = "11",isImportField = "station")
	private BigDecimal baseprice;
	//系数
	@Excel(name = "系数", orderNum = "12",isImportField = "station")
	private BigDecimal coefficient;
	//运率
	@Excel(name = "运率", orderNum = "13",isImportField = "station")
	private BigDecimal tranrate;
	//运费
	@Excel(name = "运费", orderNum = "14",isImportField = "station")
	private BigDecimal trancost;


	//备注
	@Excel(name = "备注", orderNum = "15",isImportField = "station")
	private String remark;


	//
//	@Excel(name = "", orderNum = "15",isImportField = "station")
	private String payer;


	//付款单位
	@Excel(name = "付款单位", orderNum = "16",isImportField = "station")
	private String inforfee;


	@Excel(name = "交单日期", orderNum = "17",isImportField = "station")
	private String billdate;

	//开票金额
	@Excel(name = "结算金额", orderNum = "18",isImportField = "station")
	private BigDecimal aminvoice;




	//开票单位及日期
	@Excel(name = "开票单位", orderNum = "19",isImportField = "station")
	private String issueoffice;

	//开票单位及日期
	@Excel(name = "开票日期", orderNum = "20",isImportField = "station")
	private String issueofficedate;


	@Excel(name = "收款方式", orderNum = "21",isImportField = "station")
	private String taxdatepay;

	//收款日期
	@Excel(name = "收款日期", orderNum = "22",isImportField = "station")
	private String custompay;


	@Excel(name = "付税款日期", orderNum = "23",isImportField = "station")
	private String paydate;



	@Excel(name = "业务员", orderNum = "24",isImportField = "station")
	private String scustompay;

	private String pid;

}
