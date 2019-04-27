package com.bootdo.biz.dao;

//import com.bootdo.biz.domain.BrandDO;
//
//import java.util.List;
//import java.util.Map;
//
//import org.apache.ibatis.annotations.Mapper;

import com.bootdo.biz.domain.BrandDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * InnoDB free: 10240 kB
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-03-26 23:04:52
 */
@Mapper
public interface BrandDao {

	BrandDO getBrand(Map<String, Object> map);

	BrandDO get(Long id);

	List<BrandDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	int save(BrandDO brand);

	int update(BrandDO brand);

	int remove(Long id);

	int batchRemove(Long[] ids);
}
