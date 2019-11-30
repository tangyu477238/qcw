package com.bootdo.gc.service;

import com.bootdo.gc.domain.CustomShuilvDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-11-27 17:12:30
 */
public interface CustomShuilvService {
	
	CustomShuilvDO get(Long id);
	
	List<CustomShuilvDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CustomShuilvDO customShuilv);
	
	int update(CustomShuilvDO customShuilv);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
