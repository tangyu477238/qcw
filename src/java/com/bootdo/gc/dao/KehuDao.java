package com.bootdo.gc.dao;

import com.bootdo.gc.domain.KehuDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-05-25 10:38:01
 */
@Mapper
public interface KehuDao {

	KehuDO get(Long id);
	
	List<KehuDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(KehuDO kehu);
	
	int update(KehuDO kehu);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);




}
