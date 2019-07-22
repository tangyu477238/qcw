package com.bootdo.gc.dao;

import com.bootdo.gc.domain.JiesuanDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-07-14 08:50:37
 */
@Mapper
public interface JiesuanDao {

	JiesuanDO get(Long id);

	JiesuanDO getItem(String payer);


	JiesuanDO getByInvoice(String invoice);

	
	List<JiesuanDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(JiesuanDO jiesuan);
	
	int update(JiesuanDO jiesuan);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
