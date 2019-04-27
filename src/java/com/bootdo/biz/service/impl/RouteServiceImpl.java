package com.bootdo.biz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.biz.dao.RouteDao;
import com.bootdo.biz.domain.RouteDO;
import com.bootdo.biz.service.RouteService;



@Service
public class RouteServiceImpl implements RouteService {
	@Autowired
	private RouteDao routeDao;
	
	@Override
	public RouteDO get(Long id){
		return routeDao.get(id);
	}
	
	@Override
	public List<RouteDO> list(Map<String, Object> map){
		return routeDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return routeDao.count(map);
	}
	
	@Override
	public int save(RouteDO route){
		return routeDao.save(route);
	}
	
	@Override
	public int update(RouteDO route){
		return routeDao.update(route);
	}
	
	@Override
	public int remove(Long id){
		return routeDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return routeDao.batchRemove(ids);
	}
	
}
