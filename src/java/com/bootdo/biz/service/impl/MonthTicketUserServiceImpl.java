package com.bootdo.biz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.biz.dao.MonthTicketUserDao;
import com.bootdo.biz.domain.MonthTicketUserDO;
import com.bootdo.biz.service.MonthTicketUserService;



@Service
public class MonthTicketUserServiceImpl implements MonthTicketUserService {
	@Autowired
	private MonthTicketUserDao monthTicketUserDao;
	
	@Override
	public MonthTicketUserDO get(Long id){
		return monthTicketUserDao.get(id);
	}
	
	@Override
	public List<MonthTicketUserDO> list(Map<String, Object> map){
		return monthTicketUserDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return monthTicketUserDao.count(map);
	}
	
	@Override
	public int save(MonthTicketUserDO monthTicketUser){
		return monthTicketUserDao.save(monthTicketUser);
	}
	
	@Override
	public int update(MonthTicketUserDO monthTicketUser){
		return monthTicketUserDao.update(monthTicketUser);
	}
	
	@Override
	public int remove(Long id){
		return monthTicketUserDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return monthTicketUserDao.batchRemove(ids);
	}
	
}
