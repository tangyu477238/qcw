package com.bootdo.gc.service;

import com.bootdo.gc.domain.LirunDO;
import com.bootdo.gc.domain.SijiDO;
import com.bootdo.gc.domain.YingshoukuanDO;

import java.math.BigDecimal;
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


	int updatePiliangPrice(Map<String, Object> map);

	int updatePiliangShuilv(Map<String, Object> map);

	Map getDunSum(String [] ids);
	
	int save(SijiDO siji);
	
	int update(SijiDO siji);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	SijiDO getOrder(String orderNo);


	List<SijiDO> getExcelList(Map<String, Object> map);


	List<Map> queryTotal(Map map);

	List<Map> excelTotal(Map map);




	List<LirunDO> queryLirun(Map map);

	List<Map> arrivstation(Map map);

}
