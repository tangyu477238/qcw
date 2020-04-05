package com.bootdo.gc.service;

import com.bootdo.gc.domain.SijiItemInvoiceDO;
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
public interface SijiItemInvoiceService {

	SijiItemInvoiceDO get(Long id);

	SijiItemInvoiceDO getItemDo(Long id);


	List<SijiItemInvoiceDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	int save(SijiItemInvoiceDO sijiItem);

	int update(SijiItemInvoiceDO sijiItem);

	int updateItem(SijiItemInvoiceDO sijiItem);

	int remove(Long id);

	int removeAdmin(Long id);

	int batchRemove(Long[] ids);

	List<Map> querySijiList(Map<String, Object> map);

	int querySijiListCount(Map<String, Object> map);

	int heDui(Long id);

	void importExcel(List<SijiItemImp1> imp1s);
	void importExcel2(List<SijiItemImp2> imp2s);

	List<SijiItemInvoiceDO> getInvoiceList(Map<String, Object> map);

	List<SijiItemInvoiceDO> getBilldateList(Map<String, Object> map);

	SijiItemInvoiceDO getBillInfoByPid(String pid);

	SijiItemInvoiceDO getAminvoicefoById(String id);


	void getInvoicedateArray(Map<String, Object> map);
}
