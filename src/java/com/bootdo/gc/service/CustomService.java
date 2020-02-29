package com.bootdo.gc.service;

import com.bootdo.gc.domain.CustomDO;

import java.util.List;
import java.util.Map;

/**
 * 客户
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-10-10 16:17:23
 */
public interface CustomService {

	List<Map<String, Object>> getCustomList(Map<String, Object> map);
	
	CustomDO get(Long id);
	
	List<CustomDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CustomDO custom);
	
	int update(CustomDO custom);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	int updateCustomLv(CustomDO custom);
}
