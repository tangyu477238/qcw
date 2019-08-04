package com.bootdo.gc.service;

import com.bootdo.gc.domain.SijiDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-05-25 10:38:02
 */
public interface SijiService  {
	
	SijiDO get(Long id);
	
	List<SijiDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SijiDO siji);
	
	int update(SijiDO siji);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	SijiDO getOrder(String orderNo);


	List<SijiDO> getExcelList(Map<String, Object> map);


	List<Map> queryTotal(Map map);

	List<Map> queryLirun(Map map);

}
