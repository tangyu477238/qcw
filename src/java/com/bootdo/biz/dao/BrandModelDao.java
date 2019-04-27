package com.bootdo.biz.dao;

import com.bootdo.biz.domain.BrandModelDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 汽车型号; InnoDB free: 10240 kB
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-04-03 23:03:20
 */
@Mapper
public interface BrandModelDao {

//	BrandModelDO get(Long id);

    BrandModelDO getBrandModel(Map<String, Object> map);


	List<BrandModelDO> list(Map<String, Object> map);

//	int count(Map<String, Object> map);
//
	int save(BrandModelDO brandModel);
//
//	int update(BrandModelDO brandModel);
//
//	int remove(Long id);
//
//	int batchRemove(Long[] ids);
}
