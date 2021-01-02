package com.bootdo.gc.service;

import com.bootdo.gc.domain.JiesuanDO;
import com.bootdo.gc.domain.SijiItemDO;
import com.bootdo.gc.domain.SijiItemImp1;
import com.bootdo.gc.domain.SijiItemImp2;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-06-02 12:28:23
 */
public interface SijiItemService {
	
	SijiItemDO get(Long id);

	SijiItemDO getItemDo(Long id);

	
	List<SijiItemDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SijiItemDO sijiItem);
	
	int update(SijiItemDO sijiItem);

	int updateItem(SijiItemDO sijiItem);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	List<Map> querySijiList(Map<String, Object> map);

	int querySijiListCount(Map<String, Object> map);

	int heDui(Long id);

	void importExcel(List<SijiItemImp1> imp1s);
	void importExcel2(List<SijiItemImp2> imp2s);

	void updatePiliang(Map<String, Object> map);
	void updatePiliangSteel(Map<String, Object> map);
	void updatePiliangMemo(Map<String, Object> map);



	Map<String, Object> editPiliang(String ids);



	List<Map> daiduizhanglist(Map<String, Object> map);

	int daiduizhanglistCount(Map<String, Object> map);

}
