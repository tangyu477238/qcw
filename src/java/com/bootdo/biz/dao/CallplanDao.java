package com.bootdo.biz.dao;

import com.bootdo.biz.domain.CallplanDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * InnoDB free: 11264 kB
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2018-12-17 21:41:29
 */
@Mapper
public interface CallplanDao {

	CallplanDO get(Long id);
	
	List<CallplanDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(CallplanDO callplan);
	
	int update(CallplanDO callplan);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
