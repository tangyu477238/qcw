package com.bootdo.gc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.gc.dao.DriverDao;
import com.bootdo.gc.domain.DriverDO;
import com.bootdo.gc.service.DriverService;



@Service
public class DriverServiceImpl implements DriverService {
	@Autowired
	private DriverDao driverDao;
	
	@Override
	public DriverDO get(Long id){
		return driverDao.get(id);
	}
	
	@Override
	public List<DriverDO> list(Map<String, Object> map){
		return driverDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return driverDao.count(map);
	}
	
	@Override
	public int save(DriverDO driver){
		return driverDao.save(driver);
	}
	
	@Override
	public int update(DriverDO driver){
		return driverDao.update(driver);
	}
	
	@Override
	public int remove(Long id){
		return driverDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return driverDao.batchRemove(ids);
	}
	
}
