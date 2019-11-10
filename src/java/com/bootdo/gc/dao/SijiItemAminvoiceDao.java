package com.bootdo.gc.dao;

import com.bootdo.gc.domain.SijiItemAminvoiceDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-06-02 12:28:23
 */
@Mapper
public interface SijiItemAminvoiceDao {

	SijiItemAminvoiceDO get(Long id);

	SijiItemAminvoiceDO getItemDo(Long id);

	
	List<SijiItemAminvoiceDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SijiItemAminvoiceDO sijiItem);
	
	int update(SijiItemAminvoiceDO sijiItem);

	int updateState(SijiItemAminvoiceDO sijiItem);

	
	int remove(Long id);
	
	int batchRemove(Long[] ids);



	List<Map> querySijiList(Map<String, Object> map);

	int querySijiListCount(Map<String, Object> map);

	int heDui(Long id);


	List<SijiItemAminvoiceDO> getLastAminvoice(Map<String, Object> map);

	List<Map<String, Object>> getIssueoffice(Map<String, Object> map);



	List<SijiItemAminvoiceDO> getBilldateList(Map<String, Object> map);

	List<SijiItemAminvoiceDO> getBilldateArray(Map<String, Object> map);


	List<Map<String, Object>> getInvoiceList(Long id);


}
