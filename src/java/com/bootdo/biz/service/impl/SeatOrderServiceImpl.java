package com.bootdo.biz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.biz.dao.SeatOrderDao;
import com.bootdo.biz.domain.SeatOrderDO;
import com.bootdo.biz.service.SeatOrderService;



@Service
public class SeatOrderServiceImpl implements SeatOrderService {
	@Autowired
	private SeatOrderDao seatOrderDao;
	
	@Override
	public SeatOrderDO get(Long id){
		return seatOrderDao.get(id);
	}
	
	@Override
	public List<SeatOrderDO> list(Map<String, Object> map){
		return seatOrderDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return seatOrderDao.count(map);
	}
	
	@Override
	public int save(SeatOrderDO seatOrder){
		return seatOrderDao.save(seatOrder);
	}
	
	@Override
	public int update(SeatOrderDO seatOrder){
		return seatOrderDao.update(seatOrder);
	}
	
	@Override
	public int remove(Long id){
		return seatOrderDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return seatOrderDao.batchRemove(ids);
	}
	
}
