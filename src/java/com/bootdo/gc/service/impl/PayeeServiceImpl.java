package com.bootdo.gc.service.impl;

import com.bootdo.common.utils.DateUtils;
import com.bootdo.gc.dao.PayeeDao;
import com.bootdo.gc.domain.PayeeDO;
import com.bootdo.gc.service.KehuService;
import com.bootdo.gc.service.PayeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Slf4j
@Service
public class PayeeServiceImpl implements PayeeService {
	@Autowired
	private PayeeDao payeeDao;

	@Autowired
	private KehuService kehuService;

	
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
		payee.setCreateTime(new Date());
		return payeeDao.save(payee);
	}
	
	@Override
	public int update(PayeeDO payee){
		PayeeDO p = get(payee.getId());
		if (DateUtils.getNowDate().equals(DateUtils.format(p.getCreateTime()))){
			kehuService.updatePayAccount(payee.getAccount(),payee.getName(),p.getAccount(),p.getName());
		}
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
