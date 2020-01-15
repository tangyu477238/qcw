package com.bootdo.gc.dao;

import com.bootdo.gc.domain.AddrDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2020-01-11 18:17:23
 */
@Mapper
public interface AddrDao {

	AddrDO get(Long id);
	
	List<AddrDO> list(Map<String,Object> map);

	List<AddrDO> listStation(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(AddrDO addr);
	
	int update(AddrDO addr);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
