package com.bootdo.biz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.biz.dao.CarDatetimeSeatDao;
import com.bootdo.biz.domain.CarDatetimeSeatDO;
import com.bootdo.biz.service.CarDatetimeSeatService;



@Service
public class CarDatetimeSeatServiceImpl implements CarDatetimeSeatService {
	@Autowired
	private CarDatetimeSeatDao carDatetimeSeatDao;
	
	@Override
	public CarDatetimeSeatDO get(Long id){
		return carDatetimeSeatDao.get(id);
	}
	
	@Override
	public List<CarDatetimeSeatDO> list(Map<String, Object> map){
		return carDatetimeSeatDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return carDatetimeSeatDao.count(map);
	}
	
	@Override
	public int save(CarDatetimeSeatDO carDatetimeSeat){
		return carDatetimeSeatDao.save(carDatetimeSeat);
	}
	
	@Override
	public int update(CarDatetimeSeatDO carDatetimeSeat){
		return carDatetimeSeatDao.update(carDatetimeSeat);
	}
	
	@Override
	public int remove(Long id){
		return carDatetimeSeatDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return carDatetimeSeatDao.batchRemove(ids);
	}
	
}
