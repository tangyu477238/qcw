package com.bootdo.biz.service.impl;

import com.bootdo.biz.dao.ProductDao;
import com.bootdo.biz.domain.ProductDO;
import com.bootdo.biz.service.BrandProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class BrandProductServiceImpl implements BrandProductService {
	@Autowired
	private ProductDao productDao;


	@Override
	public List<ProductDO> queryList(Map<String, Object> map){
		return productDao.list(map);
	}


//
//	@Override
//	public BrandProductDO get(Long id){
//		return brandProductDao.get(id);
//	}
//
//	@Override
//	public List<BrandProductDO> list(Map<String, Object> map){
//		return brandProductDao.list(map);
//	}
//
//	@Override
//	public int count(Map<String, Object> map){
//		return brandProductDao.count(map);
//	}
//
//	@Override
//	public int save(BrandProductDO brandProduct){
//		return brandProductDao.save(brandProduct);
//	}
//
//	@Override
//	public int update(BrandProductDO brandProduct){
//		return brandProductDao.update(brandProduct);
//	}
//
//	@Override
//	public int remove(Long id){
//		return brandProductDao.remove(id);
//	}
//
//	@Override
//	public int batchRemove(Long[] ids){
//		return brandProductDao.batchRemove(ids);
//	}
	
}
