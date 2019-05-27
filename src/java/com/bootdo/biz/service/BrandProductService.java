package com.bootdo.biz.service;

import com.bootdo.biz.domain.ProductDO;

import java.util.List;
import java.util.Map;

/**
 * 产品与品牌的关系; InnoDB free: 10240 kB
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-04-05 14:14:36
 */
public interface BrandProductService {
	
//	BrandProductDO get(Long id);
//
//	List<BrandProductDO> list(Map<String, Object> map);
//
//	int count(Map<String, Object> map);
//
//	int save(BrandProductDO brandProduct);
//
//	int update(BrandProductDO brandProduct);
//
//	int remove(Long id);
//
//	int batchRemove(Long[] ids);

    List<ProductDO> queryList(Map<String, Object> map);
}
