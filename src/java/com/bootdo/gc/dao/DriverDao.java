package com.bootdo.gc.dao;

import com.bootdo.gc.domain.DriverDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-12-15 12:44:32
 */
@Mapper
public interface DriverDao {

	DriverDO get(Long id);
	
	List<DriverDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(DriverDO driver);
	
	int update(DriverDO driver);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
