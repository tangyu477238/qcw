package com.bootdo.gc.dao;

import com.bootdo.gc.domain.OrderDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-12-14 21:31:17
 */
@Mapper
public interface OrderDao {

	OrderDO get(Long id);
	
	List<OrderDO> list(Map<String,Object> map);

	List<Map> tlist(Map<String, Object> map);

	int count(Map<String,Object> map);
	
	int save(OrderDO order);
	
	int update(OrderDO order);
	
	int remove(Long id);

	int wancheng(Long id);


	int batchRemove(Long[] ids);

	int saveRemark(Map<String,Object> map);

}
