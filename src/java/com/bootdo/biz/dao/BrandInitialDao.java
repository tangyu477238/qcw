package com.bootdo.biz.dao;

import com.bootdo.biz.domain.BrandInitialDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 首字母; InnoDB free: 10240 kB
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-04-03 23:03:52
 */
@Mapper
public interface BrandInitialDao {

	BrandInitialDO get(Long id);
	
	List<BrandInitialDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(BrandInitialDO brandInitial);
	
	int update(BrandInitialDO brandInitial);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
