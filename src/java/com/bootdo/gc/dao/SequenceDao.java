package com.bootdo.gc.dao;

import com.bootdo.gc.domain.SequenceDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 序列号
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-06-14 11:00:32
 */
@Mapper
public interface SequenceDao {

	SequenceDO get(Long id);
	
	List<SequenceDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(SequenceDO sequence);
	
	int update(SequenceDO sequence);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	SequenceDO querySequence(String stype,String bizDate);

}
