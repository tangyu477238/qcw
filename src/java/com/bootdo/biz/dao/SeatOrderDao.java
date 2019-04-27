package com.bootdo.biz.dao;

import com.bootdo.biz.domain.SeatOrderDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-01-27 16:18:29
 */
@Mapper
public interface SeatOrderDao {

	SeatOrderDO get(Long id);
	
	List<SeatOrderDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(SeatOrderDO seatOrder);
	
	int update(SeatOrderDO seatOrder);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
