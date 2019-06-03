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
	//日期
	@Excel(name = "日期", orderNum = "1",isImportField = "bizdate")
	private String bizdate;
	//发货单位
	@Excel(name = "发货单位", orderNum = "2",isImportField = "forwunit")
	private String forwunit;
	//车号
	@Excel(name = "车号", orderNum = "3",isImportField = "carnum")
	private String carnum;
	//到站
	@Excel(name = "到站", orderNum = "4",isImportField = "station")
	private String station;
	//吨位
	@Excel(name = "吨位", orderNum = "5",isImportField = "tonnage")
	private String tonnage;
	//结束吨位
	@Excel(name = "结算吨位", orderNum = "6",isImportField = "settletonnage")
	private String settletonnage;
	//调整吨位
	@Excel(name = "调整吨位", orderNum = "7",isImportField = "adjusttonnage")
	private String adjusttonnage;
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
	//风险提示
	@Excel(name = "风险提示", orderNum = "12",isImportField = "riskcues")
	private String riskcues;
	//运满满
	@Excel(name = "运满满", orderNum = "13",isImportField = "fulltrans")
	private String fulltrans;
	//运满满付款时间
	@Excel(name = "运满满付款时间", orderNum = "14",isImportField = "fulpaydate")
	private String fulpaydate;
	//银行卡
	@Excel(name = "银行卡", orderNum = "15",isImportField = "bankcard")
	private String bankcard;
	//银行卡付款日期
	@Excel(name = "银行卡付款日期", orderNum = "16",isImportField = "bankpaydate")
	private String bankpaydate;
	//农行卡二次付款
	@Excel(name = "农行卡二次付款", orderNum = "17",isImportField = "bankcardtwo")
	private BigDecimal bankcardtwo;
	//银行卡二次付款日期
	@Excel(name = "银行卡二次付款日期", orderNum = "18",isImportField = "bankpaytwodate")
	private String bankpaytwodate;
	//运满满二次付款
	@Excel(name = "运满满二次付款", orderNum = "19",isImportField = "fultranstwo")
	private BigDecimal fultranstwo;
	//运满满二次付款日期
	@Excel(name = "运满满二次付款日期", orderNum = "20",isImportField = "fulpaytwodate")
	private String fulpaytwodate;
	//余额
	@Excel(name = "余额", orderNum = "21",isImportField = "acbalance")
	private BigDecimal acbalance;
	//回单
	@Excel(name = "回单", orderNum = "22",isImportField = "receipt")
	private String receipt;
	//回单日期
	@Excel(name = "回单日期", orderNum = "23",isImportField = "receiptdate")
	private String receiptdate;
	//承运人
	@Excel(name = "承运人", orderNum = "24",isImportField = "carrier")
	private String carrier;
	//备注
	@Excel(name = "备注", orderNum = "25",isImportField = "remark")
	private String remark;

	@Excel(name = "单号", orderNum = "26",isImportField = "orderNo")
	private String orderNo;


}
