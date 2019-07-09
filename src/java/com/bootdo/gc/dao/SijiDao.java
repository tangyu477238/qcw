package com.bootdo.gc.dao;

import com.bootdo.gc.domain.KehuDO;
import com.bootdo.gc.domain.SijiDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-05-25 10:38:02
 */
@Mapper
public interface SijiDao {

	SijiDO get(Long id);
	
	List<SijiDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(SijiDO siji);
	
	int update(SijiDO siji);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	SijiDO getOrder(String orderNo);

	List<SijiDO> getExcelList(Map<String,Object> map);

	SijiDO getPid(String pid);


	List<Map> queryTotal(Map map);

}
