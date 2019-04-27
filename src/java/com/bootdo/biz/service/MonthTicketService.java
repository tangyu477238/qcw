package com.bootdo.biz.service;

import com.bootdo.biz.domain.MonthTicketDO;

import java.util.List;
import java.util.Map;

/**
 * 用户月票购买记录; InnoDB free: 11264 kB
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-01-01 16:03:30
 */
public interface MonthTicketService {
	
	MonthTicketDO get(Long id);
	
	List<MonthTicketDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(MonthTicketDO monthTicket);
	
	int update(MonthTicketDO monthTicket);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
