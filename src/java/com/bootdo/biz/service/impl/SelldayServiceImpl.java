package com.bootdo.biz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.biz.dao.SelldayDao;
import com.bootdo.biz.domain.SelldayDO;
import com.bootdo.biz.service.SelldayService;



@Service
public class SelldayServiceImpl implements SelldayService {
	@Autowired
	private SelldayDao selldayDao;
	
	@Override
	public SelldayDO get(Long id){
		return selldayDao.get(id);
	}
	
	@Override
	public List<SelldayDO> list(Map<String, Object> map){
		return selldayDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return selldayDao.count(map);
	}
	
	@Override
	public int save(SelldayDO sellday){
		return selldayDao.save(sellday);
	}
	
	@Override
	public int update(SelldayDO sellday){
		return selldayDao.update(sellday);
	}
	
	@Override
	public int remove(Long id){
		return selldayDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return selldayDao.batchRemove(ids);
	}
	
}
