package com.bootdo.gc.service;

import com.bootdo.gc.domain.PayeeDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2020-03-28 10:36:31
 */
public interface PayeeService {



	PayeeDO get(Long id);
	
	List<PayeeDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(PayeeDO payee);
	
	int update(PayeeDO payee);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
