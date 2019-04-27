package com.bootdo.biz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.biz.dao.BrandModelPailiangDao;
import com.bootdo.biz.domain.BrandModelPailiangDO;
import com.bootdo.biz.service.BrandModelPailiangService;



@Service
public class BrandModelPailiangServiceImpl implements BrandModelPailiangService {
	@Autowired
	private BrandModelPailiangDao brandModelPailiangDao;


	@Override
	public BrandModelPailiangDO getBrandModelPailiang(Map<String, Object> map){
		return brandModelPailiangDao.getBrandModelPailiang(map);
	}

//	@Override
//	public BrandModelPailiangDO get(Long id){
//		return brandModelPailiangDao.get(id);
//	}
//
	@Override
	public List<BrandModelPailiangDO> list(Map<String, Object> map){
		return brandModelPailiangDao.list(map);
	}
//
//	@Override
//	public int count(Map<String, Object> map){
//		return brandModelPailiangDao.count(map);
//	}
//
	@Override
	public int save(BrandModelPailiangDO brandModelPailiang){
		return brandModelPailiangDao.save(brandModelPailiang);
	}
//
//	@Override
//	public int update(BrandModelPailiangDO brandModelPailiang){
//		return brandModelPailiangDao.update(brandModelPailiang);
//	}
//
//	@Override
//	public int remove(Long id){
//		return brandModelPailiangDao.remove(id);
//	}
//
//	@Override
//	public int batchRemove(Long[] ids){
//		return brandModelPailiangDao.batchRemove(ids);
//	}
//
}
