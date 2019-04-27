package com.bootdo.biz.service;

import com.bootdo.biz.domain.MonthTicketUserDO;

import java.util.List;
import java.util.Map;

/**
 * 用户月票购买记录
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-01-27 16:18:18
 */
public interface MonthTicketUserService {
	
	MonthTicketUserDO get(Long id);
	
	List<MonthTicketUserDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(MonthTicketUserDO monthTicketUser);
	
	int update(MonthTicketUserDO monthTicketUser);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
