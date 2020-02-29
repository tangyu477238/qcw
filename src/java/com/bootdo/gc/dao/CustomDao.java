package com.bootdo.gc.dao;

import com.bootdo.gc.domain.CustomDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 客户
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-10-10 16:17:23
 */
@Mapper
public interface CustomDao {

	CustomDO get(Long id);
	
	List<CustomDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(CustomDO custom);
	
	int update(CustomDO custom);

	int updateCustomLv(CustomDO custom);


	int remove(Long id);
	
	int batchRemove(Long[] ids);


	List<Map<String, Object>> getCustomList(Map<String, Object> map);
}
