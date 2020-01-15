package com.bootdo.gc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.gc.dao.AddrDao;
import com.bootdo.gc.domain.AddrDO;
import com.bootdo.gc.service.AddrService;



@Service
public class AddrServiceImpl implements AddrService {
	@Autowired
	private AddrDao addrDao;
	
	@Override
	public AddrDO get(Long id){
		return addrDao.get(id);
	}
	
	@Override
	public List<AddrDO> list(Map<String, Object> map){
		return addrDao.list(map);
	}
	@Override
	public List<AddrDO> listStation(Map<String, Object> map){
		return addrDao.listStation(map);
	}



	@Override
	public int count(Map<String, Object> map){
		return addrDao.count(map);
	}
	
	@Override
	public int save(AddrDO addr){
		return addrDao.save(addr);
	}
	
	@Override
	public int update(AddrDO addr){
		return addrDao.update(addr);
	}
	
	@Override
	public int remove(Long id){
		return addrDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return addrDao.batchRemove(ids);
	}
	
}
