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
 * @date 2019-05-25 10:38:01
 */
@Data
public class KehuDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;

	@Excel(name = "单号", orderNum = "1",isImportField = "orderNo")
	private String orderNo;
	//日期
	@Excel(name = "日期", orderNum = "2",isImportField = "bizdate")
	private String bizdate;

	@Excel(name = "付款单位", orderNum = "2",isImportField = "payer")
	private String payer;

	//车号
	@Excel(name = "车号", orderNum = "3",isImportField = "carnum")
	private String carnum;
	//到站
	@Excel(name = "到站", orderNum = "4",isImportField = "station")
	private String station;
	//吨位
	@Excel(name = "吨位", orderNum = "5",isImportField = "tonnage" , type=10 )
	private BigDecimal tonnage;

	//调整吨位
	@Excel(name = "调整吨位", orderNum = "6",isImportField = "adjusttonnage" , type=10 )
	private BigDecimal adjusttonnage;

	//结算吨位
	@Excel(name = "结算吨位", orderNum = "7",isImportField = "settletonnage", type=10 )
	private BigDecimal settletonnage;

	//运价
	@Excel(name = "运价", orderNum = "8",isImportField = "transcost" , type=10 )
	private BigDecimal transcost;
	//信息费
	@Excel(name = "信息费", orderNum = "9",isImportField = "inforfee" , type=10 )
	private BigDecimal inforfee;
	//收取方式
	@Excel(name = "收取方式", orderNum = "10",isImportField = "colmethod")
	private String colmethod;
	//运费
	@Excel(name = "运费", orderNum = "11",isImportField = "transfee", type=10 )
	private BigDecimal transfee;

	//付款约定
	@Excel(name = "付款约定", orderNum = "12",isImportField = "bankpaytwodate")
	private String bankpaytwodate;

	//风险提示
	private String riskcues;


	//付款方式(1)
	@Excel(name = "付款方式(1)", orderNum = "13",isImportField = "payType")
	private String payType;
	//金额(1)
	@Excel(name = "金额(1)", orderNum = "14",isImportField = "fulltrans", type=10 )
	private BigDecimal fulltrans;
	//付款时间
	@Excel(name = "付款日期(1)", orderNum = "15",isImportField = "fulpaydate")
	private String fulpaydate;


	//付款方式
	@Excel(name = "付款方式(2)", orderNum = "16",isImportField = "bankcard")
	private String forwunit;
	//金额(2)
	@Excel(name = "金额(2)", orderNum = "17",isImportField = "bankcard" , type=10 )
	private BigDecimal bankcard;
	//付款日期
	@Excel(name = "付款日期(2)", orderNum = "18",isImportField = "bankpaydate")
	private String bankpaydate;





	//
//	@Excel(name = "", orderNum = "17",isImportField = "bankcardtwo")
	private BigDecimal bankcardtwo;
	//
//	@Excel(name = "", orderNum = "19",isImportField = "fultranstwo")
	private BigDecimal fultranstwo;
	//
//	@Excel(name = "", orderNum = "20",isImportField = "fulpaytwodate")
	private String fulpaytwodate;


	//手续费
	@Excel(name = "手续费", orderNum = "19", type=10 )
	private BigDecimal shoushufei;


	//余额
	@Excel(name = "余额", orderNum = "20",isImportField = "acbalance", type=10 )
	private BigDecimal acbalance;
	//回单
	@Excel(name = "回单", orderNum = "21",isImportField = "receipt")
	private String receipt;
	//回单日期
	@Excel(name = "回单日期", orderNum = "22",isImportField = "receiptdate")
	private String receiptdate;
	//承运人
	@Excel(name = "承运人", orderNum = "23",isImportField = "carrier")
	private String carrier;
	//备注
	@Excel(name = "备注", orderNum = "24",isImportField = "remark")
	private String remark;




	private String shoushufeidate;

	private Long deptId;

	private String updatedName;

	private String kpid;


}
