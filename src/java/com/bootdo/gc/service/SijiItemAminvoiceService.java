package com.bootdo.gc.service;

import com.bootdo.gc.domain.SijiItemAminvoiceDO;
import com.bootdo.gc.domain.SijiItemAminvoiceVO;
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
public interface SijiItemAminvoiceService {
	
	SijiItemAminvoiceDO get(Long id);

	SijiItemAminvoiceDO getItemDo(Long id);

	
	List<SijiItemAminvoiceDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SijiItemAminvoiceDO sijiItem);
	
	int update(SijiItemAminvoiceDO sijiItem);

	int updateItem(SijiItemAminvoiceDO sijiItem);
	
	int remove(Long id);

	int removeBill(String id);


	int removeAdmin(Long id);


	int batchRemove(Long[] ids);

	List<SijiItemAminvoiceVO> querySijiList(Map<String, Object> map);

	int querySijiListCount(Map<String, Object> map);

	int heDui(Long id);

	void importExcel(List<SijiItemImp1> imp1s);
	void importExcel2(List<SijiItemImp2> imp2s);

	List<SijiItemAminvoiceDO> getLastAminvoice(Map<String, Object> map);


	SijiItemAminvoiceDO getBillInfoByPid(String pid);

	List<Map<String, Object>> getIssueoffice(Map<String, Object> map);

	List<SijiItemAminvoiceDO> getBilldateList(Map<String, Object> map);
    void getBilldateArray(Map<String, Object> map);



    //对账明细列表
    List<SijiItemAminvoiceDO> getDuizhangList(Map<String, Object> map);
    //对账明细列表
    int getDuizhangListCount(Map<String, Object> map);

}
