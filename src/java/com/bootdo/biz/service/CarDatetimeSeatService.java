package com.bootdo.biz.service;

import com.bootdo.biz.domain.CarDatetimeSeatDO;

import java.util.List;
import java.util.Map;

/**
 * InnoDB free: 11264 kB; (`plan_id`) REFER `bootdo/biz_plan_price`(`id`)
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-01-01 22:46:29
 */
public interface CarDatetimeSeatService {
	
	CarDatetimeSeatDO get(Long id);
	
	List<CarDatetimeSeatDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CarDatetimeSeatDO carDatetimeSeat);
	
	int update(CarDatetimeSeatDO carDatetimeSeat);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
