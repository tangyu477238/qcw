package com.bootdo.biz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.biz.dao.CallplanDao;
import com.bootdo.biz.domain.CallplanDO;
import com.bootdo.biz.service.CallplanService;



@Service
public class CallplanServiceImpl implements CallplanService {
	@Autowired
	private CallplanDao callplanDao;
	
	@Override
	public CallplanDO get(Long id){
		return callplanDao.get(id);
	}
	
	@Override
	public List<CallplanDO> list(Map<String, Object> map){
		return callplanDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return callplanDao.count(map);
	}
	
	@Override
	public int save(CallplanDO callplan){
		return callplanDao.save(callplan);
	}
	
	@Override
	public int update(CallplanDO callplan){
		return callplanDao.update(callplan);
	}
	
	@Override
	public int remove(Long id){
		return callplanDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return callplanDao.batchRemove(ids);
	}
	
}
