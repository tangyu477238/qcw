package com.bootdo.gc.service;

import com.bootdo.gc.domain.SequenceDO;

import java.util.List;
import java.util.Map;

/**
 * 序列号
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-06-14 11:00:32
 */
public interface SequenceService {
	
	SequenceDO get(Long id);
	
	List<SequenceDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SequenceDO sequence);
	
	int update(SequenceDO sequence);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);


	String getSequence(String stype);

}
