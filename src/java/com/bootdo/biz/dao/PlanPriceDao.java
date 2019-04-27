package com.bootdo.biz.dao;

import com.bootdo.biz.domain.PlanPriceDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * InnoDB free: 11264 kB; (`car_id`) REFER `bootdo/biz_car`(`id`); (`route_id`) REF
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-01-01 16:03:51
 */
@Mapper
public interface PlanPriceDao {

	PlanPriceDO get(Long id);
	
	List<PlanPriceDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(PlanPriceDO planPrice);
	
	int update(PlanPriceDO planPrice);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
