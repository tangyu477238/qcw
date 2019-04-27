package com.bootdo.biz.dao;

import com.bootdo.biz.domain.ProxyipDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * InnoDB free: 9216 kB
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-04-09 22:50:45
 */
@Mapper
public interface ProxyipDao {

	ProxyipDO get(Long id);
	
	List<ProxyipDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ProxyipDO proxyip);
	
	int update(ProxyipDO proxyip);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
