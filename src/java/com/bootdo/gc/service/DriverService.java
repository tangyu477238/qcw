package com.bootdo.gc.service;

import com.bootdo.gc.domain.DriverDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-12-15 12:44:32
 */
public interface DriverService {
	
	DriverDO get(Long id);
	
	List<DriverDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(DriverDO driver);
	
	int update(DriverDO driver);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
