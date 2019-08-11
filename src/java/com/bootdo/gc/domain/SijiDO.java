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
	@Excel(name = "id", orderNum = "0")
	private Long id;

	@Excel(name = "订单号", orderNum = "1")
	//订单号
	private String orderNo;


	//日期
	@Excel(name = "日期", orderNum = "2")
	private String bizdate;
	//发货单位
	@Excel(name = "发货单位", orderNum = "3")
	private String forwunit;
	//车号
	@Excel(name = "车号", orderNum = "4")
	private String carnum;
	//到站
	@Excel(name = "到站", orderNum = "5")
	private String arrivstation;

	//钢号
	@Excel(name = "钢号", orderNum = "6")
	private String steelnum;
	//规格
	@Excel(name = "规格", orderNum = "7")
	private String specs;
	//件数
	@Excel(name = "件数", orderNum = "8" , type=10 )
	private BigDecimal packnum;

	@Excel(name = "支数", orderNum = "9" , type=10 )
	private BigDecimal zhinum;

	//吨数
	@Excel(name = "吨数", orderNum = "10", type=10 )
	private BigDecimal tonnage;
	//基价
	@Excel(name = "基价", orderNum = "11" , type=10 )
	private BigDecimal baseprice;
	//系数
	@Excel(name = "系数", orderNum = "12", type=10 )
	private BigDecimal coefficient;
	//运率
	@Excel(name = "运率", orderNum = "13" , type=10 )
	private BigDecimal tranrate;
	//运费
	@Excel(name = "运费", orderNum = "14", type=10 )
	private BigDecimal trancost;


	//备注
	@Excel(name = "备注", orderNum = "15")
	private String remark;




	//付款单位
	@Excel(name = "付款单位", orderNum = "16")
	private String inforfee;

	@Excel(name = "业务员", orderNum = "17")
	private String scustompay;



	@Excel(name = "交单日期", orderNum = "18")
	private String billdate;

	//开票金额
	@Excel(name = "扣零", orderNum = "19", type=10 )
	private BigDecimal kouling;


	//开票金额
	@Excel(name = "结算金额", orderNum = "20", type=10 )
	private BigDecimal aminvoice;


	@Excel(name = "结算录入日期", orderNum = "21")
	private String aminvoicedate;


	//开票单位及日期
	@Excel(name = "开票单位", orderNum = "22")
	private String issueoffice;

	//开票单位及日期
	@Excel(name = "开票日期", orderNum = "23")
	private String issueofficedate;

	@Excel(name = "税率", orderNum = "24", type=10 )
	private BigDecimal shuilv;

	@Excel(name = "税额", orderNum = "25", type=10 )
	private BigDecimal shuie;



	@Excel(name = "付税款日期", orderNum = "26")
	private String paydate;



	@Excel(name = "收款方式", orderNum = "27")
	private String taxdatepay;

	//收款日期
	@Excel(name = "收款日期", orderNum = "28")
	private String custompay;

	//收款金额
	@Excel(name = "收款金额", orderNum = "29", type=10)
	private String takeamount;

	@Excel(name = "收款录入日期", orderNum = "30")
	private String inputdate;

	@Excel(name = "余额", orderNum = "31", type=10)
	private String yue;


	private String payer;


	private String pid;

	private Long deptId;

	private String updatedName;

	//发票号
	private String invoice;




}
