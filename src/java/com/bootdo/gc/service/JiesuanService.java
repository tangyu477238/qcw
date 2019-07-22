package com.bootdo.gc.service;

import com.bootdo.gc.domain.JiesuanDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-07-14 08:50:37
 */
public interface JiesuanService {
	
	JiesuanDO get(Long id);

	JiesuanDO getItem(String payer);

	List<JiesuanDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(JiesuanDO jiesuan);
	
	int update(JiesuanDO jiesuan);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	void importExcel(List<JiesuanDO> jiesuanDOList);
}
