package com.bootdo.gc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.gc.dao.CustomShuilvDao;
import com.bootdo.gc.domain.CustomShuilvDO;
import com.bootdo.gc.service.CustomShuilvService;



@Service
public class CustomShuilvServiceImpl implements CustomShuilvService {
	@Autowired
	private CustomShuilvDao customShuilvDao;
	
	@Override
	public CustomShuilvDO get(Long id){
		return customShuilvDao.get(id);
	}
	
	@Override
	public List<CustomShuilvDO> list(Map<String, Object> map){
		return customShuilvDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return customShuilvDao.count(map);
	}
	
	@Override
	public int save(CustomShuilvDO customShuilv){
		return customShuilvDao.save(customShuilv);
	}
	
	@Override
	public int update(CustomShuilvDO customShuilv){
		return customShuilvDao.update(customShuilv);
	}
	
	@Override
	public int remove(Long id){
		return customShuilvDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return customShuilvDao.batchRemove(ids);
	}
	
}
