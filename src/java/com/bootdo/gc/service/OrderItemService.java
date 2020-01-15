package com.bootdo.gc.service;

import com.bootdo.gc.domain.OrderItemDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-12-14 21:31:20
 */
public interface OrderItemService {
	
	OrderItemDO get(Long id);
	
	List<OrderItemDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(OrderItemDO orderItem);
	
	int update(OrderItemDO orderItem);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
