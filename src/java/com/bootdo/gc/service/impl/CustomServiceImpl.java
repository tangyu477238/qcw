package com.bootdo.gc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.gc.dao.CustomDao;
import com.bootdo.gc.domain.CustomDO;
import com.bootdo.gc.service.CustomService;



@Service
public class CustomServiceImpl implements CustomService {
	@Autowired
	private CustomDao customDao;


	@Override
	public List<Map<String, Object>> getCustomList(Map<String, Object> map) {
		return customDao.getCustomList(map);
	}

	@Override
	public CustomDO get(Long id){
		return customDao.get(id);
	}
	
	@Override
	public List<CustomDO> list(Map<String, Object> map){
		return customDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return customDao.count(map);
	}
	
	@Override
	public int save(CustomDO custom){
		return customDao.save(custom);
	}
	
	@Override
	public int update(CustomDO custom){
		return customDao.update(custom);
	}
	@Override
	public int updateCustomLv(CustomDO custom){
		return customDao.updateCustomLv(custom);
	}

	@Override
	public int remove(Long id){
		return customDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return customDao.batchRemove(ids);
	}
	
}
