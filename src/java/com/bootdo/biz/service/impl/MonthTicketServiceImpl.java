package com.bootdo.biz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.biz.dao.MonthTicketDao;
import com.bootdo.biz.domain.MonthTicketDO;
import com.bootdo.biz.service.MonthTicketService;



@Service
public class MonthTicketServiceImpl implements MonthTicketService {
	@Autowired
	private MonthTicketDao monthTicketDao;
	
	@Override
	public MonthTicketDO get(Long id){
		return monthTicketDao.get(id);
	}
	
	@Override
	public List<MonthTicketDO> list(Map<String, Object> map){
		return monthTicketDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return monthTicketDao.count(map);
	}
	
	@Override
	public int save(MonthTicketDO monthTicket){
		return monthTicketDao.save(monthTicket);
	}
	
	@Override
	public int update(MonthTicketDO monthTicket){
		return monthTicketDao.update(monthTicket);
	}
	
	@Override
	public int remove(Long id){
		return monthTicketDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return monthTicketDao.batchRemove(ids);
	}
	
}
