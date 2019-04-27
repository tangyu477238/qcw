package com.bootdo.biz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.biz.dao.PlanPriceDao;
import com.bootdo.biz.domain.PlanPriceDO;
import com.bootdo.biz.service.PlanPriceService;



@Service
public class PlanPriceServiceImpl implements PlanPriceService {
	@Autowired
	private PlanPriceDao planPriceDao;
	
	@Override
	public PlanPriceDO get(Long id){
		return planPriceDao.get(id);
	}
	
	@Override
	public List<PlanPriceDO> list(Map<String, Object> map){
		return planPriceDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return planPriceDao.count(map);
	}
	
	@Override
	public int save(PlanPriceDO planPrice){
		return planPriceDao.save(planPrice);
	}
	
	@Override
	public int update(PlanPriceDO planPrice){
		return planPriceDao.update(planPrice);
	}
	
	@Override
	public int remove(Long id){
		return planPriceDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return planPriceDao.batchRemove(ids);
	}
	
}
