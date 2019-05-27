package com.bootdo.biz.dao;

import com.bootdo.biz.domain.ProductDO;
import com.bootdo.biz.domain.ProductDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 产品与品牌的关系; InnoDB free: 10240 kB
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-04-05 14:14:36
 */
@Mapper
public interface BrandProductDao {



	ProductDO get(Long id);
	
	List<ProductDO> list(Map<String, Object> map);

	List<ProductDO> queryList(Map<String, Object> map);



	int count(Map<String, Object> map);
	
	int save(ProductDO brandProduct);
	
	int update(ProductDO brandProduct);

	int remove(Long id);

	int delBrandProduct(Map<String, Object> map);

	int batchRemove(Long[] ids);
}
