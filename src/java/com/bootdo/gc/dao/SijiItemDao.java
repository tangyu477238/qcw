package com.bootdo.gc.dao;

import com.bootdo.gc.domain.SijiItemDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-06-02 12:28:23
 */
@Mapper
public interface SijiItemDao {

	SijiItemDO get(Long id);

	SijiItemDO getItemDo(Long id);

	
	List<SijiItemDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SijiItemDO sijiItem);
	
	int update(SijiItemDO sijiItem);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);



	List<Map> querySijiList(Map<String, Object> map);

	int querySijiListCount(Map<String, Object> map);

	int heDui(Long id);

	List<Map> daiduizhanglist(Map<String, Object> map);

	int daiduizhanglistCount(Map<String, Object> map);



}
