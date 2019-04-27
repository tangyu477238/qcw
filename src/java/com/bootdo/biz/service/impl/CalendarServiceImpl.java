package com.bootdo.biz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.biz.dao.CalendarDao;
import com.bootdo.biz.domain.CalendarDO;
import com.bootdo.biz.service.CalendarService;



@Service
public class CalendarServiceImpl implements CalendarService {
	@Autowired
	private CalendarDao calendarDao;
	
	@Override
	public CalendarDO get(Long id){
		return calendarDao.get(id);
	}
	
	@Override
	public List<CalendarDO> list(Map<String, Object> map){
		return calendarDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return calendarDao.count(map);
	}
	
	@Override
	public int save(CalendarDO calendar){
		return calendarDao.save(calendar);
	}
	
	@Override
	public int update(CalendarDO calendar){
		return calendarDao.update(calendar);
	}
	
	@Override
	public int remove(Long id){
		return calendarDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return calendarDao.batchRemove(ids);
	}
	
}
