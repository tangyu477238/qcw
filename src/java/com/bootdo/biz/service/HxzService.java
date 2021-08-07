package com.bootdo.biz.service;

import com.bootdo.biz.domain.SeatOrderDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2021-05-28 23:30:47
 */
public interface HxzService {

	SeatOrderDO consumTransactions(String orderNo,String cardNo);
}
