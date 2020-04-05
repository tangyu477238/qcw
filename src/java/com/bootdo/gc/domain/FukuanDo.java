package com.bootdo.gc.domain;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.io.Serializable;

@Data
public class FukuanDo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Excel(name = "付款日期", orderNum = "1")
    private String fulpaydate;

    @Excel(name = "业务日期", orderNum = "2" )
    private String bizdate;

    @Excel(name = "车号", orderNum = "3" )
    private String carnum;

    @Excel(name = "到站", orderNum = "4" )
    private String station;

    @Excel(name = "余额", orderNum = "5" ,type=10)
    private String acbalance;





    @Excel(name = "次数", orderNum = "6" )
    private String cishu;

    @Excel(name = "付款金额", orderNum = "7" ,type=10)
    private String fulltrans;

    @Excel(name = "付款方式", orderNum = "8" )
    private String payType;

    @Excel(name = "收款人", orderNum = "9" )
    private String carrier;

    @Excel(name = "收款账号", orderNum = "10" )
    private String riskcues;

}
