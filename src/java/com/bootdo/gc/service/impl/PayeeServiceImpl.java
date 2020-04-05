package com.bootdo.gc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.gc.dao.PayeeDao;
import com.bootdo.gc.domain.PayeeDO;
import com.bootdo.gc.service.PayeeService;



@Service
public class PayeeServiceImpl implements PayeeService {
	@Autowired
	private PayeeDao payeeDao;
	
	@Override
	public PayeeDO get(Long id){
		return payeeDao.get(id);
	}
	
	@Override
	public List<PayeeDO> list(Map<String, Object> map){
		return payeeDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return payeeDao.count(map);
	}
	
	@Override
	public int save(PayeeDO payee){
		return payeeDao.save(payee);
	}
	
	@Override
	public int update(PayeeDO payee){
		return payeeDao.update(payee);
	}
	
	@Override
	public int remove(Long id){
		return payeeDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return payeeDao.batchRemove(ids);
	}
	
}
