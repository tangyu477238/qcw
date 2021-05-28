package com.bootdo.gc.service;

import com.bootdo.gc.domain.FukuanDo;
import com.bootdo.gc.domain.KehuDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-05-25 10:38:01
 */
public interface KehuService {

	KehuDO getOrder(String orderNo);


	KehuDO get(Long id);
	
	List<KehuDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(KehuDO kehu);
	
	int update(KehuDO kehu);
	
	int remove(Long id);

	int adminRemove(Long id);
	
	int batchRemove(Long[] ids);

	List<Map> queryKehu(Map map);

	List<Map> queryKehu1(Map map);

	List<FukuanDo> getFukuan(Map params);

	int fukuanCount(Map<String,Object> map);

	void updatePayAccount(String account,String name,String oAccount,String oName);

}
