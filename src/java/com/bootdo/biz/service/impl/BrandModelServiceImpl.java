package com.bootdo.biz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.biz.dao.BrandModelDao;
import com.bootdo.biz.domain.BrandModelDO;
import com.bootdo.biz.service.BrandModelService;



@Service
public class BrandModelServiceImpl implements BrandModelService {
	@Autowired
	private BrandModelDao brandModelDao;

//	@Override
//	public BrandModelDO get(Long id){
//		return brandModelDao.get(id);
//	}

    @Override
	public BrandModelDO getBrandModel(Map<String, Object> map){
		return brandModelDao.getBrandModel(map);
	}



	@Override
	public List<BrandModelDO> list(Map<String, Object> map){
		return brandModelDao.list(map);
	}
//
//	@Override
//	public int count(Map<String, Object> map){
//		return brandModelDao.count(map);
//	}
//
	@Override
	public int save(BrandModelDO brandModel){
		return brandModelDao.save(brandModel);
	}
//
//	@Override
//	public int update(BrandModelDO brandModel){
//		return brandModelDao.update(brandModel);
//	}
//
//	@Override
//	public int remove(Long id){
//		return brandModelDao.remove(id);
//	}
//
//	@Override
//	public int batchRemove(Long[] ids){
//		return brandModelDao.batchRemove(ids);
//	}
	
}
