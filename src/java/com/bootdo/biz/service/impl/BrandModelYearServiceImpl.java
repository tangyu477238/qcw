package com.bootdo.biz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.biz.dao.BrandModelYearDao;
import com.bootdo.biz.domain.BrandModelYearDO;
import com.bootdo.biz.service.BrandModelYearService;



@Service
public class BrandModelYearServiceImpl implements BrandModelYearService {
	@Autowired
	private BrandModelYearDao brandModelYearDao;


    @Override
	public BrandModelYearDO getBrandModelYear(Map<String, Object> map){
		return brandModelYearDao.getBrandModelYear(map);
	}


//
//	@Override
//	public BrandModelYearDO get(Long id){
//		return brandModelYearDao.get(id);
//	}

	@Override
	public List<BrandModelYearDO> list(Map<String, Object> map){
		return brandModelYearDao.list(map);
	}
//
//	@Override
//	public int count(Map<String, Object> map){
//		return brandModelYearDao.count(map);
//	}
//
	@Override
	public int save(BrandModelYearDO brandModelYear){
		return brandModelYearDao.save(brandModelYear);
	}
//
//	@Override
//	public int update(BrandModelYearDO brandModelYear){
//		return brandModelYearDao.update(brandModelYear);
//	}
//
//	@Override
//	public int remove(Long id){
//		return brandModelYearDao.remove(id);
//	}
//
//	@Override
//	public int batchRemove(Long[] ids){
//		return brandModelYearDao.batchRemove(ids);
//	}
	
}
