package com.bootdo.biz.service.impl;

import com.bootdo.biz.dao.ProxyipDao;
import com.bootdo.biz.domain.ProxyipDO;
import com.bootdo.biz.service.ProxyipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service
public class ProxyipServiceImpl implements ProxyipService {
	@Autowired
	private ProxyipDao proxyipDao;
	
	@Override
	public ProxyipDO get(Long id){
		return proxyipDao.get(id);
	}
	
	@Override
	public List<ProxyipDO> list(Map<String, Object> map){
		return proxyipDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return proxyipDao.count(map);
	}
	
	@Override
	public int save(ProxyipDO proxyip){
		return proxyipDao.save(proxyip);
	}
	
	@Override
	public int update(ProxyipDO proxyip){
		return proxyipDao.update(proxyip);
	}
	
	@Override
	public int remove(Long id){
		return proxyipDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return proxyipDao.batchRemove(ids);
	}
	
}
