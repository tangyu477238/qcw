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
public class SijiItemImp2 implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	@Excel(name = "id", orderNum = "0" )
	private Long id;

	//收款日期
	@Excel(name = "收款日期", orderNum = "1" )
	private String custompay;
	//收款方式
	@Excel(name = "收款方式", orderNum = "2" )
	private String taxdatepay;
	//收款金额
	@Excel(name = "收款金额", orderNum = "3" )
	private BigDecimal takeamount;


}
