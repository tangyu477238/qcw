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
public class LirunDO implements Serializable {
	private static final long serialVersionUID = 1L;



	@Excel(name = "订单号", orderNum = "1")
	//订单号
	private String orderNo;

	//日期
	@Excel(name = "日期", orderNum = "2")
	private String bizdate;

	@Excel(name = "发货单位", orderNum = "3")
	private String forwunit;

	//车号
	@Excel(name = "车号", orderNum = "4")
	private String carnum;

	//到站
	@Excel(name = "到站", orderNum = "5")
	private String arrivstation;




	//付款单位
	@Excel(name = "付款单位", orderNum = "6")
	private String inforfee;




	//开票单位
	@Excel(name = "开票单位", orderNum = "7")
	private String issueoffice;


	//结算金额
	@Excel(name = "结算金额", orderNum = "8", type=10 )
	private BigDecimal js;


	//吨位
	@Excel(name = "吨位", orderNum = "9", type=10 )
	private BigDecimal tonnage;

	//运价
	@Excel(name = "运价", orderNum = "10", type=10 )
	private BigDecimal transcost;

	//司机运费
	@Excel(name = "司机运费", orderNum = "11", type=10 )
	private BigDecimal transfee;

	@Excel(name = "手续费", orderNum = "12", type=10 )
	private BigDecimal shoushufei;

	//扣税
	@Excel(name = "扣税", orderNum = "13", type=10 )
	private BigDecimal ks;


	@Excel(name = "余额", orderNum = "14", type=10)
	private BigDecimal yue;



	private String pid;



}
