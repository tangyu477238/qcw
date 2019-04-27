package com.bootdo.biz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.biz.dao.BrandInitialDao;
import com.bootdo.biz.domain.BrandInitialDO;
import com.bootdo.biz.service.BrandInitialService;



@Service
public class BrandInitialServiceImpl implements BrandInitialService {
	@Autowired
	private BrandInitialDao brandInitialDao;
	
	@Override
	public BrandInitialDO get(Long id){
		return brandInitialDao.get(id);
	}
	
	@Override
	public List<BrandInitialDO> list(Map<String, Object> map){
		return brandInitialDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return brandInitialDao.count(map);
	}
	
	@Override
	public int save(BrandInitialDO brandInitial){
		return brandInitialDao.save(brandInitial);
	}
	
	@Override
	public int update(BrandInitialDO brandInitial){
		return brandInitialDao.update(brandInitial);
	}
	
	@Override
	public int remove(Long id){
		return brandInitialDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return brandInitialDao.batchRemove(ids);
	}
	
}
