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

	//车号
	@Excel(name = "车号", orderNum = "3",isImportField = "carnum")
	private String carnum;
	//到站
	@Excel(name = "到站", orderNum = "4",isImportField = "station")
	private String station;
	//吨位
	@Excel(name = "吨位", orderNum = "5",isImportField = "tonnage")
	private BigDecimal tonnage;
	//结束吨位
	@Excel(name = "结算吨位", orderNum = "6",isImportField = "settletonnage")
	private BigDecimal settletonnage;
	//调整吨位
	@Excel(name = "调整吨位", orderNum = "7",isImportField = "adjusttonnage")
	private BigDecimal adjusttonnage;
	//运价
	@Excel(name = "运价", orderNum = "8",isImportField = "transcost")
	private BigDecimal transcost;
	//信息费
	@Excel(name = "信息费", orderNum = "9",isImportField = "inforfee")
	private BigDecimal inforfee;
	//收取方式
	@Excel(name = "收取方式", orderNum = "10",isImportField = "colmethod")
	private String colmethod;
	//运费
	@Excel(name = "运费", orderNum = "11",isImportField = "transfee")
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
	@Excel(name = "金额(1)", orderNum = "14",isImportField = "fulltrans")
	private BigDecimal fulltrans;
	//付款时间
	@Excel(name = "付款日期(1)", orderNum = "15",isImportField = "fulpaydate")
	private String fulpaydate;


	//付款方式
	@Excel(name = "付款方式(2)", orderNum = "16",isImportField = "bankcard")
	private String forwunit;
	//金额(2)
	@Excel(name = "金额(2)", orderNum = "17",isImportField = "bankcard")
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



	//余额
	@Excel(name = "余额", orderNum = "19",isImportField = "acbalance")
	private BigDecimal acbalance;
	//回单
	@Excel(name = "回单", orderNum = "20",isImportField = "receipt")
	private String receipt;
	//回单日期
	@Excel(name = "回单日期", orderNum = "21",isImportField = "receiptdate")
	private String receiptdate;
	//承运人
	@Excel(name = "承运人", orderNum = "22",isImportField = "carrier")
	private String carrier;
	//备注
	@Excel(name = "备注", orderNum = "23",isImportField = "remark")
	private String remark;



	private String kpid;


}
