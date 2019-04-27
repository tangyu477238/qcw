package com.bootdo.biz.service;

import com.bootdo.biz.domain.RouteDO;

import java.util.List;
import java.util.Map;

/**
 * InnoDB free: 11264 kB
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-01-01 16:03:47
 */
public interface RouteService {
	
	RouteDO get(Long id);
	
	List<RouteDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(RouteDO route);
	
	int update(RouteDO route);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
