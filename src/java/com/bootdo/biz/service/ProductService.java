package com.bootdo.biz.service;

import com.bootdo.biz.domain.ProductDO;

import java.util.List;
import java.util.Map;

/**
 * 汽车排量; InnoDB free: 10240 kB
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-04-05 14:14:42
 */
public interface ProductService {


	ProductDO getProduct(Map<String, Object> map);

	ProductDO get(Long id);
	
	List<ProductDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ProductDO product);
	
	int update(ProductDO product);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
