package com.bootdo.biz.dao;

import com.bootdo.biz.domain.SelldayDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * InnoDB free: 11264 kB
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2018-12-18 08:09:29
 */
@Mapper
public interface SelldayDao {

	SelldayDO get(Long id);
	
	List<SelldayDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(SelldayDO sellday);
	
	int update(SelldayDO sellday);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
