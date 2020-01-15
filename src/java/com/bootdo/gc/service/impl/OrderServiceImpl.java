package com.bootdo.gc.service.impl;

import com.bootdo.gc.dao.OrderItemDao;
import com.bootdo.gc.domain.OrderItemDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bootdo.gc.dao.OrderDao;
import com.bootdo.gc.domain.OrderDO;
import com.bootdo.gc.service.OrderService;



@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderItemDao orderItemDao;

	@Autowired
	private OrderDao orderDao;
	
	@Override
	public OrderDO get(Long id){
		return orderDao.get(id);
	}
	
	@Override
	public List<OrderDO> list(Map<String, Object> map){
		return orderDao.list(map);
	}

	@Override
	public List<Map> tlist(Map<String, Object> map){
		List<Map> list = orderDao.tlist(map);
		List<Map> orderList = new ArrayList<>();
		for (Map m :list){
			OrderDO orderDO = orderDao.get(new Long(m.get("id").toString()));
			m.put("sytonnage",orderDO.getSytonnage());
			orderList.add(m);
		}

		return list;
	}



	@Override
	public int count(Map<String, Object> map){
		return orderDao.count(map);
	}
	
	@Override
	public int save(OrderDO order){
		return orderDao.save(order);
	}
	
	@Override
	public int update(OrderDO order){
		return orderDao.update(order);
	}

	@Override
	public int saveRemark(Map<String, Object> map){
		return orderDao.saveRemark(map);
	}

	
	@Override
	public int remove(Long id){
		Map map = new HashMap();
		map.put("pid",id);
		List<OrderItemDO> list = orderItemDao.list(map);
		if (list.size()>0){
			return 0 ;
		}
		return orderDao.remove(id);
	}

	@Override
	public int wancheng(Long id){
		return orderDao.wancheng(id);
	}



	
	@Override
	public int batchRemove(Long[] ids){
		return orderDao.batchRemove(ids);
	}
	
}
