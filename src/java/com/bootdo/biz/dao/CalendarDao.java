package com.bootdo.biz.dao;

import com.bootdo.biz.domain.CalendarDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * InnoDB free: 11264 kB
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2018-12-18 22:09:03
 */
@Mapper
public interface CalendarDao {

	CalendarDO get(Long id);
	
	List<CalendarDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(CalendarDO calendar);
	
	int update(CalendarDO calendar);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
