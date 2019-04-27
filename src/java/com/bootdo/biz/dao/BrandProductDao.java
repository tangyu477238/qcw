package com.bootdo.biz.dao;

import com.bootdo.biz.domain.BrandProductDO;
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



	BrandProductDO get(Long id);
	
	List<BrandProductDO> list(Map<String, Object> map);

	List<BrandProductDO> queryList(Map<String, Object> map);



	int count(Map<String, Object> map);
	
	int save(BrandProductDO brandProduct);
	
	int update(BrandProductDO brandProduct);

	int remove(Long id);

	int delBrandProduct(Map<String, Object> map);

	int batchRemove(Long[] ids);
}
