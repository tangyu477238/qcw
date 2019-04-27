package com.bootdo.biz.service;

import com.bootdo.biz.domain.PlanPriceDO;

import java.util.List;
import java.util.Map;

/**
 * InnoDB free: 11264 kB; (`car_id`) REFER `bootdo/biz_car`(`id`); (`route_id`) REF
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-01-01 16:03:51
 */
public interface PlanPriceService {
	
	PlanPriceDO get(Long id);
	
	List<PlanPriceDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(PlanPriceDO planPrice);
	
	int update(PlanPriceDO planPrice);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
